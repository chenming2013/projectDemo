package com.chenming.core.jihe;

public class Student
{
	private String name;
	private String id;
	public Student()
	{
		
	}
	public Student(String name,String id)
	{
		this.name = name;
		this.id = id;
	}
	public String toString()
	{
		return "Student [name=" + name + ", id=" + id + "]";
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
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("hashCode: "+result);
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
		Student other = (Student) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/*
	public boolean equals(Object obj)
	{
		if(obj==this)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		Student s = (Student)obj;
		if(this.name==null)
		{
			if(s.name!=null)
				return false;
		}
		else if(!name.equals(s.name))  //注意：这里name调用的equals()方法是String重写后的方法，比较的是具体的字符串
			return false;
		if(this.id==null)
		{
			if(s.id!=null)
				return false;
		}
		else if(!this.id.equals(s.id))
			return false;
		return true;
	}
	*/
	
}
