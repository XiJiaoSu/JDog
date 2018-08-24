package cn.wocding.jdog.http;

import org.apache.log4j.Logger;

public enum MimeTypes {
	
	FORM_ENCODED("","application/x-www-form-urlencoded"),
	
	//text
	TEXT_HTM(".htm","text/html"),
	TEXT_HTML(".html","text/html"),
	TEXT_PLAIN(".txt","text/plain"),
	TEXT_XML(".xml","text/xml"),
	TEXT_XSL(".xsl","text/xml"),
	TEXT_JSON(".json","text/json"),
	TEXT_CSS(".css","text/css"),
	
	//image
	IMAGE_GIF(".gif","image/gif"),
	IMAGE_JPG(".jpg","image/jpeg"),
	IMAGE_PNG(".png","image/png"),
	IMAGE_BMP(".bmp","image/bmp"),
	
	//javascript
	APPLICATION_JS(".js","application/javascript"),
	
	//oct
	APPLICATION_OCTET("","application/octet-stream");
	
	private static final Logger log = Logger.getLogger(MimeTypes.class);
	
	private MimeTypes(String postfix, String type){
		this.postfix = postfix;
		this.type = type;
	}
	
	private final String postfix;
	private final String type;
	
	public String getType(){
		return type;
	}
	public static String getType(String postfix){
		for(MimeTypes entry : MimeTypes.values()){
			if(entry.postfix.equals(postfix)){
				return entry.type;
			}
		}
		log.error("Unknow resource type : "+postfix);
		return APPLICATION_OCTET.type;
	}
	
}
