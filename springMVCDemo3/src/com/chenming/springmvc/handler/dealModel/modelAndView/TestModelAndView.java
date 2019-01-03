package com.chenming.springmvc.handler.dealModel.modelAndView;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试使用 ModelAndView 处理模型数据
 * 
 * 
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testModelAndView")
public class TestModelAndView
{
	/**
	 * 目标方法的返回值可以是ModelAndView类型
	 * 其中可以包含视图和模型信息
	 * SpringMVC会把ModelAndView的model中的数据放入到request域对象中
	 * @return
	 */
	@RequestMapping("/method1")
	public ModelAndView method1()
	{
		String viewName = "dealModel/modelAndView/testModelAndView_success";
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型数据到ModelAndView中
		modelAndView.addObject("time", new Date());
		
		return modelAndView;
	}
	
}
