package cn.wocding.jdog.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import cn.wocding.jdog.io.HttpOutputStream;
/**
 * 
 * @author wills
 *
 */
public class Response implements HttpServletResponse{
	
	
	private String httpVersion = HttpVersion.HTTP_1_1;
	
	private int status;
	private String characterEncoding;
	private String contentType;
	private int contentLength;
	
	private HashMap<String,String> headers = new HashMap<String, String>();

	private byte[] body;
	
	private HttpOutputStream outputStream = new HttpOutputStream();
	
	private PrintWriter writer;
	

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLength(int len) {
		// TODO Auto-generated method stub
		
	}

	public void setContentType(String type) {
		// TODO Auto-generated method stub
		
	}

	public void setBufferSize(int size) {
		// TODO Auto-generated method stub
		
	}

	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub
		
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub
		
	}

	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public String encodeURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeRedirectURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeRedirectUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendError(int sc, String msg) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendRedirect(String location) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void setDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	public void addDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	public void setHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	public void addHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	public void setIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	public void addIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int sc) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int sc, String sm) {
		// TODO Auto-generated method stub
		
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
