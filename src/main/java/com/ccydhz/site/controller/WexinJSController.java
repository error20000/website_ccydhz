
package com.ccydhz.site.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.config.Config;
import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.DateTools;
import com.jian.tools.core.HttpTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;




@Controller
@RequestMapping("/api/wxjs")
@API(info="微信jssdk配置")
public class WexinJSController {
	
	private static String authTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static String appId = "";
	private static String appSecret = "";
	private static String jsTokenUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	private static Map<String, Object> tokenMap = new HashMap<String, Object>();
	private static int expiresTime = 7200;
	private static int jsExpiresTime = 7200;
	private static String noncestr = "123456700";

	public static Config baseConfig = null;
	
	@Autowired
	public void setConfig(Config config){
		WexinJSController.baseConfig = config;
		WexinJSController.appId = config.appId;
		WexinJSController.appSecret = config.appSecret;
	}
	
	/**
	 * 微信分享配置
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/config")
	@API(name="微信分享配置", 
		info="可以热更新配置文件", 
		request={
				@ParamsInfo(name="url", info="网址（必填）")
			}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集")
			})
	public String config(HttpServletRequest request, HttpServletResponse response) {
		String url = Tools.getReqParamSafe(request, "url");//"http://gf.ppgame.com";//Utils.getBsaeUrl(req);// + req.getParameter("url");
		if(Tools.isNullOrEmpty(url)){
			return ResultTools.custom(Tips.ERROR206, "url").toJSONString();
		}
		if(Tools.isNullOrEmpty(appId)){
			return ResultTools.custom(Tips.ERROR200, "appId").toJSONString();
		}
		if(Tools.isNullOrEmpty(appSecret)){
			return ResultTools.custom(Tips.ERROR200, "appSecret").toJSONString();
		}
		
		String timestamp = System.currentTimeMillis()/1000+"";
		String authToken = authToken();
		if(Tools.isNullOrEmpty(authToken)){
			return ResultTools.custom(Tips.ERROR113, "authToken").toJSONString();
		}
		String jsToken = jsToken(authToken);
		if(Tools.isNullOrEmpty(jsToken)){
			return ResultTools.custom(Tips.ERROR113, "jsToken").toJSONString();
		}
		String signParams = "jsapi_ticket=JSAPI_TICKET&noncestr=NONCESTR&timestamp=TIMESTAMP&url=URL";
		String sign = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA1");
			signParams = signParams.replace("JSAPI_TICKET", jsToken).replace("NONCESTR", noncestr).replace("TIMESTAMP", timestamp).replace("URL", url);
			digest.update(signParams.getBytes());
			sign = getFormattedText(digest.digest());
			if("true".equals(baseConfig.jssdkDebug)){
				System.out.println(DateTools.formatDate()+" -- signParams: "+signParams);
				System.out.println(DateTools.formatDate()+" -- sign: "+sign);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("appId", appId);
		map.put("timestamp", timestamp);
		map.put("nonceStr", noncestr);
		map.put("signature", sign);
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, map).toJSONString();
	}
	
	private String authToken(){
		long cur = System.currentTimeMillis()/1000 - expiresTime;
		if(!Tools.isNullOrEmpty(tokenMap.get("expiresTime")) && Tools.parseLong(tokenMap.get("expiresTime")+"") > cur){
			return tokenMap.get("authToken").toString();
		}
		String res = HttpTools.getInstance().sendHttpGet(authTokenUrl.replace("APPID", appId).replace("APPSECRET", appSecret));
		if("true".equals(baseConfig.jssdkDebug)){
			System.out.println(DateTools.formatDate()+" -- authToken: "+res);
		}
		JsonTools.jsonToMap(res).get("access_token");
		String token = (String) JsonTools.jsonToMap(res).get("access_token");
		expiresTime = Tools.parseInt(JsonTools.jsonToMap(res).get("expires_in"));
		tokenMap.put("expiresTime", System.currentTimeMillis()/1000);
		tokenMap.put("authToken", token);
		return token;
	}
	
	private String jsToken(String authToken){
		long cur = System.currentTimeMillis()/1000 - jsExpiresTime;
		if(!Tools.isNullOrEmpty(tokenMap.get("jsExpiresTime")) && Tools.parseLong(tokenMap.get("jsExpiresTime")+"") > cur){
			return tokenMap.get("jsToken").toString();
		}
		String res = HttpTools.getInstance().sendHttpGet(jsTokenUrl.replace("ACCESS_TOKEN", authToken));
		if("true".equals(baseConfig.jssdkDebug)){
			System.out.println(DateTools.formatDate()+" -- jsToken: "+res);
		}
		String token = (String) JsonTools.jsonToMap(res).get("ticket");
		jsExpiresTime = Tools.parseInt(JsonTools.jsonToMap(res).get("expires_in"));
		tokenMap.put("jsExpiresTime", System.currentTimeMillis()/1000);
		tokenMap.put("jsToken", token);
		return token;
	}
	
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuffer buf = new StringBuffer();
		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) { 			
			String shaHex = Integer.toHexString(bytes[j] & 0xFF);
			if (shaHex.length() < 2) {
				buf.append(0);
			}
			buf.append(shaHex);

		}
		return buf.toString();
	}
	
}
