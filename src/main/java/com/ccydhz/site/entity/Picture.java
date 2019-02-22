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
@Table("s_picture")
public class Picture  extends Base<Picture> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	@Excel(name="自增主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="分类", sort=1, value="0", length="11", isNull=1 )
	private int type;
	@Excel(name="名称", sort=2, length="100", isNull=1 )
	private String name;
	@Excel(name="原图地址", sort=3, length="255", isNull=1 )
	private String pic;
	@Excel(name="首页缩略图", sort=4, length="255", isNull=1 )
	private String pich;
	@Excel(name="列表页缩略图", sort=5, length="255", isNull=1 )
	private String picl;
	@Excel(name="日期", sort=6, length="20", isNull=1 )
	private String date;
	@Excel(name="描述", sort=7, length="255", isNull=1 )
	private String description;
	@Excel(name="下载地址", sort=8, length="255", isNull=1 )
	private String down;
	@Excel(name="作者", sort=9, length="100", isNull=1 )
	private String author;
	@Excel(name="推荐  0--否，1--是", sort=10, value="0", length="2", isNull=1 )
	private int recommend;
	@Excel(name="加精  0--否，1--是", sort=11, value="0", length="2", isNull=1 )
	private int highlight;
	@Excel(name="排序", sort=12, value="999", length="11", isNull=1 )
	private int sort;
	@Excel(name="状态   0：禁用，1：启用", sort=13, value="0", length="4", isNull=1 )
	private int status;
	@Excel(name="图片大小（KB）", sort=14, value="0", length="11", isNull=1 )
	private int size;
	
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPich() {
		return pich;
	}
	public void setPich(String pich) {
		this.pich = pich;
	}
	public String getPicl() {
		return picl;
	}
	public void setPicl(String picl) {
		this.picl = picl;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getHighlight() {
		return highlight;
	}
	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
