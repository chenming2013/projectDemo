package handler.requestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试 @RequestParam 获取请求参数
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testRequestParam")
public class TestRequestParam
{

	@RequestMapping("/method1")
	public String method1(@RequestParam(value="id",required=false) Integer id,@RequestParam(value="name") String name)
	{
		System.out.println("id: "+id+",name: "+name);
		return "requestParam/testRequestParam_success";
	}
	
	/**
	 * 因为传参都是String类型的,上面的将String类型转换成Integer类型没有任何问题,但是将String类型转换成int类型就会报错
	 * 
	 * 报错信息:
	 * 	HTTP Status 500 - Request processing failed; 
	 * 		nested exception is org.springframework.web.bind.annotation.support.HandlerMethodInvocationException: Failed to invoke handler method [public java.lang.String handler.requestParam.TestRequestParam.method2(int,java.lang.String)]; 
	 * 		nested exception is java.lang.IllegalStateException: Optional int parameter 'id' is not present but cannot be translated into a null value due to being declared as a primitive type. 
	 * 		Consider declaring it as object wrapper for the corresponding primitive type.
	 * 
	 * 这时需要添加一个defaultvalue参数
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/method2")
	public String method2(@RequestParam(value="id",required=false,defaultValue="0") int id,@RequestParam("name") String name)
	{
		System.out.println("id: "+id+",name: "+name);
		return "requestParam/testRequestParam_success";
	}
}
