package com.ccydhz.site.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ccydhz.site.App;
import com.ccydhz.site.config.Config;
import com.jian.tools.core.DateTools;
import com.jian.tools.core.ResultKey;
import com.jian.tools.core.ResultTools;
import com.jian.tools.core.Tips;
import com.jian.tools.core.Tools;


@Controller
@RequestMapping("/api/file")
public class FileUploadController {
	
	private String imgFiles = "bmp,gif,jpeg,jpg,png";
//	private String allowFiles = "csv,doc,docx,pdf,ppt,pptx,txt,xls,xlsx,md,bmp,gif,jpeg,jpg,png,3gp,asf,avi,fla,flv,mov,mkv,mp4,ogg,webm,wmv,ra,ram,rm,rmvb,swf";
	private String docFiles = "csv,doc,docx,pdf,ppt,pptx,txt,xls,xlsx,md";
//	private String imgFiles = "bmp,gif,jpeg,jpg,png";
//	private String movFiles = "3gp,asf,avi,fla,flv,mov,mkv,mp4,ogg,webm,wmv,ra,ram,rm,rmvb,swf";
	
	@ResponseBody
	@RequestMapping("/uploadImg")
	public String upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
		
		try {
			Map<String, Object> map = new HashMap<>();
			InputStream in = file.getInputStream();
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			in.close();
			map.put("size", buffer.length);
			
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
			
			if(!(imgFiles+",").contains(suffix.toLowerCase()+",")){
				return ResultTools.custom(Tips.ERROR212).toJSONString();
			}
			
			int random = new Random().nextInt(10000);
			String str = random+"";
			for (int i = 0; i <  4 - str.length(); i++) {
				str = "0" + str;
			}
			String fileName = DateTools.formatDate("yyyyMMddHHmmssSSS")+ str + "."+ suffix;
			String resPath = DateTools.formatDate("yyyyMMdd") + "/" + fileName;
			
			String basePath = Tools.isNullOrEmpty(Config.upload_path) ? App.rootPath + "upload/" : Config.upload_path;
			String uploadDir =  basePath + resPath;
			File outFile = new File(uploadDir);
			File pfile = outFile.getParentFile();
			if(!pfile.exists()){
				pfile.mkdirs();
			}
			OutputStream out = new FileOutputStream(outFile);
			out.write(buffer);
			out.close();
			
			map.put("type", suffix);
			map.put("path", resPath);
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, map).toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultTools.custom(Tips.ERROR0).toJSONString();
	}
	
	@ResponseBody
	@RequestMapping("/uploadFile")
	public String uploadFile(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
		
		try {
			Map<String, Object> map = new HashMap<>();
			InputStream in = file.getInputStream();
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			in.close();
			map.put("size", buffer.length);
			
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
			
			if(!(docFiles+",").contains(suffix.toLowerCase()+",")){
				return ResultTools.custom(Tips.ERROR212).toJSONString();
			}
			
			int random = new Random().nextInt(10000);
			String str = random+"";
			for (int i = 0; i <  4 - str.length(); i++) {
				str = "0" + str;
			}
			String fileName = DateTools.formatDate("yyyyMMddHHmmssSSS")+ str + "."+ suffix;
			String resPath = DateTools.formatDate("yyyyMMdd") + "/" + fileName;
			
			String basePath = Tools.isNullOrEmpty(Config.upload_path) ? App.rootPath + "upload/" : Config.upload_path;
			String uploadDir =  basePath + resPath;
			File outFile = new File(uploadDir);
			File pfile = outFile.getParentFile();
			if(!pfile.exists()){
				pfile.mkdirs();
			}
			OutputStream out = new FileOutputStream(outFile);
			out.write(buffer);
			out.close();
			
			map.put("type", suffix);
			map.put("path", resPath);
			return ResultTools.custom(Tips.ERROR1).put(ResultKey.DATA, map).toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultTools.custom(Tips.ERROR0).toJSONString();
	}


	/**
	 * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";filename="snmp4j--api.zip" 
	 * IE浏览器下：form-data; name="file";filename="E:\snmp4j--api.zip"
	 * 
	 * @param header
	 *            请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 =
		 * header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

}
