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
@Table("s_strategy")
public class Strategy  extends Base<Strategy> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	@Excel(name="自增主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="分类", sort=1, value="0", length="11", isNull=1 )
	private int type;
	@Excel(name="推荐  0--否，1--是", sort=2, value="0", length="2", isNull=1 )
	private int recommend;
	@Excel(name="插图", sort=3, length="255", isNull=1 )
	private String illustration;
	@Excel(name="标题", sort=4, length="255", isNull=1 )
	private String title;
	@Excel(name="副标题", sort=5, length="255", isNull=1 )
	private String title2;
	@Excel(name="日期", sort=6, length="20", isNull=1 )
	private String date;
	@Excel(name="使用链接：0--否，1--是", sort=7, value="0", length="2", isNull=1 )
	private int marks;
	@Excel(name="链接地址", sort=8, length="255", isNull=1 )
	private String site;
	@Excel(name="内容", sort=9, length="", isNull=1 )
	private String content;
	@Excel(name="关键字（seo）", sort=10, length="", isNull=1 )
	private String keywords;
	@Excel(name="描述（seo）", sort=11, length="", isNull=1 )
	private String description;
	@Excel(name="作者", sort=12, length="255", isNull=1 )
	private String author;
	@Excel(name="描述 文章、作者类", sort=13, length="", isNull=1 )
	private String description2;
	@Excel(name="加精  0--否，1--是", sort=14, value="0", length="2", isNull=1 )
	private int highlight;
	
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
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getIllustration() {
		return illustration;
	}
	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public int getHighlight() {
		return highlight;
	}
	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}

}
