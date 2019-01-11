package com.ccydhz.site;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages="com.ccydhz.site")
@EnableAutoConfiguration
//该注解会扫描相应的包下的servlet
@ServletComponentScan
public class App {
	
	public static String rootPath = "";
	public static ApplicationContext applicationContext = null;
	public static String[] scanBasePackages = {};
	
	public static void main(String[] args) throws Exception {
		//项目目录
		rootPath = App.class.getResource("/").getPath().replace("/target/classes/", "/");
    	System.out.println(rootPath);
		//扫描范围
    	if(App.class.isAnnotationPresent(SpringBootApplication.class)){
    		SpringBootApplication sba = App.class.getAnnotation(SpringBootApplication.class);
    		scanBasePackages = sba.scanBasePackages();
    	}
    	System.out.println(scanBasePackages);
		//启动
        applicationContext = SpringApplication.run(App.class, args);
    }
	
	/**
     * 文件上传配置
     * 
     * @return
     */
    /*@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("100Mb"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("1000Mb");
        return factory.createMultipartConfig();
    }*/
	
}
