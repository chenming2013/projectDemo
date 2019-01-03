package com.chenming.test4.domain;

import java.util.Set;

public class Course3
{
	private int cid;
	
	private String name;
	
	private Set<Student3> students;

	
	// ============ Setter And Getter(Start) ================
	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Student3> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student3> students)
	{
		this.students = students;
	}
	// =============== Setter And Getter(End) =================
}
