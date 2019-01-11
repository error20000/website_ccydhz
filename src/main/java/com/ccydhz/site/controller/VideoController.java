package com.ccydhz.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.annotation.API;
import com.jian.annotation.ParamsInfo;
import com.jian.tools.core.ResultKey;

import com.ccydhz.site.entity.Video;
import com.ccydhz.site.service.VideoService;

@Controller
@RequestMapping("/api/video")
@API(info="", entity={Video.class})
public class VideoController extends BaseController<Video> {

	@Autowired
	private VideoService service;
	
	@Override
	public void initService() {
		super.service = service;
	}
	
	//TODO 基本方法
	
	@Override
	@RequestMapping("/add")
    @ResponseBody
	@API(name="新增", 
		info="需登录认证", 
		request={
				//add request
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="封面图片"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="类型  0：视频，1：音频"),
				@ParamsInfo(name="ogg", type="String", isNull=0,  info="OGG"),
				@ParamsInfo(name="mp4", type="String", isNull=0,  info="MP4"),
				@ParamsInfo(name="webm", type="String", isNull=0,  info="WEBM"),
				@ParamsInfo(name="flash", type="String", isNull=0,  info="flash"),
				@ParamsInfo(name="video", type="String", isNull=0,  info="视频网址"),
				@ParamsInfo(name="mp3", type="String", isNull=0,  info="MP3"),
				@ParamsInfo(name="wav", type="String", isNull=0,  info="WAV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频网址"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="发布日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String add(HttpServletRequest req) {
		return super.add(req);
	}


	@Override
	@RequestMapping("/update")
    @ResponseBody
	@API(name="修改", 
		info="需登录认证", 
		request={
				//modify request
				@ParamsInfo(info="修改条件："),
				@ParamsInfo(name="pid", type="int", isNull=1,  info="自增主键"),
				@ParamsInfo(info="可修改字段："),
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="封面图片"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="类型  0：视频，1：音频"),
				@ParamsInfo(name="ogg", type="String", isNull=0,  info="OGG"),
				@ParamsInfo(name="mp4", type="String", isNull=0,  info="MP4"),
				@ParamsInfo(name="webm", type="String", isNull=0,  info="WEBM"),
				@ParamsInfo(name="flash", type="String", isNull=0,  info="flash"),
				@ParamsInfo(name="video", type="String", isNull=0,  info="视频网址"),
				@ParamsInfo(name="mp3", type="String", isNull=0,  info="MP3"),
				@ParamsInfo(name="wav", type="String", isNull=0,  info="WAV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频网址"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="发布日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String update(HttpServletRequest req) {
		return super.update(req);
	}

	@Override
	@RequestMapping("/delete")
    @ResponseBody
	@API(name="删除", 
		info="需登录认证", 
		request={
				//delete request
				@ParamsInfo(name="pid", type="int", isNull=1,  info="自增主键"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="", info="数据集"),
		})
	public String delete(HttpServletRequest req) {
		return super.delete(req);
	}

	@Override
	@RequestMapping("/findPage")
    @ResponseBody
	@API(name="分页查询", 
		info="需登录认证", 
		request={
				@ParamsInfo(name="page", type="int", isNull=1, info="页码"),
				@ParamsInfo(name="rows", type="int", isNull=1, info="每页条数"),
				//findPage request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="封面图片"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="类型  0：视频，1：音频"),
				@ParamsInfo(name="ogg", type="String", isNull=0,  info="OGG"),
				@ParamsInfo(name="mp4", type="String", isNull=0,  info="MP4"),
				@ParamsInfo(name="webm", type="String", isNull=0,  info="WEBM"),
				@ParamsInfo(name="flash", type="String", isNull=0,  info="flash"),
				@ParamsInfo(name="video", type="String", isNull=0,  info="视频网址"),
				@ParamsInfo(name="mp3", type="String", isNull=0,  info="MP3"),
				@ParamsInfo(name="wav", type="String", isNull=0,  info="WAV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频网址"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="发布日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
				@ParamsInfo(name=ResultKey.TOTAL, type="int", info="总数"),
		})
	public String findPage(HttpServletRequest req) {
		return super.findPage(req);
	}

	@Override
	@RequestMapping("/findOne")
    @ResponseBody
	@API(name="查询一个", 
		info="需登录认证", 
		request={
				//findOne request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="封面图片"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="类型  0：视频，1：音频"),
				@ParamsInfo(name="ogg", type="String", isNull=0,  info="OGG"),
				@ParamsInfo(name="mp4", type="String", isNull=0,  info="MP4"),
				@ParamsInfo(name="webm", type="String", isNull=0,  info="WEBM"),
				@ParamsInfo(name="flash", type="String", isNull=0,  info="flash"),
				@ParamsInfo(name="video", type="String", isNull=0,  info="视频网址"),
				@ParamsInfo(name="mp3", type="String", isNull=0,  info="MP3"),
				@ParamsInfo(name="wav", type="String", isNull=0,  info="WAV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频网址"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="发布日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(info="注意：以上条件不可同时为空。"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Object", info="数据集"),
		})
	public String findOne(HttpServletRequest req) {
		return super.findOne(req);
	}

	@Override
	@RequestMapping("/findList")
    @ResponseBody
	@API(name="查询多个", 
		info="需登录认证", 
		request={
				//findList request
				@ParamsInfo(info="可选条件："),
				@ParamsInfo(name="pid", type="int", isNull=0,  info="自增主键"),
				@ParamsInfo(name="type", type="int", isNull=0,  info="分类"),
				@ParamsInfo(name="name", type="String", isNull=0,  info="名称"),
				@ParamsInfo(name="pic", type="String", isNull=0,  info="封面图片"),
				@ParamsInfo(name="mark", type="int", isNull=0,  info="类型  0：视频，1：音频"),
				@ParamsInfo(name="ogg", type="String", isNull=0,  info="OGG"),
				@ParamsInfo(name="mp4", type="String", isNull=0,  info="MP4"),
				@ParamsInfo(name="webm", type="String", isNull=0,  info="WEBM"),
				@ParamsInfo(name="flash", type="String", isNull=0,  info="flash"),
				@ParamsInfo(name="video", type="String", isNull=0,  info="视频网址"),
				@ParamsInfo(name="mp3", type="String", isNull=0,  info="MP3"),
				@ParamsInfo(name="wav", type="String", isNull=0,  info="WAV"),
				@ParamsInfo(name="audio", type="String", isNull=0,  info="音频网址"),
				@ParamsInfo(name="date", type="String", isNull=0,  info="发布日期"),
				@ParamsInfo(name="description", type="String", isNull=0,  info="描述"),
				@ParamsInfo(name="author", type="String", isNull=0,  info="作者"),
				@ParamsInfo(name="recommend", type="int", isNull=0,  info="推荐  0--否，1--是"),
				@ParamsInfo(name="highlight", type="int", isNull=0,  info="加精  0--否，1--是"),
				@ParamsInfo(name="down", type="String", isNull=0,  info="下载地址"),
				@ParamsInfo(name="sort", type="int", isNull=0,  info="排序"),
				@ParamsInfo(info="注意：以上条件不可同时为空。"),
		}, 
		response={
				@ParamsInfo(name=ResultKey.CODE, type="int", info="返回码"),
				@ParamsInfo(name=ResultKey.MSG, type="String", info="状态描述"),
				@ParamsInfo(name=ResultKey.DATA, type="Array", info="数据集"),
		})
	public String findList(HttpServletRequest req) {
		return super.findList(req);
	}
	
	//TODO 自定义方法
	
}
