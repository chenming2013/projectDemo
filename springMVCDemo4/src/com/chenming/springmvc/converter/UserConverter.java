package com.chenming.springmvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.chenming.springmvc.entity.Address;
import com.chenming.springmvc.entity.User;

@Component("userConverter")
public class UserConverter implements Converter<String,User>
{

	@Override
	public User convert(String source)   //这个source是传入的字符串
	{
		if(source !=null)
		{
			String[] fields = source.split("-");
			
			User user = new User();
			user.setUsername(fields[0]);
			user.setPassword(fields[1]);
			user.setEmail(fields[2]);
			user.setAge(Integer.parseInt(fields[3]));
					
			return user;
		}
		return null;
	}
	
}
