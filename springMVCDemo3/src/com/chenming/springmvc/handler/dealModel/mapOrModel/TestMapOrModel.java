package com.chenming.springmvc.handler.dealModel.mapOrModel;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试：
 * 	入参为org.springframework.ui.Model、org.springframework.ui.ModelMap或java.util.Map时，
 * 	处理方法返回时，Map中的数据会自动添加到模型中
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testMapOrModel")
public class TestMapOrModel
{

	/**
	 * 目标方法可以添加Map类型的参数,也可以是Model或者ModelMap类型的参数
	 * @param map
	 * @return
	 */
	@RequestMapping("/method1")
	public String method1(Map<String,Object> map)
	{
		map.put("names", Arrays.asList("Tom","Jerry","Mike","Chenming"));
		return "dealModel/mapOrModel/testMapOrModel_success";
	}
	
}
