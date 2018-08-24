package cn.wocding.jdog.http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import cn.wocding.jdog.io.HttpOutputStream;
import cn.wocding.jdog.utils.StringUtils;
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
	
	
	//setter and getter
	public String getHttpVersion() {
		return httpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCharacterEncoding() {
		return characterEncoding;
	}

	public String getContentType() {
		return contentType;
	}

	public Locale getLocale() {
		return Locale.getDefault();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return outputStream;
	}

	public PrintWriter getWriter() throws IOException {
		if (writer == null) {
            String encoding = characterEncoding;

            if (encoding == null){
                encoding = StringUtils.__ISO_8859_1;
                setCharacterEncoding(encoding);
            }
           writer = new PrintWriter(new OutputStreamWriter(outputStream, Charset.forName(characterEncoding)));
		}
		return writer;
	}

	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setCharacterEncoding(String encode) {
		this.characterEncoding = encode;
	}

	public void setContentLength(int length) {
		this.contentLength = length;
	}

	public void setContentType(String type) {
		this.contentType = type;
	}

	public void setLocale(Locale locale) {
		// TODO Auto-generated method stub
	}

	public void addCookie(Cookie arg0) {
		// TODO Auto-generated method stub
		
	}

	public void addDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public String encodeRedirectURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeRedirectUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendError(int arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendError(int arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendRedirect(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void setDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	public int getContentLength() {
		return contentLength;
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
