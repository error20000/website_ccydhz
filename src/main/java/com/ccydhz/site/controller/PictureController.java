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
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;
import com.ccydhz.site.entity.Picture;
import com.ccydhz.site.service.PictureService;

@Controller
@RequestMapping("/api/picture")
@API(info="", entity={Picture.class})
public class PictureController extends BaseController<Picture> {

	@Autowired
	private PictureService service;
	
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="原图地址"),
				@ParamsInfo(name="pich", type="String", isNull=0,  info="首页缩略图"),
				@ParamsInfo(name="picl", type="String", isNull=0,  info="列表页缩略图"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0：禁用，1：启用"),
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="原图地址"),
				@ParamsInfo(name="pich", type="String", isNull=0,  info="首页缩略图"),
				@ParamsInfo(name="picl", type="String", isNull=0,  info="列表页缩略图"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0：禁用，1：启用"),
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="原图地址"),
				@ParamsInfo(name="pich", type="String", isNull=0,  info="首页缩略图"),
				@ParamsInfo(name="picl", type="String", isNull=0,  info="列表页缩略图"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0：禁用，1：启用"),
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="原图地址"),
				@ParamsInfo(name="pich", type="String", isNull=0,  info="首页缩略图"),
				@ParamsInfo(name="picl", type="String", isNull=0,  info="列表页缩略图"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0：禁用，1：启用"),
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
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="原图地址"),
				@ParamsInfo(name="pich", type="String", isNull=0,  info="首页缩略图"),
				@ParamsInfo(name="picl", type="String", isNull=0,  info="列表页缩略图"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0：禁用，1：启用"),
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

	@RequestMapping("/findByType")
    @ResponseBody
	@API(name="分页查询", 
		info="前端查询使用，最大每页100条", 
		request={
				@ParamsInfo(name="page", type="int", isNull=1, info="页码"),
				@ParamsInfo(name="rows", type="int", isNull=1, info="每页条数"),
				@ParamsInfo(name="type", type="int", isNull=1,  info="分类"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
				@ParamsInfo(name=ResultKey.TOTAL, type="int", info="总数"),
		})
	public String findByType(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String page = Tools.getReqParamSafe(req, "page");
		String rows = Tools.getReqParamSafe(req, "rows");
		String type = Tools.getReqParamSafe(req, "type");
		vMap = Tools.verifyParam("page", page, 0, 0, true);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("rows", rows, 0, 0, true);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("type", type, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		//限制每页最大条数
		int row = Tools.parseInt(rows) > 100 ? 10 : Tools.parseInt(rows);
		int start = Tools.parseInt(page) <= 1 ? 0 : (Tools.parseInt(page) - 1) * row;
		//查询
		String sql = " select a.*, b.name typeName ";
		String sqlc = " select count(1) ";
		String fsql = " from `s_picture` a left join `s_picture_type` b on a.`type` = b.`pid` where a.`status` = 1 and a.`type` = :type ";
		//倒序
		sql = sql + fsql + " order by a.`recommend` desc, a.`sort`, a.`date` desc ";
		sqlc = sqlc + fsql;
		Map<String, Object> condition = MapTools.custom().put("type", type).build();
		
		List<Map<String, Object>> list = service.getDao().basePage(sql, condition, start, row);
		long total = service.getDao().baseSize(sqlc, condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.TOTAL, total).put(ResultKey.DATA, list).toJSONString();
	}
}
