package com.chenming.springmvc.handler.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试自定义拦截器
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testMyInterceptor1")
public class TestMyInterceptor1
{

	/**
	 * 这是目标方法,拦截器拦截到目标方法的请求
	 * @return
	 */
	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestMyInterceptor1...method1()...");
		return "interceptor/testMyInterceptor1_success";
	}
}
