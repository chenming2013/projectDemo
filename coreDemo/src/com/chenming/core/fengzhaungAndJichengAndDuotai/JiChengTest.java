package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class JiChengTest
{
	public static void main(String[] args)
	{
		Student stu = new Student();
		stu.setAge(22);
		System.out.println(stu.getAge());
		stu.setName("����");
		System.out.println(stu.getName());
	}
}
class Person
{
	private String name;
	private int age;
	
	public Person()
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}	
}

class Student extends Person
{
	private String school;
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	public String getSchool()
	{
		return this.school;
	}
}
