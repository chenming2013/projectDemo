package com.chenming.springmvc.handler.dealModel.sessionAttributes;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chenming.springmvc.entity.User;

/**
 * 之前的ModelAndView、Map、ModelMap等都是将数据放入到request域对象之中,这样只适合请求转发的情况
 * 而想要将数据放入到Session之中,就需要用到 @SessionAttributes 注解
 * 
 * 加了 @SessionAttributes 注解之后,会将数据放入request域对象与session域对象中
 * 注意: @SessionAttributes 注解只能放在类上,不能放在方法上
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testSessionAttributes")
@SessionAttributes(value={"user"})  //注意: 这里的user和下面的map的key要一致,而且可以存放多个
public class TestSessionAttributes
{
	@RequestMapping("/method1")
	public String metho1(Map<String,Object> map)
	{
		User user = new User("chenming","123456","2040820766@qq.com",23);
		
		map.put("user", user);
		return "dealModel/sessionAttributes/testSessionAttributes_success";
	}
}
