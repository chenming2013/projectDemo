package handler.cookieValue;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 @CookieValue 绑定请求中国的cookie值
 * @author Lenovo
 *
 */

@Controller
@RequestMapping("/testCookieValue")
public class TestCookieValue
{

	@RequestMapping("/method1")
	public String method1(@CookieValue("JSESSIONID") String JSessionId)
	{
		System.out.println("cookie: "+JSessionId);
		return "cookieValue/testCookieValue_success";
	}
	
}
