package com.chenming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenming.util.OfficeToHTMLUtil;

import net.sf.json.JSONObject;

public class WordToHTMLServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			String url = req.getRequestURL().toString();
			String realPath = req.getRealPath("/");
			String filePath = "\\file\\demo\\";
			String fileName = "1.doc";
			OfficeToHTMLUtil.Word2HTML(realPath+filePath,fileName,filePath);
			PrintWriter writer = resp.getWriter();
			//writer.write(content);
			//req.getRequestDispatcher(filePath+"测试问题2018－6－2.html").forward(req, resp);
			//resp.sendRedirect(filePath+"1.html");
			Map map = new HashMap();
			map.put("success", true);
			JSONObject jsonObject = JSONObject.fromObject(map);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.append(jsonObject.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
