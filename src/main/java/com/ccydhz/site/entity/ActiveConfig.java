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
@Table("s_active_config")
public class ActiveConfig  extends Base<ActiveConfig> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.NORMAL)
	@Excel(name="主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="分类", sort=1, value="0", length="11", isNull=1 )
	private int type;
	@Excel(name="名称", sort=2, length="255", isNull=1 )
	private String name;
	@Excel(name="画师", sort=3, length="255", isNull=1 )
	private String painter;
	@Excel(name="CV", sort=4, length="255", isNull=1 )
	private String cv;
	@Excel(name="舰种", sort=5, length="255", isNull=1 )
	private String ship;
	@Excel(name="星级", sort=6, value="0", length="4", isNull=1 )
	private int star;
	@Excel(name="图片", sort=7, length="255", isNull=1 )
	private String pic;
	@Excel(name="描述", sort=8, length="", isNull=1 )
	private String desc;
	@Excel(name="附加信息", sort=9, length="255", isNull=1 )
	private String info;
	@Excel(name="排序", sort=10, value="999", length="10", isNull=1 )
	private int sort;
	@Excel(name="概率", sort=11, value="0", length="", isNull=1 )
	private double chance;
	@Excel(name="中奖区间", sort=12, length="255", isNull=1 )
	private String chance_z;
	@Excel(name="数量  -1  不限", sort=13, value="0", length="10", isNull=1 )
	private int count;
	
	//get set
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
