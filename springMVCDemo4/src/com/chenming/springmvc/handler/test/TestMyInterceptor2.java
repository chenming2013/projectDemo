package com.chenming.springmvc.handler.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试自定义拦截器
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testMyInterceptor2")
public class TestMyInterceptor2
{

	/**
	 * 这是目标方法,拦截器拦截到目标方法的请求
	 * @return
	 */
	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestMyInterceptor2...method1()...");
		return "interceptor/testMyInterceptor2_success";
	}
}
