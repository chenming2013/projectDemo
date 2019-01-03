package com.chenming.test1.domain;

/**
 * 多个User对应一个Group,多的一方维护关系
 * @author 陈明
 * @date   2018年7月12日
 */
public class User
{
	private Integer id;
	private String name;
	private Group group;
	
	
	// ============ Setter And Getter(Start) ==========
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
	public Group getGroup()
	{
		return group;
	}
	public void setGroup(Group group)
	{
		this.group = group;
	}
	// =========== Setter And Getter(End) ==========
}
