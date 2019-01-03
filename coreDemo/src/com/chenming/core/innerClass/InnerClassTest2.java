package com.chenming.core.innerClass;

public class InnerClassTest2
{
	public static void main(String[] args)
	{
		OuterB outerb = new OuterB();
//		OuterB.InnerB innerb = outer.new InnerB(); //因为成员内部类 InnerB 被定义成private，所以只能在OuterB中创建对象，在其他外围类中根本就不能创建内部类对象
		outerb.print();
		
		System.out.println("========================分割符====================");
		
	}
}

class OuterB
{
	private String msg = "java";
	private int age = 22;
	
	private InnerB innerb = new InnerB();
	
	public void print()
	{
		System.out.println(innerb.msg);
		innerb.fun();
	}
	
	//定义一个成员内部类,这个类的地位就等价于一个类的普通成员
	private class InnerB  //内部类如果被private修饰，那么这个内部类只能为该类的外部类使用，其他的所有类根本就不能访问这个内部类
	{
		private String msg = "Oracle";
		private int num = 10;
		public void fun()
		{
			System.out.println(msg);
			System.out.println(OuterB.this.msg);
		}
	}
}
