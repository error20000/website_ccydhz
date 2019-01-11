package com.ccydhz.site.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.ueditor.ActionEnter;

@WebServlet(name="UeditorServlet", urlPatterns={"/api/ueditor"})
public class UeditorServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rootPath = "/config.json";
		String str = new ActionEnter( req, rootPath ).exec();
		PrintWriter out = resp.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}

	//controller 会读取流，导致ueditor无法读取流。
}
