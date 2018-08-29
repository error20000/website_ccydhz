package com.ccydhz.site.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccydhz.site.config.Config;
import com.ccydhz.site.entity.Bespeak;
import com.ccydhz.site.entity.BespeakConfig;
import com.ccydhz.site.service.BespeakConfigService;
import com.ccydhz.site.service.BespeakService;
import com.ccydhz.site.util.SmsGateWay;
import com.jian.annotation.API;
import com.jian.annotation.Excel;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.CacheObject;
import com.jian.tools.core.CacheTools;
import com.jian.tools.core.DateTools;
import com.jian.tools.core.JsonTools;
import com.jian.tools.core.MapTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;

@Controller
@RequestMapping("/api/bespeak")
@API(info="预约", entity={Bespeak.class})
public class BespeakController extends BaseController<Bespeak> {

	@Autowired
	private BespeakService service;
	@Autowired
	private BespeakConfigService cService;
	
	private int bespeakConfigPid = 1;
	
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
				@ParamsInfo(name="date", type="String", isNull=0,  info="日期"),
				@ParamsInfo(name="ip", type="String", isNull=0,  info="ip"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
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
				@ParamsInfo(name="ip", type="String", isNull=0,  info="ip"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
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
				@ParamsInfo(name="ip", type="String", isNull=0,  info="ip"),
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="附加信息"),
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
	
	@RequestMapping("/vcode")
    @ResponseBody
	@API(name="预约验证码", 
		info="", 
		request={
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String vcode(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//参数
		String phone = Tools.getReqParamSafe(req, "phone");
		vMap = Tools.verifyParam("phone", phone, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "phone").toJSONString();
		}
		
		//获取活动配置
		BespeakConfig config = cService.findOne(MapTools.custom().put("pid", bespeakConfigPid).build());
		if(config == null){
			return ResultTools.custom(Tips.ERROR200).toJSONString();
		}
		if(config.getStatus() == 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		String cur = DateTools.formatDate();
		if(!Tools.isNullOrEmpty(config.getStart()) && config.getStart().compareTo(cur) > 0){
			return ResultTools.custom(Tips.ERROR301).toJSONString();
		}
		if(!Tools.isNullOrEmpty(config.getEnd()) && config.getEnd().compareTo(cur) < 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		Bespeak old = service.findOne(MapTools.custom().put("phone", phone).build());
		if(old != null){
			return ResultTools.custom(Tips.ERROR303).toJSONString();
		}
		
		String vcode = Tools.createVCodeNumber(6);
		String key = "vcode_"+phone;
		CacheTools.setCacheObj(key, vcode);
		String content = Config.sms_vcode_content.replace("{vcode}", vcode);System.out.println(vcode);
		//发送短信
		sendSMS(phone, content);
		return ResultTools.custom(Tips.ERROR1).toJSONString();
	}
	

	@RequestMapping("/save")
    @ResponseBody
	@API(name="预约", 
		info="", 
		request={
				@ParamsInfo(name="phone", type="String", isNull=0,  info="手机号"),
				@ParamsInfo(name="vcode", type="String", isNull=0,  info="验证码"),
				@ParamsInfo(name="info", type="String", isNull=0,  info="来源"),
				@ParamsInfo(name="info2", type="String", isNull=0,  info="预约平台"),
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
		String vcode = Tools.getReqParamSafe(req, "vcode");
		String info = Tools.getReqParamSafe(req, "info");
		String info2 = Tools.getReqParamSafe(req, "info2");
		vMap = Tools.verifyParam("phone", phone, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "phone").toJSONString();
		}
		vMap = Tools.verifyParam("vcode", vcode, 0, 0);
		if(vMap != null){
			return ResultTools.custom(Tips.ERROR206, "vcode").toJSONString();
		}
		
		//获取活动配置
		BespeakConfig config = cService.findOne(MapTools.custom().put("pid", bespeakConfigPid).build());
		if(config == null){
			return ResultTools.custom(Tips.ERROR200).toJSONString();
		}
		if(config.getStatus() == 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		String cur = DateTools.formatDate();
		if(!Tools.isNullOrEmpty(config.getStart()) && config.getStart().compareTo(cur) > 0){
			return ResultTools.custom(Tips.ERROR301).toJSONString();
		}
		if(!Tools.isNullOrEmpty(config.getEnd()) && config.getEnd().compareTo(cur) < 0){
			return ResultTools.custom(Tips.ERROR302).toJSONString();
		}
		
		Bespeak old = service.findOne(MapTools.custom().put("phone", phone).build());
		if(old != null){
			return ResultTools.custom(Tips.ERROR303).toJSONString();
		}
		
		//验证短信码
		String key = "vcode_"+phone;
		CacheObject cobj = CacheTools.getCacheObj(key);
		if(cobj == null){
			return ResultTools.custom(Tips.ERROR208).toJSONString();
		}
		if(!vcode.equals(cobj.getValue())){
			//限制错误次数
			String ckey = "vcode_error_"+phone;
			CacheObject cobj2 = CacheTools.getCacheObj(ckey);
			if(cobj2 == null){
				CacheTools.setCacheObj(ckey, 5 - 1);
			}else{
				int time = Tools.parseInt(cobj.getValue()+"");
				time--;
				if(time <= 0){
					CacheTools.clearCacheObj(key);
					CacheTools.clearCacheObj(ckey); //解除禁用
				}else{
					CacheTools.setCacheObj(ckey, time);
				}
			}
			return ResultTools.custom(Tips.ERROR205).toJSONString();
		}
		CacheTools.clearCacheObj(key);
		
		//保存
		Bespeak obj = new Bespeak();
		obj.setDate(DateTools.formatDate());
		obj.setIp(Tools.getIp(req));
		obj.setPhone(phone);
		obj.setInfo(info);
		obj.setInfo2(info2);
		int res = service.add(obj);
		if(res > 0){
			//发送短信
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, res).toJSONString();
		}else{
			return ResultTools.custom(Tips.ERROR0).toJSONString();
		}
	}
	
	@RequestMapping("/count")
    @ResponseBody
	@API(name="预约量", 
		info="", 
		request={
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String count(HttpServletRequest req) {
		Map<String, Object> vMap = null;
		//sign
		vMap = verifySign(req);
		if(vMap != null){
			return JsonTools.toJsonString(vMap);
		}
		
		//获取活动配置
		BespeakConfig config = cService.findOne(MapTools.custom().put("pid", bespeakConfigPid).build());
		if(config == null){
			return ResultTools.custom(Tips.ERROR200).toJSONString();
		}
		
		long count = service.getDao().size();
		
		count += config.getOffset();
		
		return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, count).toJSONString();
	}
	
	private void sendSMS(String phone, String content){
		/*List<String> phones = new ArrayList<>();
		phones.add(phone);
		Map<String, Object> params = MapTools.custom()
				.put("accessKey", Config.sms_accessKey)
				.put("secretKey", Config.sms_secretKey)
				.put("serviceId", Config.sms_serviceId)
				.put("orgId", Config.sms_orgId)
				.put("reqId", Config.sms_reqId)
				.put("srcId", Config.sms_srcId)
				.put("regReport", Config.sms_regReport)
				.put("expireTime", Config.sms_expireTime)
				.put("mobiles", phones)
				.put("content", content)
				.build();
		String res = HttpTools.getInstance().sendHttpPost(Config.sms_url, JsonTools.toJsonString(params), ContentType.APPLICATION_JSON);
		System.out.println(res);*/
		SmsGateWay.sendSms(phone, content);
	}
	
	@RequestMapping("/excel")
    @ResponseBody
	@API(name="导出", 
		info="", 
		request={
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String excel(HttpServletRequest req, HttpServletResponse resp) {
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
		
		//执行
		String startDate = Tools.getReqParamSafe(req, "startDate");
		String endDate = Tools.getReqParamSafe(req, "endDate");
		String wsql = " 1 = 1 ";
		Map<String, Object> condition = Tools.getReqParamsToMap(req, Bespeak.class);
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
		List<Bespeak> res = service.getDao().findList(wsql, condition);
		String name = Bespeak.class.getSimpleName().toLowerCase();
		resp.addHeader("Content-Disposition","attachment;filename="+name+".csv");
		// response.addHeader("Content-Length", "" + JSONArray.fromObject(list).toString().getBytes().length);
		resp.setContentType("application/octet-stream;charset=utf-8");
		try {
			List<Map<String, Object>> excels = new ArrayList<Map<String, Object>>(); //获取导出字段
			OutputStream toClient = new BufferedOutputStream(resp.getOutputStream());
			//header
			Field[] fields = Tools.getFields(Bespeak.class);
			for (Field f : fields) {
				if(f.isAnnotationPresent(Excel.class)){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("sort", f.getAnnotation(Excel.class).sort());
					map.put("name", f.getAnnotation(Excel.class).name());
					map.put("field", f.getName());
					excels.add(map);
				}
			}
			//排序
			for (int i = 0; i < excels.size(); i++) {
				for (int j = i; j < excels.size(); j++) {
					if((Integer)excels.get(i).get("sort") > (Integer)excels.get(j).get("sort")){
						Map<String, Object> tmp = excels.get(i);
						excels.set(i, excels.get(j));
						excels.set(j, tmp);
					}
				}
			}
			
			String headers = Tools.getReqParamSafe(req, "fields"); //可选导出项。
			
			String head = "";
			for (int i = 0; i < excels.size(); i++) {
				if(Tools.isNullOrEmpty(headers)){
					head += "," + "\"" + (excels.get(i).get("name") == null ? "" :excels.get(i).get("name").toString().replace("\"", "\"\""))+ "\"";
				}else{
					String[] hs = headers.replace("，", ",").split(",");
					for (String tmp : hs) {
						if(tmp.equals(excels.get(i).get("field"))){
							head += "," + "\"" + (excels.get(i).get("name") == null ? "" :excels.get(i).get("name").toString().replace("\"", "\"\""))+ "\"";
						}
					}
				}
			}
			head = Tools.isNullOrEmpty(head) ? "" : head.substring(1);
			head += "\n";
			toClient.write(head.getBytes("utf-8"));
			//遍历导出数据
			//可导项
			List<Map<String, Object>> temps = new ArrayList<Map<String, Object>>(); //获取导出字段
			if(!Tools.isNullOrEmpty(headers)){
				String[] hs = headers.replace("，", ",").split(",");
				for (String tmp : hs) {
					for (int i = 0; i < excels.size(); i++) {
						if(tmp.equals(excels.get(i).get("field"))){
							temps.add(excels.get(i));
							break;
						}
					}
				}
				excels = temps;
			}
			//可导数据
			for (Bespeak node : res) { //遍历导出数据
				String str = "";
				for (int j = 0; j < excels.size(); j++) { //遍历导出字段
					String excelField = excels.get(j).get("field").toString();
					String getMethodName = "get" + excelField.substring(0, 1).toUpperCase() + excelField.substring(1);
					Object value = null;
					try{
						Method method = Tools.findMethod(node.getClass(), getMethodName);
						value = method.invoke(node);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//如果内容有逗号，将这个字段整体用双引号括起来；如果里面还有双引号就替换成两个双引号。
					str += "," + "\"" + (value == null ? "" : value.toString().replace("\"", "\"\""))+ "\"";
				}
				str = Tools.isNullOrEmpty(str) ? "" : str.substring(1);
				str +=  "\n";
				toClient.write(str.getBytes("utf-8"));
			}
			
			toClient.flush();
			toClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
