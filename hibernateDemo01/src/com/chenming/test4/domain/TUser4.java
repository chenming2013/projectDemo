package com.chenming.test4.domain;

import java.util.List;
/**
 * 
 * @author 陈明
 * @date   2018年7月11日
 */
public class TUser4
{
	private int id;
	
	private String name;
	
	private Integer age;
	
	private List<String> email;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public List<String> getEmail()
	{
		return email;
	}

	public void setEmail(List<String> email)
	{
		this.email = email;
	}
	
}
