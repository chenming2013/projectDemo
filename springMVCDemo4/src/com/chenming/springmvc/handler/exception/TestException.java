package com.chenming.springmvc.handler.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这个类是用来测试异常的
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testException")
public class TestException
{
	
	@RequestMapping("/method1")
	public String method1(@RequestParam int i)
	{
		int result = 10 / i;
		System.out.println("result: "+result);
		return "exception/testException_success";
	}
}
