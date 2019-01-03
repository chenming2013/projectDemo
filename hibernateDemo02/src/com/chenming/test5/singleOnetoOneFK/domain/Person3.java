package com.chenming.test5.singleOnetoOneFK.domain;

import java.util.Set;

/**
 * @author 陈明
 * @date   2018年7月12日
 */
public class Person3
{
	private int id;
	
	private String name;
	
	private IdCard3 idCard3;

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

	public IdCard3 getIdCard3()
	{
		return idCard3;
	}

	public void setIdCard3(IdCard3 idCard3)
	{
		this.idCard3 = idCard3;
	}
	
	
}
