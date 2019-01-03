package com.chenming.extendsMapping.test3.domain;

import java.util.Date;

public class People3
{
	// 父类所拥有的属性
	private String id;
	
	private String name;
	
	private String sex;
	
	private String age;
	
	private Date birthday;

	
	// =========== Setter And Getter(Start) ===========
	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	// ============ Setter And Getter(End) ============
}
