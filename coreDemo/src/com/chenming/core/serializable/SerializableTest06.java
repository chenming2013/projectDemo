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
 *	测试序列化时,父类对象的情况 
 * @author Lenovo
 *
 */
public class SerializableTest06
{
	public static void main(String[] args)
	{
		
		//序列化
		ObjectOutputStream oos = null;
		OutputStream os = null;
		
		ObjectInputStream ois = null;
		InputStream is = null;
		
		try 
		{
			//将Person2对象序列化
			os = new FileOutputStream(new File("person6.out"));
			oos = new ObjectOutputStream(os);
			Person6 p = new Person6("chenming","123456",23,Gender.MALE,new Son("东庙小学"));
			oos.writeObject(p);
			
			
			//反序列化: 观察password的值有没有持久化
			is = new FileInputStream(new File("person6.out"));
			ois = new ObjectInputStream(is);
			Person6 p2 = (Person6)ois.readObject();
			System.out.println(p2);
			
			System.out.println("son's name: "+p2.getSon().getName());
			
			
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
class Person6 implements Serializable 
{
	private String name;
	
	private String password;
	
	private int age;
	
	private Gender gender;
	
	private Son son;

	
	public Person6()
	{
		System.out.println("Person6...无参构造函数");
	}
	public Person6(String name,String password,int age,Gender gender,Son son) 
	{
		System.out.println("Person...5个参数的构造函数");
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.son = son;
	}
	
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

	public Son getSon()
	{
		return son;
	}

	public void setSon(Son son)
	{
		this.son = son;
	}
	
	public String toString()
	{
		return "[name="+this.name+",password="+this.password+",age="+this.age+",gender="+this.gender+",son="+this.son+"]";
	}
}

class Parent implements Serializable 
{
	private String name;
	
	private double height;

	public Parent()
	{
		System.out.println("Parent...无参构造函数");
		this.name = "父类无参";
	}
	public Parent(String name,double height)
	{
		System.out.println("Parent...2个参数的构造函数");
		this.name = name;
		this.height = height;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
	
}
class Son extends Parent implements Serializable
{
	private String school;

	public Son()
	{
		System.out.println("Son...无参构函数");
	}
	public Son(String school)
	{
		System.out.println("SOn...1个参数的构造函数");
	}
	
	public String getSchool()
	{
		return school;
	}

	public void setSchool(String school)
	{
		this.school = school;
	}
	
	public String toString()
	{
		return "[school="+this.school+"]";
	}
}
