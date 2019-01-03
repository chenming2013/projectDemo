package com.chenming.core.jihe;

public class Product
{
	private String name;
	private String id;		
	private double price;

	public String toString()
	{
		return name + "_" + id + "_" + price; 
	}
	public Product()
	{
	}
	public Product(String name,String id,double price)
	{
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	public String getId()
	{
		return this.id;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}
}
