package cn.wocding.jdog.http;

/**
 * http 请求与响应头
 * @author wills
 *
 */
public class HttpHeaders {
	/** General Fields.
     */
    public final static String 
        CONNECTION= "Connection",
        CACHE_CONTROL= "Cache-Control",
        DATE= "Date";
	
    /** Entity Fields.
     */
    public final static String ALLOW= "Allow",
        CONTENT_ENCODING= "Content-Encoding",
        CONTENT_LANGUAGE= "Content-Language",
        CONTENT_LENGTH= "Content-Length",
        CONTENT_LOCATION= "Content-Location",
        CONTENT_TYPE= "Content-Type",
        EXPIRES= "Expires",
        LAST_MODIFIED= "Last-Modified";
    
	/** Request Fields.
     */
	public final static String 
		ACCEPT= "Accept",
	    ACCEPT_ENCODING= "Accept-Encoding",
	    ACCEPT_LANGUAGE= "Accept-Language",
	    HOST= "Host",
	    USER_AGENT= "User-Agent",
		IF_MODIFIED_SINCE= "If-Modified-Since",
        IF_NONE_MATCH= "If-None-Match",
        IF_RANGE= "If-Range",
        IF_UNMODIFIED_SINCE= "If-Unmodified-Since",
        KEEP_ALIVE= "Keep-Alive",
		REFERER= "Referer",
        X_FORWARDED_FOR= "X-Forwarded-For",
        X_FORWARDED_PROTO= "X-Forwarded-Proto",
        X_FORWARDED_SERVER= "X-Forwarded-Server",
        X_FORWARDED_HOST= "X-Forwarded-Host";
	    
	/**
	 * Response Fields
	 */
	 public final static String ACCEPT_RANGES= "Accept-Ranges",
		AGE= "Age",
		ETAG= "ETag",
		LOCATION= "Location",
		PROXY_AUTHENTICATE= "Proxy-Authenticate",
		RETRY_AFTER= "Retry-After",
		SERVER= "Server",
		SERVLET_ENGINE= "Servlet-Engine",
		VARY= "Vary",
		WWW_AUTHENTICATE= "WWW-Authenticate";
	
    /** Other Fields.
     */
    public final static String COOKIE= "Cookie",
        SET_COOKIE= "Set-Cookie",
        SET_COOKIE2= "Set-Cookie2",
        MIME_VERSION= "MIME-Version",
        IDENTITY= "identity";
}
