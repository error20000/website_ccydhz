package com.ccydhz.site.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;
import com.ccydhz.site.entity.News;
import com.ccydhz.site.entity.Strategy;
import com.ccydhz.site.service.StrategyService;

@Controller
@RequestMapping("/api/strategy")
@API(info="", entity={Strategy.class})
public class StrategyController extends BaseController<Strategy> {

	@Autowired
	private StrategyService service;
	
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="illustration", type="String", isNull=0,  info="插图"),
				@ParamsInfo(name="title", type="String", isNull=0,  info="标题"),
				@ParamsInfo(name="subtitle", type="String", isNull=0,  info="副标题"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="使用链接：0--否，1--是"),
				@ParamsInfo(name="site", type="String", isNull=0,  info="链接地址"),
				@ParamsInfo(name="content", type="String", isNull=0,  info="内容"),
				@ParamsInfo(name="keywords", type="String", isNull=0,  info="关键字（seo）"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述（seo）"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="描述 文章、作者类"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="illustration", type="String", isNull=0,  info="插图"),
				@ParamsInfo(name="title", type="String", isNull=0,  info="标题"),
				@ParamsInfo(name="subtitle", type="String", isNull=0,  info="副标题"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="使用链接：0--否，1--是"),
				@ParamsInfo(name="site", type="String", isNull=0,  info="链接地址"),
				@ParamsInfo(name="content", type="String", isNull=0,  info="内容"),
				@ParamsInfo(name="keywords", type="String", isNull=0,  info="关键字（seo）"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述（seo）"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="描述 文章、作者类"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="illustration", type="String", isNull=0,  info="插图"),
				@ParamsInfo(name="title", type="String", isNull=0,  info="标题"),
				@ParamsInfo(name="subtitle", type="String", isNull=0,  info="副标题"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="使用链接：0--否，1--是"),
				@ParamsInfo(name="site", type="String", isNull=0,  info="链接地址"),
				@ParamsInfo(name="content", type="String", isNull=0,  info="内容"),
				@ParamsInfo(name="keywords", type="String", isNull=0,  info="关键字（seo）"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述（seo）"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="描述 文章、作者类"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
				@ParamsInfo(name=ResultKey.TOTAL, type="int", info="总数"),
		})
	public String findPage(HttpServletRequest req) {
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
		String page = Tools.getReqParamSafe(req, "page");
		String rows = Tools.getReqParamSafe(req, "rows");
		String startDate = Tools.getReqParamSafe(req, "startDate");
		String endDate = Tools.getReqParamSafe(req, "endDate");
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
		String wsql = " 1 = 1 ";
		Map<String, Object> condition = Tools.getReqParamsToMap(req, Strategy.class);
		if(condition != null){
			for (String key : condition.keySet()) {
				wsql += " and `"+key+"`=:"+key;
			}
		}
		if(!Tools.isNullOrEmpty(startDate)){
			wsql += " and `date` >= :startDate";
			condition.put("startDate", startDate);
		}
		if(!Tools.isNullOrEmpty(endDate)){
			wsql += " and `date` <= :endDate";
			condition.put("endDate", endDate);
		}
		//倒序
		wsql += " order by `recommend` desc, `date` desc ";
		
		List<Strategy> list = service.getDao().findList(wsql, condition, start, Tools.parseInt(rows));
		long total = service.getDao().size(wsql, condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.TOTAL, total).put(ResultKey.DATA, list).toJSONString();
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="illustration", type="String", isNull=0,  info="插图"),
				@ParamsInfo(name="title", type="String", isNull=0,  info="标题"),
				@ParamsInfo(name="subtitle", type="String", isNull=0,  info="副标题"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="使用链接：0--否，1--是"),
				@ParamsInfo(name="site", type="String", isNull=0,  info="链接地址"),
				@ParamsInfo(name="content", type="String", isNull=0,  info="内容"),
				@ParamsInfo(name="keywords", type="String", isNull=0,  info="关键字（seo）"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述（seo）"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="描述 文章、作者类"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="illustration", type="String", isNull=0,  info="插图"),
				@ParamsInfo(name="title", type="String", isNull=0,  info="标题"),
				@ParamsInfo(name="subtitle", type="String", isNull=0,  info="副标题"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="使用链接：0--否，1--是"),
				@ParamsInfo(name="site", type="String", isNull=0,  info="链接地址"),
				@ParamsInfo(name="content", type="String", isNull=0,  info="内容"),
				@ParamsInfo(name="keywords", type="String", isNull=0,  info="关键字（seo）"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述（seo）"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="描述 文章、作者类"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
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
	
}
