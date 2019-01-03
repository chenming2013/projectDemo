package com.chenming.core.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * 影响序列化的几种方式：
 * 	在现实应用中,有些时候不能使用默认序列化机制,比如：希望在序列化过程中忽略掉敏感数据,或者简化序列化过程。
 * 	有几种影响序列化的方法：(注意: 这里是影响序列化,并不是说是不让某变量持久化)
 * 		1、transient关键字: 
 * 			让某个成员变量的值不持久化
 * 		2、writeObject()方法与readObject()方法
 * 			让被transient声明的变量仍然能够持久化
 * 		3、Externalizable接口
 * 		4、readResolve()方法
 * 	
 * 	本程序测试 transient关键字影响序列化	
 * 
 * @author Lenovo
 *
 */
public class SerializableTest02
{
	public static void main(String[] args)
	{
		ObjectOutputStream oos = null;
		OutputStream os = null;
		
		ObjectInputStream ois = null;
		InputStream is = null;
		
		try 
		{
			//将Person2对象序列化
			os = new FileOutputStream(new File("person2.out"));
			oos = new ObjectOutputStream(os);
			Person2 p = new Person2("chenming","123456",23,Gender.MALE);
			oos.writeObject(p);
			
			
			//反序列化: 观察password的值有没有持久化
			is = new FileInputStream(new File("person2.out"));
			ois = new ObjectInputStream(is);
			Person2 p2 = (Person2)ois.readObject();
			System.out.println(p2);
			/**
			 * [name=chenming,password=null,age=23,gender=MALE]
			 * 
			 * 从这个输出结果中,可以看出Person2对象序列化的时候,并没有将password持久化,这正是我们想要的结果
			 */
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally
		{
			if(os!=null)
			{
				try
				{
					os.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					os = null;
				}
			}
			if(oos!=null) 
			{
				try 
				{
					oos.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					oos = null;
				}
			}
			if(is!=null)
			{
				try 
				{
					is.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					is = null;
				}
			}
			if(ois!=null)
			{
				try
				{
					ois.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					ois = null;
				}
			}
		}
	}
}

class Person2 implements Serializable
{
	private String name;
	
	//password是敏感数据,我们希望在序列化的时候,忽略此数据
	private transient String password;
	
	private int age;
	
	private Gender gender;
	
	/* Constructor */
	public Person2() 
	{
		System.out.println("Person2...无参构造函数");
	}
	public Person2(String name,String password,int age,Gender gender)
	{
		System.out.println("Person2...四个参数的构造函数");
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}
	
	/* Setter And Getter */
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public Gender getGender()
	{
		return gender;
	}
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	
	/* 重写toString()方法 */
	public String toString()
	{
		return "[name="+name+",password="+password+",age="+age+",gender="+gender;
	}
}
