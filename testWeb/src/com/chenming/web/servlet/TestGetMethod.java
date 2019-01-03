package com.chenming.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestGetMethod extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 下面一个实例说明,tomcat8是按照utf-8对URL进行解码的
		 */
		String name = req.getParameter("name");
		byte[] bytes = name.getBytes("UTF-8");
		String nStr = new String(bytes,"utf-8");
		for(byte b:bytes) {
			char ch = (char)b;
			System.out.println("ch: "+ch);
		}
		
		System.out.println("name: "+name);
		
	}
}
