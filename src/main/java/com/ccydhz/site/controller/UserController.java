package com.ccydhz.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.entity.User;
import com.ccydhz.site.service.LoginService;
import com.ccydhz.site.service.UserService;
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
		if(!Tools.isNullOrEmpty(obj.getPassword())){
			obj.setPassword(Tools.md5(obj.getPassword()));
		}
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
		if(!Tools.isNullOrEmpty(obj.getPassword())){
			obj.setPassword(Tools.md5(obj.getPassword()));
		}
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
		//	检查重复
		if(!Tools.isNullOrEmpty(setValues.get("username")) && !old.getUsername().equals(setValues.get("username")) ){
			User test = service.findOne(MapTools.custom().put("username", setValues.get("username")).build());
			if(test != null){
				return ResultTools.custom(Tips.ERROR105, "username").toJSONString();
			}
		}
		//	修改密码
		if(isSystem(luser) && !Tools.isNullOrEmpty(setValues.get("password")) && !old.getPassword().equals(setValues.get("password")) ){
			setValues.put("password", Tools.md5(setValues.get("password")+"") );
		}
		//	如果登录人不是超管，则不能修改超管
		if(!isSystem(luser) && old.getSystem() != 1){
			setValues.put("system", 0);
		}
		int res = service.modify(setValues, condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
	}

	@RequestMapping("/pwd")
    @ResponseBody
    public String pwd(HttpServletRequest req) {
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
		String oldPwd = Tools.getReqParamSafe(req, "oldPwd");
		String newPwd = Tools.getReqParamSafe(req, "newPwd");
		vMap = Tools.verifyParam("oldPwd", oldPwd, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("newPwd", newPwd, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		User old = service.findOne(MapTools.custom().put("pid", luser.getPid()).build());
		if(!old.getPassword().equalsIgnoreCase(Tools.md5(oldPwd))){
			return ResultTools.custom(Tips.ERROR110).toJSONString();
		}
		old.setPassword(Tools.md5(newPwd));
		int res = service.modify(old);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
    }


	@RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//参数
		String username = Tools.getReqParamSafe(req, "username");
		String password = Tools.getReqParamSafe(req, "password");
		vMap = Tools.verifyParam("username", username, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("password", password, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		User obj = service.findOne(MapTools.custom().put("username", username).build());
		if(obj == null){
			return ResultTools.custom(Tips.ERROR109).toJSONString();
		}
		if(!obj.getPassword().equalsIgnoreCase(Tools.md5(password))){
			return ResultTools.custom(Tips.ERROR110).toJSONString();
		}
		obj.setPassword("");
		//保存
		HttpSession session = req.getSession();
		session.setAttribute(LoginService.loginUserKey, obj);
		
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, obj).toJSONString();
    }

	
	@RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.removeAttribute(LoginService.loginUserKey);
		
        return ResultTools.custom(Tips.ERROR1).toJSONString();
    }
	
	private boolean isSystem(User user){
		return user.getSystem() == 1;
	}
	
	
}
