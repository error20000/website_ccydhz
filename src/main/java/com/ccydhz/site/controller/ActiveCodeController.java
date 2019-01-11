package com.ccydhz.site.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.ccydhz.site.App;
import com.ccydhz.site.config.Config;
import com.ccydhz.site.entity.ActiveCode;
import com.ccydhz.site.service.ActiveCodeService;

@Controller
@RequestMapping("/api/activecode")
@API(info="", entity={ActiveCode.class})
public class ActiveCodeController extends BaseController<ActiveCode> {

	@Autowired
	private ActiveCodeService service;
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
				@ParamsInfo(name="config", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="codes", type="String", isNull=0,  info="码")
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
		
		String config = Tools.getReqParamSafe(req, "config");
		String codes = Tools.getReqParamSafe(req, "codes");
		vMap = Tools.verifyParam("config", config, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("codes", codes, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//保存
		String[] cds = codes.replace("\n", ",").replace("\r", ",").replace("，", ",").split(",");
		List<ActiveCode> list = new ArrayList<ActiveCode>();
		for (int i = 0; i < cds.length; i++) {
			ActiveCode st = new ActiveCode();
			st.setConfig(Tools.parseInt(config));
			st.setCode(cds[i].trim());
			st.setStatus(0);
			list.add(st);
		}
		int res = service.add(list);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}
	
	@RequestMapping("/batchAdd")
    @ResponseBody
	@API(name="新增", 
		info="需登录认证", 
		request={
				//add request
				@ParamsInfo(name="config", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="fileCodes", type="String", isNull=0,  info="码")
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String batchAdd(HttpServletRequest req) {
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
		
		String config = Tools.getReqParamSafe(req, "config");
		String fileCodes = Tools.getReqParamSafe(req, "fileCodes");
		vMap = Tools.verifyParam("config", config, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		vMap = Tools.verifyParam("fileCodes", fileCodes, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//保存
		List<ActiveCode> list = new ArrayList<ActiveCode>();
//		System.out.println(fileCodes);
		String basePath = Tools.isNullOrEmpty(baseConfig.upload_path) ? App.rootPath + "upload/" : baseConfig.upload_path;
		File file = new File(basePath + fileCodes);
		if(!file.exists()){
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
//			List<String> list = reader.lines().collect(Collectors.toList());
//			codes = reader.lines().collect(Collectors.joining(","));
			list = reader.lines().map(e -> {
				ActiveCode st = new ActiveCode(); 
				st.setConfig(Tools.parseInt(config));
				st.setCode(e);
				st.setStatus(0);
				return st;
			}).collect(Collectors.toList());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					reader = null;
				}
			}
		}
//		System.out.println(list.size());
//		System.out.println("---------------------------");
		/*String[] cds = codes.replace("\n", ",").replace("\r", ",").replace("，", ",").split(",");
		List<ActiveCode> list = new ArrayList<ActiveCode>();
		for (int i = 0; i < cds.length; i++) {
			ActiveCode st = new ActiveCode();
			st.setConfig(Tools.parseInt(config));
			st.setCode(cds[i].trim());
			st.setStatus(0);
			list.add(st);
		}*/
		int res = service.getDao().batchAdd(list);
//		System.out.println(res);
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, list.size()).toJSONString();
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
	
	@RequestMapping("/batchDelete")
    @ResponseBody
	@API(name="批量删除", 
		info="需登录认证", 
		request={
				//delete request
				@ParamsInfo(name="pids", type="int", isNull=1,  info="自增主键"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String batchDelete(HttpServletRequest req) {
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
		String pids = Tools.getReqParamSafe(req, "pids");
		vMap = Tools.verifyParam("pids", pids, 0, 0);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//保存
		int res = service.delete("pid", Arrays.asList(pids.split(",")));
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
				@ParamsInfo(name="config", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="code", type="String", isNull=0,  info="码"),
				@ParamsInfo(name="other", type="String", isNull=0,  info="领取人"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 未领取， 1 -- 已领取"),
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
				@ParamsInfo(name="config", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="code", type="String", isNull=0,  info="码"),
				@ParamsInfo(name="other", type="String", isNull=0,  info="领取人"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 未领取， 1 -- 已领取"),
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
				@ParamsInfo(name="config", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="code", type="String", isNull=0,  info="码"),
				@ParamsInfo(name="other", type="String", isNull=0,  info="领取人"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="status", type="int", isNull=0,  info="状态   0 -- 未领取， 1 -- 已领取"),
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
