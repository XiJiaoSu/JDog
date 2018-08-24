package cn.wocding.jdog.io.bio;

import java.net.Socket;

import cn.wocding.jdog.io.EndPoint;

public class SocketEndPoint implements EndPoint{
	
	protected final Socket socket;
	

	public SocketEndPoint(Socket socket) {
		super();
		this.socket = socket;
	}
	

	
}
