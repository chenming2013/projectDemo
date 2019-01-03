package com.chenming.test3.domain;

import java.util.Set;

public class Class2
{
	private Integer id;
	
	private String name;
	
	private Set<Student2> students;

	
	// ============ Setter And Getter(Start) ============
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Set<Student2> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student2> students)
	{
		this.students = students;
	}
	// ============== Setter And Getter(End) ===============
	
}
