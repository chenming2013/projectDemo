package com.chenming.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testHelloView")
public class TestHelloView
{

	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestHelloView...method1()...");
		
		return "helloView";
	}
	
}
