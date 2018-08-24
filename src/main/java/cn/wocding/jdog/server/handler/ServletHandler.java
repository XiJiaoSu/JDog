package cn.wocding.jdog.server.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wocding.jdog.http.HttpMethod;
import cn.wocding.jdog.http.Response;
import cn.wocding.jdog.servlet.DefaultServlet;

public class ServletHandler {

	
	
	public static HttpServletResponse dispatchServlet(String url, HttpServletRequest request, HttpMethod method) 
			throws ServletException, IOException {
		HttpServletResponse response=new Response();
		HttpServlet defaultServerlet=new DefaultServlet();
		defaultServerlet.service(request, response);
		
		return response;
	}
}
