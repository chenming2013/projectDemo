package com.chenming.test2.domain;

/**
 * 学生实体
 * @author 陈明
 * @date   2018年7月12日
 */
public class Student
{
	private Integer id;
	private String name;
	public Integer getId()
	{
		return id;
	}
	
	// =========== Setter And Getter(Start) ===========
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
	// ============ Setter And Getetr(End) ============
}
