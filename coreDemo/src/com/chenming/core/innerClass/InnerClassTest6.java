package com.chenming.core.innerClass;

//测试匿名内部类
class InnerClassTest6
{
	public static void main(String[] args)
	{
		//匿名内部类的使用
		fun(new Message()  //new出来的是实现了Message接口的类
				{
					public void print()
					{
						System.out.println("hello world!");
					}
				});
		fun(new Message()  //new出来的是实现了Message接口的类
		{
			public void print()
			{
				System.out.println("hello java!");
			}
		});
		System.out.println();
	}
	public static void fun(Message msg)
	{
		msg.print();
		System.out.println("aa...");
	}
}

interface Message
{
	public void print();
}
/*
因为在java中每一个类都是单独作为一个文件存放，所以这个MessageImple类只使用一次，就会很浪费，这时候我们就会将其定义成匿名内部类的形式，进行代码的简化。
class MessageImple implements Message
{
	public void print()
	{
		System.out.println("hello world!");
	}
}
*/