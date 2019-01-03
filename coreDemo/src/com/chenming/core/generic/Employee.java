package com.chenming.core.generic;

/*
 定义一个Employee类，
该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
并为每一个属性定义 getter, setter 方法；
并重写 toString 方法输出 name, age, birthday
*/
public class Employee implements Comparable<Employee>
{
	private String name;
	private int age;
	private MyDate birthday;
	
	public Employee(String name, int age, MyDate birthday)
	{
		super();  //调用Object()
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	//setter、getter方法
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public MyDate getBirthday()
	{
		return birthday;
	}
	public void setBirthday(MyDate birthday)
	{
		this.birthday = birthday;
	}
	//重写toString()方法
	@Override
	public String toString()
	{
		return "Employee [name=" + name + ", age=" + age + ", birthday="
				+ birthday + "]";
	}
	//使用到了Tree结构，那么就要排序，因此就要重写equals、hashCode方法,只有当名字、年龄、出生日期一样才认为是同一个对象
	@Override
	//重写Comparable接口中的compareTo()方法,并且按照name排序
	public int compareTo(Employee o)
	{
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (birthday == null)
		{
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
