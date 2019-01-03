package com.chenming.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestResponse extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//设置
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		byte[] bytes = "危楼高百尺".getBytes("utf-8");
		response.getOutputStream().write(bytes);
		
	}
}
