package com.ccydhz.site.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.DateTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;
import com.ccydhz.site.config.Config;
import com.ccydhz.site.entity.BespeakConfig;
import com.ccydhz.site.service.BespeakConfigService;
import com.ccydhz.site.util.Utils;

@Controller
@RequestMapping("/api/bespeakconfig")
@API(info="", entity={BespeakConfig.class})
public class BespeakConfigController extends BaseController<BespeakConfig> {

	@Autowired
	private BespeakConfigService service;
	
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="start", type="String", isNull=0,  info="开始时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="end", type="String", isNull=0,  info="结束时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 关闭  1 --开启"),
				@ParamsInfo(name="offset", type="int", isNull=0,  info="偏移量"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String add(HttpServletRequest req) {
		return super.add(req);
	}


	@Override
	@RequestMapping("/update")
    @ResponseBody
	@API(name="修改", 
		info="需登录认证", 
		request={
				//modify request
				@ParamsInfo(info="修改条件："),
				@ParamsInfo(name="pid", type="int", isNull=1,  info="主键"),
				@ParamsInfo(info="可修改字段："),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="start", type="String", isNull=0,  info="开始时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="end", type="String", isNull=0,  info="结束时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 关闭  1 --开启"),
				@ParamsInfo(name="offset", type="int", isNull=0,  info="偏移量"),
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
		List<String> pkeys = Utils.getPrimaryKeys(BespeakConfig.class);//获取主键
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
		//修改前保存偏移量
		BespeakConfig test = service.findOne(condition);
		if(test != null){
			String cacheKey = DateTools.formatDate("yyyy-MM-dd 00:00:00");
			Integer cacheCount = Config.bespeakCountCache.get(cacheKey);
			if(cacheCount == null){
				Config.bespeakCountCache.clear();
				Config.bespeakCountCache.put(cacheKey, test.getOffset());
			}
		}
		Map<String, Object> setValues = Tools.getReqParamsToMap(req, BespeakConfig.class);
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
				@ParamsInfo(name="pid", type="int", isNull=1,  info="主键"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String delete(HttpServletRequest req) {
		return super.delete(req);
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
				@ParamsInfo(name="pid", type="int", isNull=0,  info="主键"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="start", type="String", isNull=0,  info="开始时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="end", type="String", isNull=0,  info="结束时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 关闭  1 --开启"),
				@ParamsInfo(name="offset", type="int", isNull=0,  info="偏移量"),
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
				@ParamsInfo(name="pid", type="int", isNull=0,  info="主键"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="start", type="String", isNull=0,  info="开始时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="end", type="String", isNull=0,  info="结束时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 关闭  1 --开启"),
				@ParamsInfo(name="offset", type="int", isNull=0,  info="偏移量"),
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
				@ParamsInfo(name="pid", type="int", isNull=0,  info="主键"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="start", type="String", isNull=0,  info="开始时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="end", type="String", isNull=0,  info="结束时间  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 关闭  1 --开启"),
				@ParamsInfo(name="offset", type="int", isNull=0,  info="偏移量"),
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
	
}
