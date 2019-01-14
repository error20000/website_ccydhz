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
@Table("s_heroes")
public class Heroes  extends Base<Heroes> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	@Excel(name="自增主键", sort=0, length="11 unsigned", isNull=0 )
	private int pid;
	@Excel(name="日期", sort=1, length="20", isNull=1 )
	private String date;
	@Excel(name="舰种", sort=2, value="0", length="10", isNull=1 )
	private int type;
	@Excel(name="名称", sort=3, length="100", isNull=1 )
	private String name;
	@Excel(name="画师", sort=4, length="255", isNull=1 )
	private String painter;
	@Excel(name="CV", sort=5, length="255", isNull=1 )
	private String cv;
	@Excel(name="音频", sort=6, length="255", isNull=1 )
	private String audio;
	@Excel(name="星级", sort=7, value="0", length="4", isNull=1 )
	private int star;
	@Excel(name="简介", sort=8, length="255", isNull=1 )
	private String desc;
	@Excel(name="状态  0：禁用，1：启用", sort=9, value="0", length="4", isNull=1 )
	private int status;
	@Excel(name="排序", sort=10, value="999", length="11", isNull=1 )
	private int sort;
	@Excel(name="技能一名称", sort=11, length="255", isNull=1 )
	private String sname1;
	@Excel(name="技能一图标", sort=12, length="255", isNull=1 )
	private String sicon1;
	@Excel(name="技能一描述", sort=13, length="255", isNull=1 )
	private String sdesc1;
	@Excel(name="技能二名称", sort=14, length="255", isNull=1 )
	private String sname2;
	@Excel(name="技能二图标", sort=15, length="255", isNull=1 )
	private String sicon2;
	@Excel(name="技能二描述", sort=16, length="255", isNull=1 )
	private String sdesc2;
	@Excel(name="技能三名称", sort=17, length="255", isNull=1 )
	private String sname3;
	@Excel(name="技能三图标", sort=18, length="255", isNull=1 )
	private String sicon3;
	@Excel(name="技能三描述", sort=19, length="255", isNull=1 )
	private String sdesc3;
	@Excel(name="技能四名称", sort=20, length="255", isNull=1 )
	private String sname4;
	@Excel(name="技能四图标", sort=21, length="255", isNull=1 )
	private String sicon4;
	@Excel(name="技能四描述", sort=22, length="255", isNull=1 )
	private String sdesc4;
	@Excel(name="头像", sort=23, length="255", isNull=1 )
	private String icon;
	@Excel(name="PC图片一", sort=24, length="255", isNull=1 )
	private String img1;
	@Excel(name="PC图片二", sort=25, length="255", isNull=1 )
	private String img2;
	@Excel(name="移动图片一", sort=26, length="255", isNull=1 )
	private String img3;
	@Excel(name="移动图片二", sort=27, length="255", isNull=1 )
	private String img4;
	
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
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getSname1() {
		return sname1;
	}
	public void setSname1(String sname1) {
		this.sname1 = sname1;
	}
	public String getSicon1() {
		return sicon1;
	}
	public void setSicon1(String sicon1) {
		this.sicon1 = sicon1;
	}
	public String getSdesc1() {
		return sdesc1;
	}
	public void setSdesc1(String sdesc1) {
		this.sdesc1 = sdesc1;
	}
	public String getSname2() {
		return sname2;
	}
	public void setSname2(String sname2) {
		this.sname2 = sname2;
	}
	public String getSicon2() {
		return sicon2;
	}
	public void setSicon2(String sicon2) {
		this.sicon2 = sicon2;
	}
	public String getSdesc2() {
		return sdesc2;
	}
	public void setSdesc2(String sdesc2) {
		this.sdesc2 = sdesc2;
	}
	public String getSname3() {
		return sname3;
	}
	public void setSname3(String sname3) {
		this.sname3 = sname3;
	}
	public String getSicon3() {
		return sicon3;
	}
	public void setSicon3(String sicon3) {
		this.sicon3 = sicon3;
	}
	public String getSdesc3() {
		return sdesc3;
	}
	public void setSdesc3(String sdesc3) {
		this.sdesc3 = sdesc3;
	}
	public String getSname4() {
		return sname4;
	}
	public void setSname4(String sname4) {
		this.sname4 = sname4;
	}
	public String getSicon4() {
		return sicon4;
	}
	public void setSicon4(String sicon4) {
		this.sicon4 = sicon4;
	}
	public String getSdesc4() {
		return sdesc4;
	}
	public void setSdesc4(String sdesc4) {
		this.sdesc4 = sdesc4;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}

}
