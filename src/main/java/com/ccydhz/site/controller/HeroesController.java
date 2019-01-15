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
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;
import com.ccydhz.site.entity.Heroes;
import com.ccydhz.site.service.HeroesService;

@Controller
@RequestMapping("/api/heroes")
@API(info="", entity={Heroes.class})
public class HeroesController extends BaseController<Heroes> {

	@Autowired
	private HeroesService service;
	
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="舰种"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="painter", type="String", isNull=0,  info="画师"),
				@ParamsInfo(name="cv", type="String", isNull=0,  info="CV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频"),
				@ParamsInfo(name="star", type="int", isNull=0,  info="星级"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="简介"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="sname1", type="String", isNull=0,  info="技能一名称"),
				@ParamsInfo(name="sicon1", type="String", isNull=0,  info="技能一图标"),
				@ParamsInfo(name="sdesc1", type="String", isNull=0,  info="技能一描述"),
				@ParamsInfo(name="sname2", type="String", isNull=0,  info="技能二名称"),
				@ParamsInfo(name="sicon2", type="String", isNull=0,  info="技能二图标"),
				@ParamsInfo(name="sdesc2", type="String", isNull=0,  info="技能二描述"),
				@ParamsInfo(name="sname3", type="String", isNull=0,  info="技能三名称"),
				@ParamsInfo(name="sicon3", type="String", isNull=0,  info="技能三图标"),
				@ParamsInfo(name="sdesc3", type="String", isNull=0,  info="技能三描述"),
				@ParamsInfo(name="sname4", type="String", isNull=0,  info="技能四名称"),
				@ParamsInfo(name="sicon4", type="String", isNull=0,  info="技能四图标"),
				@ParamsInfo(name="sdesc4", type="String", isNull=0,  info="技能四描述"),
				@ParamsInfo(name="icon", type="String", isNull=0,  info="头像"),
				@ParamsInfo(name="img1", type="String", isNull=0,  info="PC图片一"),
				@ParamsInfo(name="img2", type="String", isNull=0,  info="PC图片二"),
				@ParamsInfo(name="img3", type="String", isNull=0,  info="移动图片一"),
				@ParamsInfo(name="img4", type="String", isNull=0,  info="移动图片二"),
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
				@ParamsInfo(name="type", type="int", isNull=0,  info="舰种"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="painter", type="String", isNull=0,  info="画师"),
				@ParamsInfo(name="cv", type="String", isNull=0,  info="CV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频"),
				@ParamsInfo(name="star", type="int", isNull=0,  info="星级"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="简介"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="sname1", type="String", isNull=0,  info="技能一名称"),
				@ParamsInfo(name="sicon1", type="String", isNull=0,  info="技能一图标"),
				@ParamsInfo(name="sdesc1", type="String", isNull=0,  info="技能一描述"),
				@ParamsInfo(name="sname2", type="String", isNull=0,  info="技能二名称"),
				@ParamsInfo(name="sicon2", type="String", isNull=0,  info="技能二图标"),
				@ParamsInfo(name="sdesc2", type="String", isNull=0,  info="技能二描述"),
				@ParamsInfo(name="sname3", type="String", isNull=0,  info="技能三名称"),
				@ParamsInfo(name="sicon3", type="String", isNull=0,  info="技能三图标"),
				@ParamsInfo(name="sdesc3", type="String", isNull=0,  info="技能三描述"),
				@ParamsInfo(name="sname4", type="String", isNull=0,  info="技能四名称"),
				@ParamsInfo(name="sicon4", type="String", isNull=0,  info="技能四图标"),
				@ParamsInfo(name="sdesc4", type="String", isNull=0,  info="技能四描述"),
				@ParamsInfo(name="icon", type="String", isNull=0,  info="头像"),
				@ParamsInfo(name="img1", type="String", isNull=0,  info="PC图片一"),
				@ParamsInfo(name="img2", type="String", isNull=0,  info="PC图片二"),
				@ParamsInfo(name="img3", type="String", isNull=0,  info="移动图片一"),
				@ParamsInfo(name="img4", type="String", isNull=0,  info="移动图片二"),
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="舰种"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="painter", type="String", isNull=0,  info="画师"),
				@ParamsInfo(name="cv", type="String", isNull=0,  info="CV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频"),
				@ParamsInfo(name="star", type="int", isNull=0,  info="星级"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="简介"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="sname1", type="String", isNull=0,  info="技能一名称"),
				@ParamsInfo(name="sicon1", type="String", isNull=0,  info="技能一图标"),
				@ParamsInfo(name="sdesc1", type="String", isNull=0,  info="技能一描述"),
				@ParamsInfo(name="sname2", type="String", isNull=0,  info="技能二名称"),
				@ParamsInfo(name="sicon2", type="String", isNull=0,  info="技能二图标"),
				@ParamsInfo(name="sdesc2", type="String", isNull=0,  info="技能二描述"),
				@ParamsInfo(name="sname3", type="String", isNull=0,  info="技能三名称"),
				@ParamsInfo(name="sicon3", type="String", isNull=0,  info="技能三图标"),
				@ParamsInfo(name="sdesc3", type="String", isNull=0,  info="技能三描述"),
				@ParamsInfo(name="sname4", type="String", isNull=0,  info="技能四名称"),
				@ParamsInfo(name="sicon4", type="String", isNull=0,  info="技能四图标"),
				@ParamsInfo(name="sdesc4", type="String", isNull=0,  info="技能四描述"),
				@ParamsInfo(name="icon", type="String", isNull=0,  info="头像"),
				@ParamsInfo(name="img1", type="String", isNull=0,  info="PC图片一"),
				@ParamsInfo(name="img2", type="String", isNull=0,  info="PC图片二"),
				@ParamsInfo(name="img3", type="String", isNull=0,  info="移动图片一"),
				@ParamsInfo(name="img4", type="String", isNull=0,  info="移动图片二"),
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="舰种"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="painter", type="String", isNull=0,  info="画师"),
				@ParamsInfo(name="cv", type="String", isNull=0,  info="CV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频"),
				@ParamsInfo(name="star", type="int", isNull=0,  info="星级"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="简介"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="sname1", type="String", isNull=0,  info="技能一名称"),
				@ParamsInfo(name="sicon1", type="String", isNull=0,  info="技能一图标"),
				@ParamsInfo(name="sdesc1", type="String", isNull=0,  info="技能一描述"),
				@ParamsInfo(name="sname2", type="String", isNull=0,  info="技能二名称"),
				@ParamsInfo(name="sicon2", type="String", isNull=0,  info="技能二图标"),
				@ParamsInfo(name="sdesc2", type="String", isNull=0,  info="技能二描述"),
				@ParamsInfo(name="sname3", type="String", isNull=0,  info="技能三名称"),
				@ParamsInfo(name="sicon3", type="String", isNull=0,  info="技能三图标"),
				@ParamsInfo(name="sdesc3", type="String", isNull=0,  info="技能三描述"),
				@ParamsInfo(name="sname4", type="String", isNull=0,  info="技能四名称"),
				@ParamsInfo(name="sicon4", type="String", isNull=0,  info="技能四图标"),
				@ParamsInfo(name="sdesc4", type="String", isNull=0,  info="技能四描述"),
				@ParamsInfo(name="icon", type="String", isNull=0,  info="头像"),
				@ParamsInfo(name="img1", type="String", isNull=0,  info="PC图片一"),
				@ParamsInfo(name="img2", type="String", isNull=0,  info="PC图片二"),
				@ParamsInfo(name="img3", type="String", isNull=0,  info="移动图片一"),
				@ParamsInfo(name="img4", type="String", isNull=0,  info="移动图片二"),
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="舰种"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="painter", type="String", isNull=0,  info="画师"),
				@ParamsInfo(name="cv", type="String", isNull=0,  info="CV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频"),
				@ParamsInfo(name="star", type="int", isNull=0,  info="星级"),
				@ParamsInfo(name="desc", type="String", isNull=0,  info="简介"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态  0：禁用，1：启用"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(name="sname1", type="String", isNull=0,  info="技能一名称"),
				@ParamsInfo(name="sicon1", type="String", isNull=0,  info="技能一图标"),
				@ParamsInfo(name="sdesc1", type="String", isNull=0,  info="技能一描述"),
				@ParamsInfo(name="sname2", type="String", isNull=0,  info="技能二名称"),
				@ParamsInfo(name="sicon2", type="String", isNull=0,  info="技能二图标"),
				@ParamsInfo(name="sdesc2", type="String", isNull=0,  info="技能二描述"),
				@ParamsInfo(name="sname3", type="String", isNull=0,  info="技能三名称"),
				@ParamsInfo(name="sicon3", type="String", isNull=0,  info="技能三图标"),
				@ParamsInfo(name="sdesc3", type="String", isNull=0,  info="技能三描述"),
				@ParamsInfo(name="sname4", type="String", isNull=0,  info="技能四名称"),
				@ParamsInfo(name="sicon4", type="String", isNull=0,  info="技能四图标"),
				@ParamsInfo(name="sdesc4", type="String", isNull=0,  info="技能四描述"),
				@ParamsInfo(name="icon", type="String", isNull=0,  info="头像"),
				@ParamsInfo(name="img1", type="String", isNull=0,  info="PC图片一"),
				@ParamsInfo(name="img2", type="String", isNull=0,  info="PC图片二"),
				@ParamsInfo(name="img3", type="String", isNull=0,  info="移动图片一"),
				@ParamsInfo(name="img4", type="String", isNull=0,  info="移动图片二"),
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
				//findPage request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
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
		//限制每页最大条数
		int row = Tools.parseInt(rows) > 100 ? 10 : Tools.parseInt(rows);
		int start = Tools.parseInt(page) <= 1 ? 0 : (Tools.parseInt(page) - 1) * row;
		//查询
		String sql = " select a.*, b.name typeName ";
		String sqlc = " select count(1) ";
		String fsql = " from `s_heroes` a left join `s_heroes_type` b on a.`type` = b.`pid` where a.`status` = 1 ";
		Map<String, Object> condition = new HashMap<>();
		if(!Tools.isNullOrEmpty(type)){
			fsql += " and a.`type` = :type";
			condition.put("type", type);
		}
		//倒序
		sql = sql + fsql + " order by a.`sort` ";
		sqlc = sqlc + fsql;
		
		List<Map<String, Object>> list = service.getDao().basePage(sql, condition, start, row);
		long total = service.getDao().baseSize(sqlc, condition);
        return ResultTools.custom(Tips.ERROR1).put(ResultKey.TOTAL, total).put(ResultKey.DATA, list).toJSONString();
	}
}
