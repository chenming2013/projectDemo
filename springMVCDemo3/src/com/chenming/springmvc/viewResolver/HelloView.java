package com.chenming.springmvc.viewResolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 测试自定义视图
 * @author Lenovo
 *
 */

@Component     //将自定义的视图放入IOC容器中
public class HelloView implements View
{

	@Override
	public String getContentType()
	{
		// TODO Auto-generated method stub
		return "text/html";
	}

	//render()方法是渲染视图
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// TODO Auto-generated method stub
		response.getWriter().print("HelloView...render()...");
	}

}
