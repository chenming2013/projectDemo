package handler.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 陈明
 * 
 * 这个类是用来测试当 @RequestMapping 注解用在类上的情况
 *
 */

@RequestMapping("/testRequestMappingOfClass")
@Controller
public class TestRequestMappingOfClass
{
	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestRequestMappingOfClass...method1");
		return "requestMapping/testRequestMappingOfClass_method1_success";
	}
	
	@RequestMapping("/method2")
	public String method2()
	{
		System.out.println("TestRequestMappingOfClass...method2");
		return "requestMapping/testRequestMappingOfClass_method2_success";
	}

}
