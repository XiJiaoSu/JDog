package cn.wocding.jdog.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestDecoder {
	
	public static Request decoder(Socket socket) throws IOException{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//读取第一行，获取http请求的uri，version，method
		String requestCommends=reader.readLine();
		if (requestCommends==null) {//请求方式，请求uri为空时，返回null
			return null;
		}
		String commands[]=requestCommends.split("\\s");//以空格进行分割
		if (!checkMethodURIProtocol(commands)) {
			return null;
		}
		Request request=new Request();//返回request对象
		request.setMethod(commands[0].toUpperCase());
		request.setRequestURI(commands[1]);
		request.setProtcool(commands[2]);
		//读取request headers
		String line;
		int contentLength=0;
		Map<String,String> headers=new HashMap<String,String>();
		while ((line=reader.readLine())!=null&&!"".equals(line)) {
			int index=line.indexOf(": ");
			if (index<0) {
				continue;
			}
			System.out.println(line);
			if (HttpHeaders.CONTENT_LENGTH.equals(line.substring(0, index+1))) {
				contentLength = Integer.parseInt(line.substring(index+2).trim());
				System.out.println(line.substring(index+2).trim());
			}
		}
		
		socket.shutdownInput();
		return request;
	}
	
	/**
	 * 检测request method，uri，protocol
	 * @param commands
	 * @return
	 */
	private static boolean checkMethodURIProtocol(String []commands){
		if (commands.length!=3) {//格式出错
			return false;
		}
		if (!HttpMethod.isAccept(commands[0])) {//请求方式是否符合
			return false;
		}
		if (commands[1].length()==0) {//请求uri为空
			return false;
		}
		if (commands[2].length()==0) {//http协议有问题
			return false;
		}
		return true;
	}
}
