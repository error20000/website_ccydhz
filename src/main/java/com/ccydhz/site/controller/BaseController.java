package com.ccydhz.site.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.entity.User;
import com.ccydhz.site.service.BaseService;
import com.ccydhz.site.service.LoginService;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;

public abstract class BaseController<T> {
	
	protected BaseService<T> service;
	
	public BaseController(){
		super();
		initService();
	}

	public abstract void initService();

	//登录验证
	public static Map<String, Object> verifyLogin(HttpServletRequest req){
		
		return LoginService.verifyLogin(req);
	}
	
	//sign验证
	public static Map<String, Object> verifySign(HttpServletRequest req){
		
		return null;
	}
	
	//获取用户信息
	public static User getUserInfo(HttpServletRequest req){
		return JsonTools.jsonToObj(LoginService.getUserInfo(req), User.class) ;
	}
	
	
	@RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest req) {
		initService();
		
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
		
		//保存
		try {
			Map<String, Object> tmp = Tools.getReqParamsToMap(req);
			T obj = JsonTools.jsonToObj(JsonTools.toJsonString(tmp), getObejctClass());
			int res = service.add(obj);
			if(res > 0){
				return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
			}else{
				return ResultTools.custom(Tips.ERROR0).toJSONString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultTools.custom(Tips.ERROR0).toJSONString();
    }
	
	@RequestMapping("/add2")
    @ResponseBody
    public String add2(HttpServletRequest req) {
		initService();
		
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
		
		//保存
		try {
			Map<String, Object> tmp = Tools.getReqParamsToMap(req);
			T obj = JsonTools.jsonToObj(JsonTools.toJsonString(tmp), getObejctClass());
			T res = service.add2(obj);
			if(res != null){
				return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
			}else{
				return ResultTools.custom(Tips.ERROR0).toJSONString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultTools.custom(Tips.ERROR0).toJSONString();
    }
	
	@RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest req) {
		initService();
		
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
		
		//参数
		String pid = Tools.getReqParamSafe(req, "pid");
		vMap = Tools.verifyParam("pid", pid, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//保存
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("pid", pid);
		Map<String, Object> setValues = Tools.getReqParamsToMap(req, getObejctClass());
		int res = service.modify(setValues, condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
    }
	
	
	@RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest req) {
		initService();
		
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
		
		//参数
		String pid = Tools.getReqParamSafe(req, "pid");
		vMap = Tools.verifyParam("pid", pid, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//保存
		int res = service.delete(MapTools.custom().put("pid", pid).build());
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
    }
	
	@RequestMapping("/deleteBy")
    @ResponseBody
    public String deleteBy(HttpServletRequest req) {
		initService();
		
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
		
		//参数
		Map<String, Object> condition = Tools.getReqParamsToMap(req, getObejctClass());
		if(condition == null || condition.isEmpty()){
			return ResultTools.custom(Tips.ERROR211, "删除条件").toJSONString();
		}
		//保存
		int res = service.delete(condition);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).put(ResultKey.DATA, res).toJSONString();
		}
    }
	
	@RequestMapping("/findAll")
    @ResponseBody
    public String findAll(HttpServletRequest req) {
		initService();
		
		Map<String, Object> vMap = null;
		//登录
		/*vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}*/
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		List<T> list = service.findAll();
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, list).toJSONString();
    }
	
	
	@RequestMapping("/findPage")
    @ResponseBody
    public String findPage(HttpServletRequest req) {
		initService();
		
		Map<String, Object> vMap = null;
		//登录
		/*vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}*/
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String page = Tools.getReqParamSafe(req, "page");
		String rows = Tools.getReqParamSafe(req, "rows");
		vMap = Tools.verifyParam("page", page, 0, 0, true);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("rows", rows, 0, 0, true);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		int start = Tools.parseInt(page) <= 1 ? 0 : (Tools.parseInt(page) - 1) * Tools.parseInt(rows);
		//参数
		Map<String, Object> condition = Tools.getReqParamsToMap(req, getObejctClass());
		
		List<T> list = service.findPage(condition, start, Tools.parseInt(rows));
		long total = service.size(condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.TOTAL, total).put(ResultKey.DATA, list).toJSONString();
    }
	
	@RequestMapping("/findObject")
    @ResponseBody
    public String findObject(HttpServletRequest req) {
		initService();
		
		Map<String, Object> vMap = null;
		//登录
		/*vMap = verifyLogin(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}*/
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		Map<String, Object> condition = Tools.getReqParamsToMap(req, getObejctClass());
		T res = service.findOne(condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
    }
	
	@RequestMapping("/findList")
    @ResponseBody
    public String findList(HttpServletRequest req) {
		initService();
		
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		Map<String, Object> condition = Tools.getReqParamsToMap(req, getObejctClass());
		List<T> list = service.findList(condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, list).toJSONString();
    }
	
	@SuppressWarnings("unchecked")
	private Class<T> getObejctClass(){
		Type type = getClass().getGenericSuperclass();
		Class<T> clss = null;
		try {
			Class<?>[] clsses = Tools.getGenericClass((ParameterizedType) type);
			clss = (Class<T>) clsses[0];
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clss;
	}
	
}