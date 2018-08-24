package cn.wocding.jdog.server.handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import cn.wocding.jdog.http.HttpHeaders;
import cn.wocding.jdog.http.HttpMethod;
import cn.wocding.jdog.http.MimeTypes;
import cn.wocding.jdog.http.Request;
import cn.wocding.jdog.http.Response;
import cn.wocding.jdog.io.HttpOutputStream;
import cn.wocding.jdog.resource.Resource;

public class ResourceHandler {

	public static Response Handler(Request request) throws IOException {

		Response response = null;
		String resUrl = request.getRequestURI();
		if (resUrl.equals("/")) {
			resUrl = "/index.html";
		}
		//转发到不同的servlet中
		try {
			response = (Response) ServletHandler.dispatchServlet(resUrl, request,
					HttpMethod.getMethod(request.getMethod()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(response == null) {
			response = new Response();
			Resource resource =  new Resource(new File("./" + resUrl), resUrl);
//			Resource resource = new Resource(new File(resourceBase + resUrl), resUrl);
			
			if( !resource.exists() ) {
				response.setStatus(404);
				return response;
			}
			
		}else {
			HashMap<String, String> headers = response.getHeaders();
			String contentType = response.getContentType();
			if(contentType == null) {
				String encoding = response.getCharacterEncoding();
				if(encoding != null) {
					headers.put(HttpHeaders.CONTENT_TYPE, MimeTypes.TEXT_HTML.getType() + "; " + encoding);
				}
			}
			byte[] outBytes = ((HttpOutputStream) response.getOutputStream()).getOut().toByteArray();
			response.setBody(outBytes);
			headers.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(outBytes.length));
		}
		configGeneralHeaders(response);
		response.setStatus(200);
		return response;
	}
	private static void configGeneralHeaders(Response response) {
		HashMap<String, String> headers = response.getHeaders();
//		headers.put(HttpHeaders.CONNECTION, "Keep-Alive");
//		headers.put(HttpHeaders.SERVER, SvrCfgUtil.SERVER_NAME);
//		headers.put(HttpHeaders.DATE, GMT_SDF.format(new Date()));
//		headers.put(HttpHeaders.CACHE_CONTROL, "private");
	}
}
