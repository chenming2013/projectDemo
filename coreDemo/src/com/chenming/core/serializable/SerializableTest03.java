package com.chenming.core.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
 * 	本程序测试 writeObejct()方法与readObject()方法影响序列化
 * 		writeObject()方法与readObject()方法能够让被transient关键字修饰的变量仍能继续持久化	
 * 
 * @author Lenovo
 *
 */
public class SerializableTest03
{
	public static void main(String[] args)
	{
		/**
		 * Person2.java中,password变量使用transient关键字进行修饰,所以序列化Person2对象的时候,password变量值并没有持久化
		 * 如果我们现在又想将password变量也持久化,如果我们将password修饰的transient去掉,显然就有些不合理,
		 * 所以此时我们需要另一种方法能够将password持久化,这就是writeObject()与readObejct()方法
		 *
		 * 此时我们需要在Person2.java中添加writeObejct()和readObject()方法
		 * 为了不破坏之前使用Person2的测试,我们这里重新定义一个Person3.java类,与Person2.java的区别就是多了两个方法
		 */
		//序列化
		ObjectOutputStream oos = null;
		OutputStream os = null;
		
		ObjectInputStream ois = null;
		InputStream is = null;
		
		try 
		{
			//将Person2对象序列化
			os = new FileOutputStream(new File("person2.out"));
			oos = new ObjectOutputStream(os);
			Person3 p = new Person3("chenming","123456",23,Gender.MALE);
			oos.writeObject(p);
			
			
			//反序列化: 观察password的值有没有持久化
			is = new FileInputStream(new File("person2.out"));
			ois = new ObjectInputStream(is);
			Person3 p2 = (Person3)ois.readObject();
			System.out.println(p2);
			/**
			 * 输出结果: [name=chenming,password=123456,age=23,gender=MALE]
			 * 
			 * 从这个结果可以看出,即使password被transient修饰符修饰了,但是也可以让它持久化
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
class Person3 implements Serializable
{
	private String name;
	
	//password是敏感数据,序列化的时候忽略
	private transient String password;
	
	private int age;
	
	private Gender gender;
	
	
	/* Contructor */
	public Person3()
	{
		System.out.println("Person3...无参构造函数");
	}
	public Person3(String name,String password,int age,Gender gender)
	{
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
		return "[name="+name+",password="+password+",age="+age+",gender="+gender+"]";
	}
	
	/**
	 * 注意: 这两个是private的,那么是其他类是怎么调用的呢？
	 * 		其实是用的反射	
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException
	{
		//defaultWriteObject()方法是调用默认的序列化机制
		oos.defaultWriteObject();
		oos.writeUTF(password);
	}
	private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException
	{
		//defaultReadObject()方法是调用默认的反序列化机制
		ois.defaultReadObject();
		this.password = ois.readUTF();
	}
	
	
}


