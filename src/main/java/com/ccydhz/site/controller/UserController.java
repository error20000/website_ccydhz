package com.ccydhz.site.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.entity.User;
import com.ccydhz.site.service.UserService;
import com.jian.tools.core.HttpTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;

@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController<User> {

	@Autowired
	private UserService service;
	
	@Override
	public void initService() {
		super.service = service;
	}
	
	

	@Override
	public String add(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//登录
		vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		User luser = getUserInfo(req);
		
		//保存
		Map<String, Object> tmp = Tools.getReqParamsToMap(req);
		User obj = JsonTools.jsonToObj(JsonTools.toJsonString(tmp), User.class);
		//检查重复
		User test = service.findOne(MapTools.custom().put("username", obj.getUsername()).build());
		if(test != null){
			return ResultTools.custom(Tips.ERROR105, "username").toJSONString();
		}
		// 如果登录人不是超管，则不能加超管
		if(!isSystem(luser)){
			obj.setSystem(0);
		}
		obj.setPassword(Tools.md5(obj.getPassword()));
		int res = service.add(obj);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}



	@Override
	public String add2(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//登录
		vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		User luser = getUserInfo(req);
		
		//保存
		Map<String, Object> tmp = Tools.getReqParamsToMap(req);
		User obj = JsonTools.jsonToObj(JsonTools.toJsonString(tmp), User.class);
		//检查重复
		User test = service.findOne(MapTools.custom().put("username", obj.getUsername()).build());
		if(test != null){
			return ResultTools.custom(Tips.ERROR105, "username").toJSONString();
		}
		// 如果登录人不是超管，则不能加超管
		if(!isSystem(luser)){
			obj.setSystem(0);
		}
		obj.setPassword(Tools.md5(obj.getPassword()));
		User res = service.add2(obj);
		if(res != null){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}



	@Override
	public String update(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//登录
		vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		User luser = getUserInfo(req);
		
		//参数
		String pid = Tools.getReqParamSafe(req, "pid");
		vMap = Tools.verifyParam("pid", pid, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//保存
		Map<String, Object> setValues = Tools.getReqParamsToMap(req, User.class);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("pid", pid);
		User old = service.findOne(condition);
		//检查重复
		if(!Tools.isNullOrEmpty(setValues.get("username")) && !old.getUsername().equals(setValues.get("username")) ){
			User test = service.findOne(MapTools.custom().put("username", setValues.get("username")).build());
			if(test != null){
				return ResultTools.custom(Tips.ERROR105, "username").toJSONString();
			}
		}
		//修改密码
		if(isSystem(luser) && !Tools.isNullOrEmpty(setValues.get("password")) && !old.getPassword().equals(setValues.get("password")) ){
			setValues.put("password", Tools.md5(setValues.get("password")+"") );
		}
		
		int res = service.modify(setValues, condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
	}



	@RequestMapping("/info")
    @ResponseBody
    public String view(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//登录
		vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		String staffId = getUserStaffId(req);
		MenuAdmin admin = isSuper(staffId);
		Map<String, Object> res = MapTools.custom()
				.put("staffId", Tools.isNullOrEmpty(staffId)? "" : staffId)
				.put("name", Tools.isNullOrEmpty(staffId)? "" : getUserName(staffId))
				.put("admin", admin == null ? -1 : admin.getAdmin())
				.build();
		
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
    }

	
	@RequestMapping("/all")
    @ResponseBody
    public String all(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//登录
		vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, getAllInfo()).toJSONString();
    }
	
	private boolean isSystem(User user){
		return user.getSystem() == 1;
	}
	
	private String getUserName(String staffId){
		String url = SSOConfig.sso_url + "/api/qwx/getUserInfo?userId="+staffId;
		String res = HttpTools.getInstance().sendHttpGet(url);
		if(Tools.isNullOrEmpty(res)){
			return "";
		}else{
			Map<String, Object> data = JsonTools.jsonToMap(JsonTools.toJsonString(JsonTools.jsonToMap(res).get("data")));
			return data.get("name")+"";
		} 
	}
	
	public List<Map<String, Object>> getAllInfo(){
		
		//从企业微信拉取 ，时间需要 1min
		RequestConfig requestConfig = RequestConfig.custom()
	            .setSocketTimeout(2 * 60 * 1000)
	            .setConnectTimeout(2 * 60 * 1000)
	            .setConnectionRequestTimeout(2 * 60 * 1000)
	            .build();
		HttpGet httpGet = new HttpGet(SSOConfig.sso_url + "/api/qwx/getAllUserInfo");
		String res = Utils.sendHttpGet(httpGet, requestConfig);
		
		if(Tools.isNullOrEmpty(res)){
			return null;
		}else{
			return JsonTools.jsonToList(JsonTools.toJsonString(JsonTools.jsonToMap(res).get("data")));
		} 
	}
	
}
