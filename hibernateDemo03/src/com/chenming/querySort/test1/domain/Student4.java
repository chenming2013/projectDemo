package com.chenming.querySort.test1.domain;

import java.io.Serializable;

/**
 * 测试查询排序
 * @author 陈明
 * @date   2018年7月17日
 */
public class Student4 implements Serializable
{
	private String id;
	
	private String name;
	
	private String description;
	
	private Team4 team4;

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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Team4 getTeam4()
	{
		return team4;
	}

	public void setTeam4(Team4 team4)
	{
		this.team4 = team4;
	}
	
	
}
