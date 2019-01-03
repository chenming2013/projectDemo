package com.chenming.core.generic;

//测试泛型类型可以是泛型类
public class GenericDemo2
{
	public static void main(String[] args)
	{
		GenericClass2< GenericClass2<Student> > gc = new GenericClass2< GenericClass2<Student> >();
		GenericClass2<Student> gc2 = new GenericClass2<Student>();
		gc2.setData(new Student("zhangsan"));
		gc.setData(gc2);
		
		System.out.println(gc.getData().getData());
	}
}
//定义一个泛型类
class GenericClass2<T>
{
	private T data;
	public GenericClass2()
	{
		
	}
	public GenericClass2(T data)
	{
		this.data = data;
	}
	//setter、getter方法
	public void setData(T data)
	{
		this.data = data;
	}
	public T getData()
	{
		return this.data;
	}
}



class Student
{
	private String name;
	//构造方法
	public Student()
	{
		
	}
	public Student(String name)
	{
		this.name = name;
	}
	//setter、getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	//重写toString()
	public String toString()
	{
		return this.name;
	}
}
