package com.chenming.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * 测试编码,客户端以UTF-8的编码方式请求资源
 * @author ADMIN
 *
 */
public class EncodeServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("ISO-8859-1");
		resp.setContentType("text/html;charset=ISO-8859-1");
		String name = req.getParameter("username");
		String nStr = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		resp.encodeURL("http://www.baidu.com/");
		resp.getWriter().write(name);
	}
}
