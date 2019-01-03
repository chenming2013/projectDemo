package handler.pathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 @pathVariable 映射绑定的占位符
 * @author Lenovo
 *
 */

@RequestMapping("/testPathVariable")
@Controller
public class TestPathVariable
{

	@RequestMapping("method1/{id}")
	public String method1(@PathVariable("id") Integer id)
	{
		System.out.println("TestPathVariable...method1()...");
		System.out.println("id: "+id);
		return "pathVariable/testPathVariable_success";
	}
	
}
