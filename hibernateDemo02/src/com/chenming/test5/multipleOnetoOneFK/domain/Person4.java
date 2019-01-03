package com.chenming.test5.multipleOnetoOneFK.domain;

import java.util.Set;

/**
 * @author 陈明
 * @date   2018年7月12日
 */
public class Person4
{
	private int id;
	
	private String name;
	
	private IdCard4 idCard4;

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

	public IdCard4 getIdCard4()
	{
		return idCard4;
	}

	public void setIdCard4(IdCard4 idCard4)
	{
		this.idCard4 = idCard4;
	}
	
}
