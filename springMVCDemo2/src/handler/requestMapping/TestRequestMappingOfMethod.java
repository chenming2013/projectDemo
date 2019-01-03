package handler.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestRequestMappingOfMethod
{
	
	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestRequestMappingOfMethod...method1()...");
		return "testRequestMappingOfMethod_method1_success";
	}
	
}
