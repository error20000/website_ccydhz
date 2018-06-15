package com.ccydhz.site.entity;

import com.jian.tools.annotation.PrimaryKey;
import com.jian.tools.annotation.PrimaryKeyType;
import com.jian.tools.annotation.Table;

@Table("s_active_config")
public class ActiveConfig extends Base<ActiveConfig> {

	@PrimaryKey(type=PrimaryKeyType.NORMAL)
	private int pid;
	private int type;
	private String name;
	private String painter;
	private String cv;
	private String ship;
	private int star;
	private String pic;
	private String desc;
	private String info;
	private int sort;
	private double chance;
	private String chance_z;
	private int count;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPainter() {
		return painter;
	}
	public void setPainter(String painter) {
		this.painter = painter;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getShip() {
		return ship;
	}
	public void setShip(String ship) {
		this.ship = ship;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public double getChance() {
		return chance;
	}
	public void setChance(double chance) {
		this.chance = chance;
	}
	public String getChance_z() {
		return chance_z;
	}
	public void setChance_z(String chance_z) {
		this.chance_z = chance_z;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
