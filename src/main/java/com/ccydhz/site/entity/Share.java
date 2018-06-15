package com.ccydhz.site.entity;

import com.jian.tools.annotation.PrimaryKey;
import com.jian.tools.annotation.PrimaryKeyType;
import com.jian.tools.annotation.Table;

@Table("s_share")
public class Share extends Base<Share> {

	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	private int pid;
	private String date;
	private String ip;
	private String phone;
	private String info;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
