package com.chenming.test5.multipleOnetoOnePK.domain;

public class Person2
{
	private int id;
	
	private String name;
	
	private IdCard2 idCard2;

	
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

	public IdCard2 getIdCard2()
	{
		return idCard2;
	}

	public void setIdCard2(IdCard2 idCard2)
	{
		this.idCard2 = idCard2;
	}

	// ============= Setter And Getetr(End) =============
}
