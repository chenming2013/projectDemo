package com.chenming.core.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

//测试ObjectInputStream、ObjectOutPutStream
public class IODemo11
{
	public static void main(String[] args)
	{
//		序列化
//		try
//		{
//			Student stu = new Student("zhangsan",30);
//			FileOutputStream fis = new FileOutputStream("d:\\aa.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fis);   //把对象序列化到指定的文件输出流中
//			oos.writeObject(stu);
//			System.out.println("操作成功");
//			oos.close();
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		反序列化
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\aa.txt"));
			Student stu = (Student)ois.readObject();
			System.out.println(stu);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//要序列化的对象必须实现Serializable接口
class Student implements Serializable
{
	private String name;
	private int age;
	public Student(String name,int age)
	{
		this.name = name;
		this.age = age;
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
	public String toString()
	{
		return this.name+"--"+this.age;
	}
}