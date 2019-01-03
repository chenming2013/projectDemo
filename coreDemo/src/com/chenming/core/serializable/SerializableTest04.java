package com.chenming.core.serializable;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 影响序列化的几种方式：
 * 	在现实应用中,有些时候不能使用默认序列化机制,比如：希望在序列化过程中忽略掉敏感数据,或者简化序列化过程。
 * 	有几种影响序列化的方法：(注意: 这里是影响序列化,并不是说是不让某变量持久化)
 * 		1、transient关键字: 
 * 			让某个成员变量的值不持久化
 * 		2、writeObject()方法与readObject()方法
 * 			让被transient声明的变量仍然能够持久化
 * 		3、Externalizable接口:
 * 			无论是使用transient关键字,还是使用writeObejct()和readObject()方法，其实都是基于Serializable接口的序列化;
 * 			使用Externalizable接口后,之前基于Serializable接口的序列化机制就将失效。
 * 			使用Externalizable接口,给予了我们很大的自由度,我们可以自由的存储与读取任意想要的字段
 * 		4、readResolve()方法
 * 	
 * 	本程序测试 实现Externalizable接口的java bean影响序列化
 * 		使用Externalizable进行序列化，当读取对象时，会调用被序列化类的无参构造器去创建一个新的对象，然后再将被保存对象的字段的值分别填充到新对象中	
 * 
 * @author Lenovo
 *
 */
public class SerializableTest04
{
	public static void main(String[] args)
	{

		/**
		 * 之前的SerializableTest01.java和SerializableTest02.java都是基于Serializable接口实现的序列化与反序列化
		 * 
		 * 但是如果是基于Externalizable接口,那么之前的序列化机制就将消失
		 * 
		 */
		//序列化
		ObjectOutputStream oos = null;
		OutputStream os = null;
		
		ObjectInputStream ois = null;
		InputStream is = null;
		
		try 
		{
			//将Person2对象序列化
			os = new FileOutputStream(new File("person4.out"));
			oos = new ObjectOutputStream(os);
			Person4 p = new Person4("chenming4","123456",23,Gender.MALE);
			oos.writeObject(p);
			
			
			//反序列化: 观察password的值有没有持久化
			is = new FileInputStream(new File("person4.out"));
			ois = new ObjectInputStream(is);
			Person4 p2 = (Person4)ois.readObject();
			System.out.println(p2);
			/**
			 * 输出结果:  Person3...无参构造函数
						[name=null,password=null,age=0,gender=null]
			 * 
			 * 从这个结果可以看出：
			 * 	1.反序列化的时候调用了无参的构造方法
			 * 	2.序列化的时候,Person4的任何一个字段都没有被持久化
			 * 
			 * 解释：
			 * 	1.Externalizable继承于Serializable，当使用该接口时，序列化的细节需要由程序员去完成。
			 *    如上所示的代码，由于writeExternal()与readExternal()方法未作任何处理，那么该序列化行为将不会保存/读取任何一个字段。
			 *    这也就是为什么输出结果中所有字段的值均为空。
			 *  2.若使用Externalizable进行序列化，当读取对象时，会调用被序列化类的无参构造器去创建一个新的对象，然后再将被保存对象的字段的值分别填充到新对象中。
			 *    这就是为什么在此次序列化过程中Person类的无参构造器会被调用。由于这个原因，实现Externalizable接口的类必须要提供一个无参的构造器，且它的访问权限为public。
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
class Person4 implements Externalizable
{
	private String name;
	
	//password是敏感数据,序列化的时候忽略
	private transient String password;
	
	private int age;
	
	private Gender gender;
	
	
	/* Contructor */
	public Person4()
	{
		System.out.println("Person3...无参构造函数");
	}
	public Person4(String name,String password,int age,Gender gender)
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
	
	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
	}
	
	
}



