package com.chenming.test5.singleOnetoOnePK.domain;

public class Person
{
	private int id;
	
	private String name;
	
	private IdCard idCard;

	
	// ========== Setter And Getter(Start) =============
	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public IdCard getIdCard()
	{
		return idCard;
	}

	public void setIdCard(IdCard idCard)
	{
		this.idCard = idCard;
	}
	// ============= Setter And Getetr(End) =============
}
