package com.ccydhz.site.config;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jian.tools.core.HttpTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;

@Component
public class VerifyConfig {
	
	public static String loginUserKey = "";
	public static String ssoUrl = "";
	
	public static Config baseConfig = null;
	
	@Autowired
	public void setConfig(Config config){
		VerifyConfig.baseConfig = config;
		VerifyConfig.loginUserKey = config.login_session_key;
		VerifyConfig.ssoUrl = config.login_session_key;
	}
	
	/**
	 * 登录验证
	 * @param req
	 * @return 通过返回null
	 */
	public static Map<String, Object> verifyLogin(HttpServletRequest req){
		if(Tools.isNullOrEmpty(ssoUrl)){
			//本地session验证.
			return verifyLoginNormal(req);
		}else{
			//单点登录验证.
			return verifyLoginSSO(req);
		}
//		return null; 
	}
	
	/**
	 * 参数签名验证
	 * @param req
	 * @return 通过返回null
	 */
	public static Map<String, Object> verifySign(HttpServletRequest req){
		//TODO do something
		
		return null;
	}

	/**
	 * 获取登录用户信息
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getUserInfo(HttpServletRequest req, Class<T> clss){
		//获取sso用户信息，注意这里是sso用户，可能需要转换成自己项目的用户
		HttpSession session = req.getSession();
		Object user = session.getAttribute(loginUserKey);
		if(user == null){
			return null;
		}
		if(Tools.isNullOrEmpty(ssoUrl)){
			//本地session验证.
			return (T) user;
		}else{
			//单点登录验证.
			//TODO do change
			
			return null;
		}
		
	}
	
	private static Map<String, Object> verifyLoginNormal(HttpServletRequest req){
		HttpSession session = req.getSession();
		Object temp = session.getAttribute(loginUserKey);
		if(temp == null){
			return ResultTools.custom(Tips.ERROR111).build();
		}
		return null;
	}
	
	private static Map<String, Object> verifyLoginSSO(HttpServletRequest req){
		//缓存在session
		HttpSession session = req.getSession();
		Object temp = session.getAttribute(loginUserKey);
		if(temp != null){
			return null;
		}
		//sso
		String token = getToken(req);
		String host = req.getHeader("host");
		
		if(Tools.isNullOrEmpty(token)){
			return ResultTools.custom(Tips.ERROR111).build();
		}
		String res = HttpTools.getInstance().sendHttpGet(ssoUrl + "/api/user/userAuth?token="+token+"&host="+host);
		
		Map<String, Object> map = new HashMap<>();
		try {
			map = JsonTools.jsonToMap(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(map.get("code") == null || Tools.parseInt(map.get("code") + "") != 1){
			return map;
		}else{
			//保存用户
			Map<String, Object> data = JsonTools.jsonToMap(JsonTools.toJsonString(map.get("data")));
			if(data != null){
				Map<String, Object> user =JsonTools.jsonToMap(JsonTools.toJsonString(data.get("user")));
				if(user != null){
					session.setAttribute(loginUserKey, user);
				}
			}
		}
		
		return null;
	}
	
	private static String getToken(HttpServletRequest req){
//		String tokenStr = Tools.isNullOrEmpty(req.getHeader("token")) ? Tools.getReqParamSafe(req, "token") : req.getHeader("token"); 
		//读取cookie
		String tokenStr = "";
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for (int i = 0; i < cookies.length; i++) {
				Cookie tmp = cookies[i];
				if("token".equals(tmp.getName())){
					tokenStr = tmp.getValue();
					break;
				}
			}
		}
		return tokenStr;
	}
	
}
