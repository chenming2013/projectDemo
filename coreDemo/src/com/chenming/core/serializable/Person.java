package com.chenming.core.serializable;
import java.io.*;
public class Person implements Serializable
{
	private String name;
	private Integer age;
	private Gender gender;

	/* Constructor */
	public Person()
	{
		System.out.println("无参构造函数...");
	}
	public Person(String name,Integer age,Gender gender)
	{
		System.out.println("三个参数的构造函数...");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	/* Setter And Getter */
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	public Gender getGender()
	{
		return this.gender;
	}
	
	/* 重写toString()方法 */
	public String toString()
	{
		return "["+name+","+age+","+gender+"]";
	}
}