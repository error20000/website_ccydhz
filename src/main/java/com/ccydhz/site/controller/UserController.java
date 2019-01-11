package com.ccydhz.site.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.CacheObject;
import com.jian.tools.core.CacheTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;
import com.ccydhz.site.config.Config;
import com.ccydhz.site.entity.User;
import com.ccydhz.site.service.UserService;
import com.ccydhz.site.util.Utils;

@Controller
@RequestMapping("/api/user")
@API(info="", entity={User.class})
public class UserController extends BaseController<User> {

	@Autowired
	private UserService service;
	@Autowired
	private Config baseConfig;
	
	@Override
	public void initService() {
		super.service = service;
	}
	
	//TODO 基本方法
	
	@Override
	@RequestMapping("/add")
    @ResponseBody
	@API(name="新增", 
		info="需登录认证", 
		request={
				//add request
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码（md5）"),
				@ParamsInfo(name="system", type="int", isNull=0,  info="超管  0--否 1--是"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
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
		//权限
		vMap = verifyAuth(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//保存
		User obj = Tools.getReqParamsToObject(req, new User());
		obj.setPassword(Tools.md5(obj.getPassword()));
		obj.setSystem(0);
		int res = service.add(obj);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}


	@Override
	@RequestMapping("/update")
    @ResponseBody
	@API(name="修改", 
		info="需登录认证", 
		request={
				//modify request
				@ParamsInfo(info="修改条件："),
				@ParamsInfo(name="pid", type="int", isNull=1,  info="自增主键"),
				@ParamsInfo(info="可修改字段："),
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码（md5）"),
				@ParamsInfo(name="system", type="int", isNull=0,  info="超管  0--否 1--是"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
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
		//权限
		vMap = verifyAuth(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		List<String> pkeys = Utils.getPrimaryKeys(User.class);//获取主键
		if(pkeys == null || pkeys.isEmpty()){
			return ResultTools.custom(Tips.ERROR206).toJSONString();
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		for (String str : pkeys) {
			String strv = Tools.getReqParamSafe(req, str);
			vMap = Tools.verifyParam(str, strv, 0, 0);
			if(vMap != null){
				return ResultTools.custom(Tips.ERROR206, str).toJSONString();
			}
			condition.put(str, strv);
		}
		//检测重复
		String username = Tools.getReqParamSafe(req, "username");
		User old = service.findOne(condition);
		if(old == null){
			return ResultTools.custom(Tips.ERROR106).toJSONString();
		}
		User test = service.findOne(MapTools.custom().put("username", username).build());
		if(test != null && old.getPid() != test.getPid()){
			return ResultTools.custom(Tips.ERROR105, "username").toJSONString();
		}
		Map<String, Object> setValues = Tools.getReqParamsToMap(req, User.class);
		//修改密码
		if(!old.getPassword().equals(setValues.get("password"))){
			setValues.put("password", Tools.md5(setValues.get("password")+""));
		}
		if(old.getSystem() == 1){
			setValues.put("system", 1);
			setValues.put("status", 1);
		}else{
			setValues.put("system", 0);
		}
		
		//保存
		int res = service.modify(setValues, condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
	}

	@Override
	@RequestMapping("/delete")
    @ResponseBody
	@API(name="删除", 
		info="需登录认证", 
		request={
				//delete request
				@ParamsInfo(name="pid", type="int", isNull=1,  info="自增主键"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String delete(HttpServletRequest req) {
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
		//权限
		vMap = verifyAuth(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		List<String> pkeys = Utils.getPrimaryKeys(User.class);//获取主键
		if(pkeys == null || pkeys.isEmpty()){
			return ResultTools.custom(Tips.ERROR206).toJSONString();
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		for (String str : pkeys) {
			String strv = Tools.getReqParamSafe(req, str);
			vMap = Tools.verifyParam(str, strv, 0, 0);
			if(vMap != null){
				return ResultTools.custom(Tips.ERROR206, str).toJSONString();
			}
			condition.put(str, strv);
		}
		//检查
		User old = service.findOne(condition);
		if(old.getSystem() == 1){
			return ResultTools.custom(Tips.ERROR104, "系统管理员不能删除。").toJSONString();
		}
		//保存
		int res = service.delete(condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
	}

	@Override
	@RequestMapping("/findPage")
    @ResponseBody
	@API(name="分页查询", 
		info="需登录认证", 
		request={
				@ParamsInfo(name="page", type="int", isNull=1, info="页码"),
				@ParamsInfo(name="rows", type="int", isNull=1, info="每页条数"),
				//findPage request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码（md5）"),
				@ParamsInfo(name="system", type="int", isNull=0,  info="超管  0--否 1--是"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
				@ParamsInfo(name=ResultKey.TOTAL, type="int", info="总数"),
		})
	public String findPage(HttpServletRequest req) {
		return super.findPage(req);
	}

	@Override
	@RequestMapping("/findOne")
    @ResponseBody
	@API(name="查询一个", 
		info="需登录认证", 
		request={
				//findOne request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码（md5）"),
				@ParamsInfo(name="system", type="int", isNull=0,  info="超管  0--否 1--是"),
				@ParamsInfo(info="注意：以上条件不可同时为空。"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Object", info="数据集"),
		})
	public String findOne(HttpServletRequest req) {
		return super.findOne(req);
	}

	@Override
	@RequestMapping("/findList")
    @ResponseBody
	@API(name="查询多个", 
		info="需登录认证", 
		request={
				//findList request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码（md5）"),
				@ParamsInfo(name="system", type="int", isNull=0,  info="超管  0--否 1--是"),
				@ParamsInfo(info="注意：以上条件不可同时为空。"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
	public String findList(HttpServletRequest req) {
		return super.findList(req);
	}
	
	//TODO 自定义方法
	
	@RequestMapping("/login")
    @ResponseBody
	@API(name="登录", 
		info="", 
		request={
				@ParamsInfo(name="username", type="String", isNull=0,  info="用户名"),
				@ParamsInfo(name="password", type="String", isNull=0,  info="密码"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
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
			return ResultTools.custom(Tips.ERROR206, "username").toJSONString();
		}
		vMap = Tools.verifyParam("password", password, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "password").toJSONString();
		}
		
		//检查
		User user = service.findOne(MapTools.custom().put("username", username).build());
		if(user == null){
			return ResultTools.custom(Tips.ERROR109).toJSONString();
		}
		if(user.getStatus() == 0){
			return ResultTools.custom(Tips.ERROR107, "账号").toJSONString();
		}
		if(!user.getPassword().equals(Tools.md5(password))){
			//限制错误次数
			String ckey = "user_"+user.getPid();
			CacheObject cobj = CacheTools.getCacheObj(ckey);
			if(cobj == null){
				CacheTools.setCacheObj(ckey, 10 - 1);
			}else{
				int loinTime = Tools.parseInt(cobj.getValue()+"");
				loinTime--;
				if(loinTime <= 0){
					user.setStatus(0);
					service.modify(user);
					CacheTools.clearCacheObj(ckey); //解除禁用
				}else{
					CacheTools.setCacheObj(ckey, loinTime);
				}
			}
			return ResultTools.custom(Tips.ERROR110).toJSONString();
		}
		
		//保存
		HttpSession session = req.getSession();
		session.setAttribute(baseConfig.login_session_key, user);
		
		user.setPassword("");
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, user).toJSONString();
	}
	
	@RequestMapping("/logout")
    @ResponseBody
	@API(name="退出", 
		info="", 
		request={
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
	public String logout(HttpServletRequest req) {
		//保存
		HttpSession session = req.getSession();
		session.removeAttribute(baseConfig.login_session_key);
		
		return ResultTools.custom(Tips.ERROR1).toJSONString();
	}
	
	@RequestMapping("/isLogin")
    @ResponseBody
	@API(name="检查登录", 
		info="", 
		request={
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
	public String isLogin(HttpServletRequest req) {
		//保存
		HttpSession session = req.getSession();
		Object test = session.getAttribute(baseConfig.login_session_key);
		if(test == null){
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}else {
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}
	}
	
	@RequestMapping("/changePWD")
    @ResponseBody
	@API(name="修改密码", 
		info="需登录", 
		request={
				@ParamsInfo(name="oldPwd", type="String", isNull=0,  info="旧密码"),
				@ParamsInfo(name="newPwd", type="String", isNull=0,  info="新密码"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String changePWD(HttpServletRequest req) {
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

		User loginUser = getUserInfo(req, User.class);
		if(loginUser == null){
			return ResultTools.custom(Tips.ERROR111).toJSONString();
		}
		
		//参数
		String oldPwd = Tools.getReqParamSafe(req, "oldPwd");
		String newPwd = Tools.getReqParamSafe(req, "newPwd");
		vMap = Tools.verifyParam("oldPwd", oldPwd, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "oldPwd").toJSONString();
		}
		vMap = Tools.verifyParam("newPwd", newPwd, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "newPwd").toJSONString();
		}
		
		User test = service.findOne(MapTools.custom().put("pid",loginUser.getPid()).build());
		if(!test.getPassword().equals(Tools.md5(oldPwd))){
			return ResultTools.custom(Tips.ERROR213, "密码").toJSONString();
		}
		
		//保存
		int res = service.modify(MapTools.custom().put("password", Tools.md5(newPwd)).build(), MapTools.custom().put("pid", loginUser.getPid()).build());
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
	}
	
}
