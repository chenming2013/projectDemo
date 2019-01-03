package com.chenming.mapFieldMapping.test1.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map属性映射
 * 	一个Team只能够包含多个Student
 * @author 陈明
 * @date   2018年7月17日
 */
public class Team4
{
	private String id;
	
	private String teamName;
	
	private Map students = new HashMap();

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

	public Map getStudents()
	{
		return students;
	}

	public void setStudents(Map students)
	{
		this.students = students;
	}
	
}
