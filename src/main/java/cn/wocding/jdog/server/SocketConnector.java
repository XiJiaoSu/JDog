package cn.wocding.jdog.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.apache.log4j.Logger;

import cn.wocding.jdog.http.HttpRequestDecoder;
import cn.wocding.jdog.http.Request;
import cn.wocding.jdog.io.bio.SocketEndPoint;

/**
 * 用于socket server启动，监听
 * @author wills
 *
 */
public class SocketConnector {

	private static final Logger logger=Logger.getLogger(SocketConnector.class);
	
	private ThreadPool threadPool;
	
	protected ServerSocket serverSocket;
	
	private int acceptQueueSize = 50;
	
	private volatile boolean start=true;
	
	public SocketConnector() {
	
	}
	/**
	 * 开启端口监听
	 * @param port
	 * @throws Exception 
	 */
	public void open(int port) throws Exception{
		if (serverSocket==null||serverSocket.isClosed()) {
			serverSocket=newServerSocket(null, port, acceptQueueSize);
		}
	}
	protected ServerSocket newServerSocket(String host, int port,int backlog) throws IOException{
	    ServerSocket ss= host==null?
	        new ServerSocket(port,backlog):
	        new ServerSocket(port,backlog,InetAddress.getByName(host));
	    return ss;
	}
	
	public void accept() throws IOException {
		logger.info("Server started ...");
		while(start){
			Socket socket = serverSocket.accept();//等待 连接建立
			new ConnectorEndPoint(socket).dispatch();
		}
	}
	
	public void setThreadPool(ThreadPool threadPool) {
		this.threadPool = threadPool;
	}

	/**
	 * 
	 * @author wills
	 *
	 */
	protected class ConnectorEndPoint extends SocketEndPoint implements Runnable{
		
		public ConnectorEndPoint(Socket socket) throws SocketException {
			super(socket);
			socket.setSoTimeout(8000);
		}
		
		public void dispatch(){
			threadPool.dispatch(this);
		}
		
		public void run() {
			try {
				System.out.println("---------------------");
				Request request = HttpRequestDecoder.decoder(socket);
				//to be done
			    OutputStream outputStream = socket.getOutputStream();
			    StringBuilder headers = new StringBuilder();
			    headers.append("http/1.1 200 OK \r\n");
			    headers.append("Content-Type: text/html;charset=utf-8\r\n");
			    headers.append("\r\n");
			    outputStream.write(headers.toString().getBytes());
			    outputStream.write("<h1>hello jdog</h1>".getBytes());
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
