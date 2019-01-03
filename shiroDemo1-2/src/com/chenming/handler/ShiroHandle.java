package com.chenming.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandle
{
	@RequestMapping("/login")
	public String login(@RequestParam(name="username") String username, @RequestParam(name="password") String password)
	{
		//获取当前的Subject 
		Subject currentUser = SecurityUtils.getSubject();
		
		//如果当前没有验证
		if(!currentUser.isAuthenticated())
		{			
			//把表单提交的用户名和密码封装为UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			//remember me
			token.setRememberMe(true);
			//执行登录
			try {
				currentUser.login(token);
			}catch (Exception e) {
				System.out.println(">>>>>>> 登录失败 <<<<<<<<");
				e.printStackTrace();
			}
		}
		
		return "redirect:/list.jsp";
	}
	
}
