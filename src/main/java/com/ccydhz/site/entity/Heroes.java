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
	@Excel(name="自增主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="", sort=1, length="20", isNull=1 )
	private String date;
	@Excel(name="名称", sort=2, length="100", isNull=1 )
	private String name;
	@Excel(name="分类", sort=3, length="10", isNull=1 )
	private int type;
	@Excel(name="星等", sort=4, length="4", isNull=1 )
	private int star;
	@Excel(name="等级", sort=5, length="4", isNull=1 )
	private int level;
	@Excel(name="图片", sort=6, length="", isNull=1 )
	private String img1;
	@Excel(name="图片", sort=7, length="", isNull=1 )
	private String img2;
	@Excel(name="图片", sort=8, length="", isNull=1 )
	private String img3;
	@Excel(name="描述", sort=9, length="", isNull=1 )
	private String word;
	@Excel(name="背景故事", sort=10, length="", isNull=1 )
	private String story;
	@Excel(name="技能介绍", sort=11, length="", isNull=1 )
	private String skill;
	@Excel(name="属性", sort=12, length="10", isNull=1 )
	private int attr1;
	@Excel(name="属性", sort=13, length="10", isNull=1 )
	private int attr2;
	@Excel(name="属性", sort=14, length="10", isNull=1 )
	private int attr3;
	@Excel(name="属性", sort=15, length="10", isNull=1 )
	private int attr4;
	@Excel(name="标签：多个标签“ , ”分隔。", sort=16, length="", isNull=1 )
	private String tags;
	@Excel(name="排序", sort=17, value="999", length="11", isNull=1 )
	private int sort;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getAttr1() {
		return attr1;
	}
	public void setAttr1(int attr1) {
		this.attr1 = attr1;
	}
	public int getAttr2() {
		return attr2;
	}
	public void setAttr2(int attr2) {
		this.attr2 = attr2;
	}
	public int getAttr3() {
		return attr3;
	}
	public void setAttr3(int attr3) {
		this.attr3 = attr3;
	}
	public int getAttr4() {
		return attr4;
	}
	public void setAttr4(int attr4) {
		this.attr4 = attr4;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}

}
