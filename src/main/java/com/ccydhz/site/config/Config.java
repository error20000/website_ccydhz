package com.ccydhz.site.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	//自动填充主键
	public static String autoFillPrimaryKey; //自动填充主键
	//日期自动填充配置
	public static String autoFillDateForAdd; //新增日期类型自动填充
	public static String autoFillDateForModify; //修改日期类型自动填充
	//静态资源
	public static String upload_path; //文件上传地址
	public static String logs_path; //日志地址
	
	//登录session
	public static String login_session_key="login_user";

	//登录sso
	public static String sso_url;
	public static String sso_module;
	
	//短信验证码
	public static String sms_url;
	public static String sms_accessKey;
	public static String sms_secretKey;
	public static String sms_serviceId;
	public static String sms_orgId;
	public static String sms_reqId;
	public static String sms_srcId;
	public static String sms_regReport;
	public static String sms_expireTime;
	
	public static String sms_vcode_content;
	
	@Value("${sms_url}")
	public void setSms_url(String sms_url) {
		Config.sms_url = sms_url;
	}
	@Value("${sms_accessKey}")
	public void setSms_accessKey(String sms_accessKey) {
		Config.sms_accessKey = sms_accessKey;
	}
	@Value("${sms_secretKey}")
	public void setSms_secretKey(String sms_secretKey) {
		Config.sms_secretKey = sms_secretKey;
	}
	@Value("${sms_serviceId}")
	public void setSms_serviceId(String sms_serviceId) {
		Config.sms_serviceId = sms_serviceId;
	}
	@Value("${sms_orgId}")
	public void setSms_orgId(String sms_orgId) {
		Config.sms_orgId = sms_orgId;
	}
	@Value("${sms_reqId}")
	public void setSms_reqId(String sms_reqId) {
		Config.sms_reqId = sms_reqId;
	}
	@Value("${sms_srcId}")
	public void setSms_srcId(String sms_srcId) {
		Config.sms_srcId = sms_srcId;
	}
	@Value("${sms_regReport}")
	public void setSms_regReport(String sms_regReport) {
		Config.sms_regReport = sms_regReport;
	}
	@Value("${sms_expireTime}")
	public void setSms_expireTime(String sms_expireTime) {
		Config.sms_expireTime = sms_expireTime;
	}
	@Value("${sms_vcode_content}")
	public void setSms_vcode_content(String sms_vcode_content) {
		System.out.println("sms_vcode_content: "+sms_vcode_content);
		Config.sms_vcode_content = sms_vcode_content;
	}
	

	@Value("${sso_url}")
	public void setSso_url(String sso_url) {
		Config.sso_url = sso_url;
	}
	@Value("${sso_module}")
	public void setSso_module(String sso_module) {
		Config.sso_module = sso_module;
	}
	
	@Value("${login_session_key}")
	public void setLogin_session_key(String login_session_key) {
		Config.login_session_key = login_session_key;
	}
	
	@Value("${upload_path}")
	public void setUpload_path(String upload_path) {
		Config.upload_path = upload_path;
	}
	
	@Value("${logs_path}")
	public void setLogs_path(String logs_path) {
		Config.logs_path = logs_path;
	}
	
	@Value("${auto_fill_primary_key}")
	public void setAutoFillPrimaryKey(String autoFillPrimaryKey) {
		System.out.println("auto_fill_primary_key: "+autoFillPrimaryKey);
		Config.autoFillPrimaryKey = autoFillPrimaryKey;
	}
	@Value("${auto_fill_date_for_add}")
	public void setAutoFillDateForAdd(String autoFillDateForAdd) {
		System.out.println("auto_fill_date_for_add: "+autoFillDateForAdd);
		Config.autoFillDateForAdd = autoFillDateForAdd;
	}
	@Value("${auto_fill_date_for_modify}")
	public void setAutoFillDateForModify(String autoFillDateForModify) {
		System.out.println("auto_fill_date_for_modify: "+autoFillDateForModify);
		Config.autoFillDateForModify = autoFillDateForModify;
	}
	
	
}
