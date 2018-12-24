package com.chenming.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * 测试Ajax异步请求
 * @author 陈明
 * @date 2018年11月22日
 */
public class TestAjaxServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Type", "text/plain");
		
		PrintWriter out = response.getWriter();
		
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "陈明");
		map.put("age", 24);
		jsonObject.put("jsonData", map);
		
		out.write(jsonObject.toString());
		out.flush();
	}
}
