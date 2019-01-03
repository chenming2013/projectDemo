package com.chenming.springmvc.handler.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这个类是用来测试异常的
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testException2")
public class TestException2
{
	/**
	 * 使用 @ExceptionHandler 注解能够捕获指定的异常
	 * 
	 * 1. 在 @ExceptionHandler 标注的方法入参中可以加入Exception类型的参数,该参数即对应发生的异常对象
	 * 2. @ExceptionHandler 标注的方法入参中不能传入Map,若希望把异常信息传导页面,需要使用ModelAndView作为返回值
	 * 3. @ExceptionHandler 标注的异常有优先级的问题: 如 ArithmeticException 就比 RunTimeException 的匹配度高
	 * 4. 
	 * @return
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView method2(Exception ex)
	{
		System.out.println("出异常了: "+ex);
		ModelAndView mv = new ModelAndView("exception/error");
		mv.addObject("exception", ex);
		return mv;
	}
	
	@RequestMapping("/method1")
	public String method1(@RequestParam int i)
	{
		int result = 10 / i;
		System.out.println("result: "+result);
		return "exception/error";
	}
}
