package com.ccydhz.site.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.entity.Background;
import com.ccydhz.site.service.BackgroundService;
import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;

@Controller
@RequestMapping("/api/background")
@API(info="", entity={Background.class})
public class BackgroundController extends BaseController<Background> {

	@Autowired
	private BackgroundService service;
	
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
				@ParamsInfo(name="logo", type="String", isNull=0,  info="LOGO"),
				@ParamsInfo(name="pic1", type="String", isNull=0,  info="首页背景"),
				@ParamsInfo(name="pic2", type="String", isNull=0,  info="二级页背景"),
				@ParamsInfo(name="pic3", type="String", isNull=0,  info="三级页背景"),
				@ParamsInfo(name="pic4", type="String", isNull=0,  info="四级页背景"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
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
				@ParamsInfo(name="pid", type="int", isNull=1,  info="自增主键"),
				@ParamsInfo(info="可修改字段："),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="logo", type="String", isNull=0,  info="LOGO"),
				@ParamsInfo(name="pic1", type="String", isNull=0,  info="首页背景"),
				@ParamsInfo(name="pic2", type="String", isNull=0,  info="二级页背景"),
				@ParamsInfo(name="pic3", type="String", isNull=0,  info="三级页背景"),
				@ParamsInfo(name="pic4", type="String", isNull=0,  info="四级页背景"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String update(HttpServletRequest req) {
		return super.update(req);
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
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="logo", type="String", isNull=0,  info="LOGO"),
				@ParamsInfo(name="pic1", type="String", isNull=0,  info="首页背景"),
				@ParamsInfo(name="pic2", type="String", isNull=0,  info="二级页背景"),
				@ParamsInfo(name="pic3", type="String", isNull=0,  info="三级页背景"),
				@ParamsInfo(name="pic4", type="String", isNull=0,  info="四级页背景"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="logo", type="String", isNull=0,  info="LOGO"),
				@ParamsInfo(name="pic1", type="String", isNull=0,  info="首页背景"),
				@ParamsInfo(name="pic2", type="String", isNull=0,  info="二级页背景"),
				@ParamsInfo(name="pic3", type="String", isNull=0,  info="三级页背景"),
				@ParamsInfo(name="pic4", type="String", isNull=0,  info="四级页背景"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="logo", type="String", isNull=0,  info="LOGO"),
				@ParamsInfo(name="pic1", type="String", isNull=0,  info="首页背景"),
				@ParamsInfo(name="pic2", type="String", isNull=0,  info="二级页背景"),
				@ParamsInfo(name="pic3", type="String", isNull=0,  info="三级页背景"),
				@ParamsInfo(name="pic4", type="String", isNull=0,  info="四级页背景"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
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

	@RequestMapping("/find")
    @ResponseBody
	@API(name="查询界面配置", 
		info="前端查询使用，返回一条最新的可使用的配置信息", 
		request={
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
	public String find(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//查询最新一条
		String wsql = " `status` = 1 order by `pid` desc ";
		
		Background res = service.getDao().findObject(wsql, MapTools.custom().build());
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
	}
}
