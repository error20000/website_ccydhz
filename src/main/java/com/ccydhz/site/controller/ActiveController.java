package com.ccydhz.site.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.entity.Active;
import com.ccydhz.site.entity.ActiveConfig;
import com.ccydhz.site.entity.ActiveType;
import com.ccydhz.site.entity.Bespeak;
import com.ccydhz.site.entity.Share;
import com.ccydhz.site.service.ActiveConfigService;
import com.ccydhz.site.service.ActiveService;
import com.ccydhz.site.service.ActiveTypeService;
import com.ccydhz.site.service.BespeakService;
import com.ccydhz.site.service.ShareService;
import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.DateTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;

@Controller
@RequestMapping("/api/active")
@API(info="", entity={Active.class})
public class ActiveController extends BaseController<Active> {

	@Autowired
	private ActiveService service;
	@Autowired
	private ActiveTypeService tService;
	@Autowired
	private ActiveConfigService cService;
	@Autowired
	private BespeakService bService;
	@Autowired
	private ShareService sService;
	
	private int activeTypePid = 2;
	
	@Override
	public void initService() {
		super.service = service;
	}
	
	//TODO 基本方法
	
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="ip", type="String", isNull=0,  info="IP"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="参与人"),
				@ParamsInfo(name="config", type="int", isNull=0,  info="奖励pid"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附件信息"),
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="ip", type="String", isNull=0,  info="IP"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="参与人"),
				@ParamsInfo(name="config", type="int", isNull=0,  info="奖励pid"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附件信息"),
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期  yyyy-MM-dd HH:mm:ss"),
				@ParamsInfo(name="ip", type="String", isNull=0,  info="IP"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="参与人"),
				@ParamsInfo(name="config", type="int", isNull=0,  info="奖励pid"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附件信息"),
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
	
	@RequestMapping("/config")
    @ResponseBody
	@API(name="抽奖项目", 
		info="", 
		request={
				
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String config(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//获取活动配置
		List<ActiveConfig> list = cService.findList(MapTools.custom().put("type", activeTypePid).build());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setChance(0);
			list.get(i).setChance_z("");
			list.get(i).setCount(0);
		}
		
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, list).toJSONString();
	}
	
	@RequestMapping("/save")
    @ResponseBody
	@API(name="参与抽奖", 
		info="", 
		request={
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String save(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String phone = Tools.getReqParamSafe(req, "phone");
		String info = Tools.getReqParamSafe(req, "info");
		vMap = Tools.verifyParam("phone", phone, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "phone").toJSONString();
		}
		
		//获取活动配置
		ActiveType type = tService.findOne(MapTools.custom().put("pid", activeTypePid).build());
		if(type == null){
			return ResultTools.custom(Tips.ERROR200).toJSONString();
		}
		if(type.getStatus() == 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		String cur = DateTools.formatDate();
		if(!Tools.isNullOrEmpty(type.getStart()) && type.getStart().compareTo(cur) > 0){
			return ResultTools.custom(Tips.ERROR301).toJSONString();
		}
		if(!Tools.isNullOrEmpty(type.getEnd()) && type.getEnd().compareTo(cur) < 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		//判断活动的资格
		Bespeak bespeak = bService.findOne(MapTools.custom().put("phone", phone).build());
		if(bespeak == null){
			return ResultTools.custom().put(ResultKey.CODE, -400).put(ResultKey.MSG, "请先预约").toJSONString();
		}
		
		//判断活动次数
		String date = DateTools.formatDate("yyyy-MM-dd");
		String wsql = " phone = :phone and date like concat( :date, '%')";
		//	已使用
		long use = service.getDao().size(wsql, MapTools.custom().put("phone", phone).put("date", date).build());
		//	可使用
		long shares =sService.getDao().size(wsql, MapTools.custom().put("phone", phone).put("date", date).build());
		long total = type.getCount() + shares * type.getSCount();
		
		if(use >= total){
			return ResultTools.custom(Tips.ERROR304).toJSONString();
		}
		
		//抽奖
		ActiveConfig config = chance();
		
		//保存记录
		Active obj = new Active();
		obj.setDate(DateTools.formatDate());
		obj.setIp(Tools.getIp(req));
		obj.setPhone(phone);
		obj.setConfig(config.getPid());
		obj.setInfo(info);
		int res = service.add(obj);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, MapTools.custom().put("config", config.getPid()).put("active", res).build()).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}
	
	private ActiveConfig chance() {
		List<ActiveConfig> acs = cService.findList(MapTools.custom().put("type", activeTypePid).build());
		List<Map<String, Object>> temp = new ArrayList<>();
		Map<String, Object> node = null;
		double index = 0d;
		for (ActiveConfig config : acs) {
			node = new HashMap<>();
			node.put("min", index);
			index += config.getChance();
			node.put("max", index);
			node.put("config", config);
			temp.add(node);
		}
		
		Random random = new Random();
		double rad = random.nextDouble();
		
		ActiveConfig config = null;
		for (int i = 0; i < temp.size(); i++) {
			Double min = (Double) temp.get(i).get("min");
			Double max = (Double) temp.get(i).get("max");
			if(rad > min && rad < max){
				config = (ActiveConfig) temp.get(i).get("config");
				break;
			}
		}
		
		if(config == null){
			return new ActiveConfig();
		}
		
		//数量限制
		long use = service.getDao().size(MapTools.custom().put("config", config.getPid()).build());
		if(use >= config.getCount()){
			return new ActiveConfig();
		}
		
		return config;
	}
	
	@RequestMapping("/sure")
    @ResponseBody
	@API(name="确认奖品", 
		info="", 
		request={
				@ParamsInfo(name="active", type="String", isNull=0,  info="活动pid"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String sure(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String active = Tools.getReqParamSafe(req, "active");
		String phone = Tools.getReqParamSafe(req, "phone");
		vMap = Tools.verifyParam("phone", phone, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "phone").toJSONString();
		}
		vMap = Tools.verifyParam("active", active, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "active").toJSONString();
		}
		
		//获取活动记录
		Active obj = service.findOne(MapTools.custom().put("pid", active).build());
		if(obj == null){
			return ResultTools.custom(Tips.ERROR200, "active").toJSONString();
		}
		if(!phone.equals(obj.getPhone())){
			return ResultTools.custom(Tips.ERROR200, "phone").toJSONString();
		}
		//确认领取
		obj.setInfo2("用户确认领取");
		int res = service.modify(obj);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, obj).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}
	
	@RequestMapping("/share")
    @ResponseBody
	@API(name="分享", 
		info="", 
		request={
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="from", type="String", isNull=0,  info="分享方式"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String share(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String from = Tools.getReqParamSafe(req, "from");
		String phone = Tools.getReqParamSafe(req, "phone");
		vMap = Tools.verifyParam("phone", phone, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "phone").toJSONString();
		}
		vMap = Tools.verifyParam("from", from, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "from").toJSONString();
		}
		
		//获取活动配置
		if(!("QQ".equalsIgnoreCase(from) || "WX".equalsIgnoreCase(from) || "WB".equalsIgnoreCase(from))){
			from = "";
		}
		if(Tools.isNullOrEmpty(from)){
			return  ResultTools.custom(Tips.ERROR200, "from").toJSONString();
		}
		
		//判断是否已分享
		String date = DateTools.formatDate("yyyy-MM-dd");
		String wsql = " phone = :phone and date like concat( :date, '%')";
		long count = sService.getDao().size(wsql, MapTools.custom().put("phone", phone).put("date", date).build());
		if(count > 0){
			return ResultTools.custom(Tips.ERROR303).toJSONString();
		}

		Share obj = new Share();
		obj.setDate(DateTools.formatDate());
		obj.setIp(Tools.getIp(req));
		obj.setPhone(phone);
		obj.setInfo(from);

		int res = sService.add(obj);
		if(res > 0){
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, obj).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}
	
}