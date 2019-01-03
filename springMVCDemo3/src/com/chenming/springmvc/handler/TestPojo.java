package com.chenming.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenming.springmvc.entity.User;

/**
 * 测试 方法中的参数是 POJO类
 * @author Lenovo
 *
 */

@Controller
@RequestMapping("/testPojo")
public class TestPojo
{
	@RequestMapping("/method1")
	public String method1(@ModelAttribute User user)
	{
		System.out.println("user: "+user);
		return "pojo/testPojo_success";
		
	}
	
}
