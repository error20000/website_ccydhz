package com.ccydhz.site.entity;

import com.jian.tools.annotation.PrimaryKey;
import com.jian.tools.annotation.PrimaryKeyType;
import com.jian.tools.annotation.Table;

@Table("s_user")
public class User extends Base<User> {

	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	private int pid;
	private String username;
	private String password;
	private int system;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSystem() {
		return system;
	}
	public void setSystem(int system) {
		this.system = system;
	}
	
}
