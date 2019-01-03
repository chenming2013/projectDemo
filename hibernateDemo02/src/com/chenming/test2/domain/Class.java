package com.chenming.test2.domain;

import java.util.List;
import java.util.Set;

/**
 * 班级实体
 * 	一个班级对应许多学生,为一对多关系
 * @author 陈明
 * @date   2018年7月12日
 */
public class Class
{
	private Integer id;
	private String name;
	private Set<Student> students;
	
	// =========== Setter And Getter(Start) ============
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
	public Set<Student> getStudents()
	{
		return students;
	}
	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
	// ============= Setter And Getter(End) ============
}
