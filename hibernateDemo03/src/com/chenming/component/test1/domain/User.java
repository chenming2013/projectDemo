package com.chenming.component.test1.domain;


/**
 * 测试组件映射
 * @author 陈明
 * @date   2018年7月17日
 */
public class User
{
	private Integer id;
	
	private String name;
	
	private Contact contact;

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

	public Contact getContact()
	{
		return contact;
	}

	public void setContact(Contact contact)
	{
		this.contact = contact;
	}
	
}
