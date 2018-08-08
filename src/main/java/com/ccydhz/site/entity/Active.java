package com.ccydhz.site.entity;

//import
import com.jian.annotation.PrimaryKey;
import com.jian.annotation.PrimaryKeyType;
import com.jian.annotation.Table;
import com.jian.annotation.Excel;

/**
 * @author liujian
 * @Date 
 */
@Table("s_active")
public class Active  extends Base<Active> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	@Excel(name="自增主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="日期  yyyy-MM-dd HH:mm:ss", sort=1, length="20", isNull=1 )
	private String date;
	@Excel(name="IP", sort=2, length="255", isNull=1 )
	private String ip;
	@Excel(name="参与人", sort=3, length="255", isNull=1 )
	private String phone;
	@Excel(name="奖励pid", sort=4, value="0", length="11", isNull=1 )
	private int config;
	@Excel(name="其他信息", sort=5, length="255", isNull=1 )
	private String info;
	@Excel(name="其他信息2", sort=6, length="255", isNull=1 )
	private String info2;
	
	//get set
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
	public int getConfig() {
		return config;
	}
	public void setConfig(int config) {
		this.config = config;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}

}
