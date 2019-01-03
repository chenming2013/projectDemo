package handler.requestMapping.paramRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 @RequestMapping 注解的 param参数
 * 配合testParamRequest_index.jsp 和 paramRequest/* 一起看
 * 
 * @author Lenovo
 *
 */

@Controller
@RequestMapping("/testParamRequest")
public class TestParamRequest
{

	/**
	 * 请求参数中要包含username
	 * @return
	 */
	@RequestMapping(value="method1",params="username")
	public String method1()
	{
		System.out.println("TestParamRequest...method1()...");
		
		return "requestMapping/paramRequest/testMethodRequest_success";
	}
	
	
	/**
	 * 请求参数中不仅要包含username,且username=test
	 * @return
	 */
	@RequestMapping(value="method2",params="username=test")
	public String method2()
	{
		System.out.println("TestParamRequest...method2()...");
		
		return "requestMapping/paramRequest/testMethodRequest_success";
	}
	
	
	/**
	 * 两个请求参数username,age,且username=test
	 * @return
	 */
	@RequestMapping(value="method3",params= {"username=test","age"})
	public String method3()
	{
		System.out.println("TestParamRequest...method3()...");
		
		return "requestMapping/paramRequest/testMethodRequest_success";
	}
	
	
	/**
	 * 两个请求参数username,age,且username=test,且指定headres
	 * @return
	 */
	@RequestMapping(value="method4",params= {"username=test","age"},headers= {"Accept-Language=zh-CN,zh;q=0.8","Host=localhost:8088"})
	public String method4()
	{
		System.out.println("TestParamRequest...method4()...");
		
		return "requestMapping/paramRequest/testMethodRequest_success";
	}
}
