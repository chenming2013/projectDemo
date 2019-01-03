package com.chenming.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试表单提交,获取表单提交的参数
 * @author ADMIN
 *
 */
public class FormServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ServletConfig servletConfig = getServletConfig();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		getServletConfig();
		String queryString = request.getQueryString();
		System.out.println("queryString: "+queryString);
		/**
		 * getParameterNames()在获取复选框的时候会出现问题,只能获取到复选框的第一个选项
		 */
		Enumeration parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String parameterName = (String)parameterNames.nextElement();
			String value = request.getParameter(parameterName);
			System.out.println("name: "+parameterName+",value: "+value);
		}
		
		System.out.println("<=============分割==============>");
		
		String[] insts = request.getParameterValues("inst");
		for(String inst:insts) {
			String value = request.getParameter(inst);
			System.out.println("name: "+inst+",value: "+value);
		}
	}
}
