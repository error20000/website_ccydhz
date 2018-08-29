package com.ccydhz.site.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jian.tools.core.Tools;

@Order(1)
@Component
@WebFilter(urlPatterns={"/*"}, filterName="urlFilter", asyncSupported=true)
public class URLFilter implements Filter {
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init....");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD, TRACE");//返回所有支持的方法，避免多次"预检"请求
		response.setHeader("Access-Control-Max-Age", "36000");//本次预检请求的有效期，单位为秒
		response.setHeader("Access-Control-Allow-Credentials", "true"); //请求允许cookie，需配合Origin使用（Origin不能配置为*），并且ajax也要withCredentials为true
		String allowHeader = "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,x_requested_with";
		String header = request.getHeader("Access-Control-Request-Headers");
		if(Tools.isNullOrEmpty(header)){
			response.setHeader("Access-Control-Allow-Headers", allowHeader);
		}else{
			response.setHeader("Access-Control-Allow-Headers", allowHeader+","+header);
		}
		
		arg2.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("filter destroy....");
	}

}
