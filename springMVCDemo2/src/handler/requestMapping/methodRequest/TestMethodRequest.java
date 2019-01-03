package handler.requestMapping.methodRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这个类是用来测试 @RequestMapping 的method参数
 * 配合testMethodRequest-index.jsp 以及 methodRequest/testMethodRequest_method1_success.jsp 一起看
 * @author Lenovo
 *
 */

@Controller
@RequestMapping(value="/testMethodRequest",method=RequestMethod.POST)
public class TestMethodRequest
{
	@RequestMapping("/method1")
	public String method1()
	{
		System.out.println("TestMethodRequest...method1()...");
		return "requestMapping/methodRequest/testMethodRequest_method1_success";
	}
	
}
