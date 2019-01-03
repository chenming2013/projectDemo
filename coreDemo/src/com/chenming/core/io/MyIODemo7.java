package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyIODemo7
{
	public static void main(String[] args)
	{
		//对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制流，存储在硬盘文件中
		Person person1 = new Person("zhangsan",20);
		Person person2 = new Person("lisi",21);
		
		ObjectOutputStream oos = null;
		try
		{
			File file = new File("e:\\codeTest\\test\\MyIODemo7.txt");
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(person1);
			oos.flush();
			oos.writeObject(person2);
			oos.flush();
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(oos!=null)
			{
				try
				{
					oos.close();
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		//对象的反序列化：将硬盘中的文件通过ObjectInPutStream转换为相应的对象。
		ObjectInputStream ois = null;
		try
		{
			File file2 = new File("e:\\codeTest\\test\\MyIODemo7.txt");
			FileInputStream fis = new FileInputStream(file2);
			ois = new ObjectInputStream(fis);
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p2);
		}catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ois!=null)
			{
				try
				{
					ois.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
/*
 * 要实现序列化的类：
 * 	1.要求此类是可序列化的：实现Serializable接口
 * 	2.要求类的属性同样要实现Serializable接口
 *  3.显示的声明一个版本号：private static final long seriaVersionUID;
 *  4.使用static transient修饰的属性，不可序列化。
 */
class Person implements Serializable
{
	private static final long seriaVersionUID = 3164924938294L;
	private String name;
	private int age;
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return this.name+"--"+this.age;
	}
}