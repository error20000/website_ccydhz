package com.ccydhz.site.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import com.jian.tools.core.HttpTools;

import sun.net.www.http.HttpClient;



public class SmsGateWay {
	public static String testurl = "http://113.31.25.56:23000";
	public static String url = "http://fee.arc-soft.com:23000";
	public static boolean isTesting = false;
	public static final int merc_id = 2000501;
	public static final String merc_key = "655d2fea913a3d28909ef48843b7a9c1";
	public static final String app_id = "63848ee65cd411e88d32c6a10b512583";
	public static final String api = "/sdkfee/sms/mt";
	public static final Random random = new Random(System.currentTimeMillis());
	public static boolean sendSms(String phoneNum,String sms){
		long now = System.currentTimeMillis();
		String orderId = now+ "" + (random.nextInt(899999) + 100000);
		Map<String,String> map = new HashMap<String,String>();
		map.put("merc_id", merc_id+"");
		map.put("app_id", app_id);
		map.put("app_oid", orderId);
		map.put("api_type",1+"");
		map.put("phone", phoneNum);
		map.put("sms",sms);
		map.put("ver", "1.0");
		map.put("time",now+"");
		String md5Source = buildSignParamStr(map,merc_key);
		String sign = hash(md5Source);
		map.put("sign",sign);
		System.out.println("手机号:" + phoneNum +"内容:" + sms +"md5Soure:" +  md5Source +"签名:" + sign);
		String webUrl = (isTesting ? testurl : url) + api;
		String content = "";
		try {
	    	/*HttpClient client = new HttpClient();
	    	PostMethod postRequest = new PostMethod(webUrl);
	    	postRequest.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8"); 
	    	for (String key : map.keySet()) {
	    		postRequest.addParameter(key, map.get(key));
	    	}
	    	client.executeMethod(postRequest);
			content = postRequest.getResponseBodyAsString();*/
			content = HttpTools.getInstance().sendHttpGet(webUrl+"?"+md5Source+"&sign="+sign);
			System.out.println(content);
		}catch(Exception e){
//			logger.error("发送短信失败 [手机号:{}] [内容:" + sms +"] [orderId:" + orderId+"]",e);/
			
		}
		if (!content.isEmpty()) {
			//logger.info("[发送短信成功] [手机号:{}] [内容:{}] [content:{}] [orderId:{}] [是否测试:{}] [cost:{}ms] ",new Object[]{phoneNum,sms,content,orderId,isTesting,(System.currentTimeMillis() - now)});
			return true;
		} else {
			//logger.warn("[发送短信失败] [手机号:{}] [内容:{}] [orderId:{}] [是否测试:{}] [cost:{}ms]",new Object[]{phoneNum,sms,orderId,isTesting,(System.currentTimeMillis() - now)});
			return false;
		}
	}
	public static final String toHex(byte hash[]) {
		StringBuffer buf = new StringBuffer(hash.length * 2);
		int i;

		for (i = 0; i < hash.length; i++) {
			if (((int) hash[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) hash[i] & 0xff, 16));
		}
		return buf.toString();
	}
	public synchronized static final String hash(String data) {
		/**
		 * Used by the hash method.
		 */
		MessageDigest digest = null;
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				System.err.println("Failed to load the MD5 MessageDigest. "
						+ "Jive will be unable to function normally.");
				nsae.printStackTrace();
			}
		}
		// Now, compute hash.
		digest.update(data.getBytes());
		return toHex(digest.digest());
	}
	public static void main(String args[]){
		//sendSms("15101013306","验证码:4305,如非您本人操作请忽略.");
//		String sign = "035a07a5575e90a75aeb5f25204b7538";
//		String md5Source = "";
//		try {
//			md5Source = "api_type=1&app_id=63848ee65cd411e88d32c6a10b512583&merc_id=2000501&merc_key=655d2fea913a3d28909ef48843b7a9c1&phone=15101013306&sms=sss&ver=1.0";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(md5Source);
//		System.out.println(StringUtil.hash(md5Source.toLowerCase()));
	}
	public static String buildSignParamStr(Map<String,String> sortedMap,String md5key){
        SortedMap<String,String> map = new TreeMap<String, String>();
        map.put("merc_key",md5key);
        for(String pname:sortedMap.keySet()){
            map.put(pname,sortedMap.get(pname));
        }

        StringBuilder sb = new StringBuilder(500);
        for(String pname:map.keySet()){
            if("sign".equals(pname)){
                continue;
            }
            sb.append(pname).append("=").append(map.get(pname)).append("&");
        }
        sb = sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
