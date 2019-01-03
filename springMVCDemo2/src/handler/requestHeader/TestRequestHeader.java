package handler.requestHeader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 @RequestHeader 绑定请求报头属性值
 * @author Lenovo
 *
 */

@Controller
@RequestMapping("/testRequestHeader")
public class TestRequestHeader
{
	@RequestMapping("/method1")
	public String method1(@RequestHeader("Accept-Encoding") String encoding,@RequestHeader("Connection") String connection)
	{
		System.out.println("encoding: "+encoding+",connection: "+connection);
		return "requestHeader/testRequestHeader_success";
	}

}
