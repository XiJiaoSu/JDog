package cn.wocding.jdog.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import cn.wocding.jdog.http.HttpRequestDecoder;
import cn.wocding.jdog.http.Request;
import cn.wocding.jdog.http.Response;
import cn.wocding.jdog.io.bio.SocketEndPoint;
import cn.wocding.jdog.server.handler.ResourceHandler;
import cn.wocding.jdog.servlet.DefaultServlet;
import cn.wocding.jdog.utils.StringUtils;

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
	
	//test defaultServlet : to be done
	private HttpServlet defaultServerlet=new DefaultServlet();
	
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
				Request request = HttpRequestDecoder.decoder(socket);
				
				Response response=ResourceHandler.Handler(request);
				
			    OutputStream out = socket.getOutputStream();
			    StringBuilder headers = new StringBuilder();
			    headers.append(response.getHttpVersion()+" "+response.getStatus()+" OK"+StringUtils.CRLF);
			    for (Entry<String, String> header:response.getHeaders().entrySet()) {
					headers.append(header.getKey() + ": " + header.getValue() + StringUtils.CRLF);
				}
			    //添加返回内容， 空格
			    headers.append(StringUtils.CRLF);
			    out.write(headers.toString().getBytes());
			    if (response.getBody()!=null) {
			    	out.write(response.getBody());
				}
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
