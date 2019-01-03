package com.chenming.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试自定义拦截器
 * @author Lenovo
 *
 */
public class MyInterceptor2 implements HandlerInterceptor
{

	/**
	 * 该方法在渲染视图之后被调用
	 * 
	 * 释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor2...afterCompletion()...");
	}

	/**
	 * 该方法在目标方法之后,但渲染视图之前被调用
	 * 
	 * 可以对请求域中的属性或视图做出修改
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor2...postHandle()...");
	}

	/**
	 * 该方法在目标方法之前被调用
	 * 若返回值为true,则继续调用后续拦截器和目标方法
	 * 若返回值为false,则不会再调用后续的拦截器和目标方法
	 * 
	 * 可以考虑做权限、日志、事务等
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception
	{
		System.out.println("MyInterceptor2...preHandle()...");
		return true;
	}

}
