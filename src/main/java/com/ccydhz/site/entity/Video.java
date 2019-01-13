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
@Table("s_video")
public class Video  extends Base<Video> {
	
	//field
	@PrimaryKey(type=PrimaryKeyType.AUTO_INCREMENT)
	@Excel(name="自增主键", sort=0, length="11", isNull=0 )
	private int pid;
	@Excel(name="分类", sort=1, value="0", length="11", isNull=1 )
	private int type;
	@Excel(name="名称", sort=2, length="100", isNull=1 )
	private String name;
	@Excel(name="封面图片", sort=3, length="255", isNull=1 )
	private String pic;
	@Excel(name="类型  0：视频，1：音频", sort=4, value="0", length="4", isNull=1 )
	private int mark;
	@Excel(name="OGG", sort=5, length="255", isNull=1 )
	private String ogg;
	@Excel(name="MP4", sort=6, length="255", isNull=1 )
	private String mp4;
	@Excel(name="WEBM", sort=7, length="255", isNull=1 )
	private String webm;
	@Excel(name="flash", sort=8, length="255", isNull=1 )
	private String flash;
	@Excel(name="视频网址", sort=9, length="255", isNull=1 )
	private String video;
	@Excel(name="MP3", sort=10, length="255", isNull=1 )
	private String mp3;
	@Excel(name="WAV", sort=11, length="255", isNull=1 )
	private String wav;
	@Excel(name="音频网址", sort=12, length="255", isNull=1 )
	private String audio;
	@Excel(name="发布日期", sort=13, length="20", isNull=1 )
	private String date;
	@Excel(name="描述", sort=14, length="", isNull=1 )
	private String description;
	@Excel(name="作者", sort=15, length="255", isNull=1 )
	private String author;
	@Excel(name="推荐  0--否，1--是", sort=16, value="0", length="2", isNull=1 )
	private int recommend;
	@Excel(name="加精  0--否，1--是", sort=17, value="0", length="2", isNull=1 )
	private int highlight;
	@Excel(name="下载地址", sort=18, length="255", isNull=1 )
	private String down;
	@Excel(name="排序", sort=19, value="999", length="11", isNull=1 )
	private int sort;
	@Excel(name="状态   0：禁用，1：启用", sort=20, value="0", length="4", isNull=1 )
	private int status;
	
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
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getOgg() {
		return ogg;
	}
	public void setOgg(String ogg) {
		this.ogg = ogg;
	}
	public String getMp4() {
		return mp4;
	}
	public void setMp4(String mp4) {
		this.mp4 = mp4;
	}
	public String getWebm() {
		return webm;
	}
	public void setWebm(String webm) {
		this.webm = webm;
	}
	public String getFlash() {
		return flash;
	}
	public void setFlash(String flash) {
		this.flash = flash;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getMp3() {
		return mp3;
	}
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	public String getWav() {
		return wav;
	}
	public void setWav(String wav) {
		this.wav = wav;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
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
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
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

}
