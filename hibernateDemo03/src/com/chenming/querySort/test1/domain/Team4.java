package com.chenming.querySort.test1.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 测试查询排序
 * @author 陈明
 * @date   2018年7月17日
 */
public class Team4 implements Serializable
{
	private String id;
	
	private String teamName;
	
	private Set<Student4> student4s;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public Set<Student4> getStudent4s()
	{
		return student4s;
	}

	public void setStudent4s(Set<Student4> student4s)
	{
		this.student4s = student4s;
	}
	
}
