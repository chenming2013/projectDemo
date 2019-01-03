package com.chenming.springmvc.handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 陈明
 * 
 * @Controller 注解将这个HelloWorld类标识为控制器或者请求处理器(handler)
 *
 */
@Controller
public class HelloWorld
{
	/**
	 * 该方法是为了应答请求,所以配置 @RequestMapping 注解表示将来应答名为 hello 的请求
	 * @return
	 */
	@RequestMapping("/hello")
	public String method1()
	{
		System.out.println("HelloWorld!!!");
		return "success";  //返回 "success", 那么这个又对应哪个页面呢？这就需要配置视图解析器
	}
	
	/**
	 * 总结:
	 * 	1. 使用 @RequestMapping 注解来映射请求的URL
	 *  2. 返回值会通过 视图解析器 解析为实际的物理视图, 对于 InternalResourceViewResolver视图解析器,会做如下的解析:
	 *  	通过 (prefix + returnVal + suffix) 这样的方式得到实际的物理视图，然后做 转发 操作
	 *  	所以根据在 springmvc.xml文件中配置视图解析器,得到的实际物理视图是:
	 *  	/views/success.jsp
	 */
	
}
