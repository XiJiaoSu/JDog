package cn.wocding.jdog.http;

/**
 * define http request method
 * @author wills
 *
 */
public enum HttpMethod {
	
	GET,
	POST;
	
	/**
	 * 判断当前的请求方式是否接受
	 * @param method
	 * @return
	 */
	public static boolean isAccept(String method){
		for(HttpMethod hmethod:HttpMethod.values()){
			if (hmethod.name().equals(method.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据string，获取httprequest的请求Method
	 * @param method
	 * @return
	 */
	public static HttpMethod getMethod(String method){
		for(HttpMethod hMethod:HttpMethod.values()){
			if (hMethod.name().equals(method.toUpperCase())) {
				return hMethod;
			}
		}
		return null;
	}
	
}
