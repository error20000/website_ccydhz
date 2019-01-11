package com.ccydhz.site.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
	

	//自动填充主键
	@Value("${auto_fill_primary_key}")
	public String autoFillPrimaryKey; //自动填充主键
	
	//日期自动填充配置
	@Value("${auto_fill_date_for_add}")
	public String autoFillDateForAdd; //新增日期类型自动填充
	@Value("${auto_fill_date_for_modify}")
	public String autoFillDateForModify; //修改日期类型自动填充
	
	//静态资源
	@Value("${logs_path}")
	public String logs_path; //日志地址
	@Value("${upload_path}")
	public String upload_path; //文件上传地址
	/*	
	@Value("${upload_imgFiles}")
	public String upload_imgFiles; //上传图片格式
	@Value("${upload_docFiles}")
	public String upload_docFiles; //上传文档格式
	@Value("${upload_movFiles}")
	public String upload_movFiles; //上传视频格式
	@Value("${upload_allowFiles}")
	public String upload_allowFiles; //上传文件格式
	 */	
	
	//登录session
	@Value("${login_session_key}")
	public String login_session_key="login_user";

	//登录sso
	@Value("${sso_url}")
	public String sso_url;
	@Value("${sso_module}")
	public String sso_module;
	
	//短信验证码
	@Value("${sms_url}")
	public String sms_url;
	@Value("${sms_accessKey}")
	public String sms_accessKey;
	@Value("${sms_secretKey}")
	public String sms_secretKey;
	@Value("${sms_serviceId}")
	public String sms_serviceId;
	@Value("${sms_orgId}")
	public String sms_orgId;
	@Value("${sms_reqId}")
	public String sms_reqId;
	@Value("${sms_srcId}")
	public String sms_srcId;
	@Value("${sms_regReport}")
	public String sms_regReport;
	@Value("${sms_expireTime}")
	public String sms_expireTime;
	@Value("${sms_vcode_content}")
	public String sms_vcode_content;
	
	//微信
	@Value("${appId}")
	public String appId;
	@Value("${appSecret}")
	public String appSecret;
	@Value("${jssdkDebug}")
	public String jssdkDebug;
	

	public static Map<String, Integer> bespeakCountCache = new HashMap<>();
	
	
	
}
