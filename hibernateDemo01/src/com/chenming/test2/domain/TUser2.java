package com.chenming.test2.domain;

import java.util.Date;

public class TUser2
{
	private int id;
	
	private String name;
	
	private Date birthday;
	
	private int age;
	
	/* Constructor */
	public TUser2() {}

	
	/* <=====================Setter And Getter(Start)====================> */
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

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	/* <=====================Setter And Getter(End)====================> */
}
