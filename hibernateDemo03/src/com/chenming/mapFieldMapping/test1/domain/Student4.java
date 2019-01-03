package com.chenming.mapFieldMapping.test1.domain;

import java.io.Serializable;

/**
 * 测试Map属性映射
 * 	一个Student只属于一个team,一个Team有多个Student
 * @author 陈明
 * @date   2018年7月17日
 */
public class Student4 implements Serializable
{
	private String id;
	
	private String cardId;
	
	private String name;
	
	private int age;
	
	private Team4 team;
	

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCardId()
	{
		return cardId;
	}

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Team4 getTeam()
	{
		return team;
	}

	public void setTeam(Team4 team)
	{
		this.team = team;
	}
	
}
