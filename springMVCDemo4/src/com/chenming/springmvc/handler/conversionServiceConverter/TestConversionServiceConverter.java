package com.chenming.springmvc.handler.conversionServiceConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chenming.springmvc.entity.User;

@Controller
@RequestMapping("/testConversionServiceConverter")
public class TestConversionServiceConverter
{
	@RequestMapping("/method1")
	public String method1(@RequestParam("user") User user)
	{
		System.out.println("user: "+user);
		return "conversionServiceConverter/success";
	}
}
