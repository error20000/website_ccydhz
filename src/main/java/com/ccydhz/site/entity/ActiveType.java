package com.ccydhz.site.entity;

import com.jian.tools.annotation.PrimaryKey;
import com.jian.tools.annotation.PrimaryKeyType;
import com.jian.tools.annotation.Table;

@Table("s_active_type")
public class ActiveType extends Base<ActiveType> {

	@PrimaryKey(type=PrimaryKeyType.NORMAL)
	private int pid;
	private String name;
	private String start;
	private String end;
	private String status;
	private int count;
	private int sCount;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getsCount() {
		return sCount;
	}
	public void setsCount(int sCount) {
		this.sCount = sCount;
	}
	
}
