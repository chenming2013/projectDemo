package com.chenming.test4.domain;

import java.util.Set;

/**
 * @author 陈明
 * @date   2018年7月12日
 */
public class Student3
{
	private int sid;
	
	private String name;
	
	private Set<Course3> courses;

	
	// ============= Setter And Getter(Start) =============
	public int getSid()
	{
		return sid;
	}

	public void setSid(int sid)
	{
		this.sid = sid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Course3> getCourses()
	{
		return courses;
	}

	public void setCourses(Set<Course3> courses)
	{
		this.courses = courses;
	}
	// ============== Setter And Getter(End) =============
}
