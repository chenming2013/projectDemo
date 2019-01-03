package com.chenming.core.innerClass;
//测试静态内部类
public class InnerClassTest5
{
	public static void main(String[] args)
	{
		OuterD.InnerD innerd = new OuterD.InnerD();
		innerd.fun();
	}
}

class OuterD
{
	private String name = "陈明"; //外部类成员属性
	private int num1 = 10;  //外部类成员属性
	private int num2 = 20;
	private static String msg = "hello java!";
	public void print()  //外部类成员方法
	{
		System.out.println("aa...");
	}
	public static void show()
	{
		System.out.println(msg);
	}
	
	public static class InnerD 
	{
		private String name = "破晓";
		private int num1 = 20;
		private int num3 = 30;
		public void fun()
		{
		//	System.out.println(num2); //静态内部类不能访问外部类的非静态成员
		//	System.out.println(OuterD.this.num2);  //静态内部类不能访问外部类的非静态成员
		//	System.out.println(OuterD.i);
			System.out.println("bb...");
		//	print();
			show();   //内部类可以直接访问外部类成员，但是因为内部诶被定义成static，所以只能访问外部类中的static属性和方法。
		}
		
	}
}
