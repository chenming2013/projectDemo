package com.chenming.test1.entity;

public class TUser
{
	private Integer id;
	
	private String name;
	
	/* Constructor */
	public TUser() {}
	public TUser(Integer id,String name) 
	{
		this.id = id;
		this.name = name;
	}

	/* <============= Setter And Getter(Start) ===========> */
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
	/* <============= Setter And Getter(End) ===========> */
}
