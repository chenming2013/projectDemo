package com.chenming.core.exception;

public class ExceptionTest2
{
	public static void main(String[] args)
	{
		String name = "zhangsan";
		System.out.println(name + "年龄是：");
		int age = 1;
		try
		{
			age = Integer.parseInt("20P");
		}
		catch(Exception e)  //Exception 是产生的异常类型，因为我在这里只知道会产生异常，但是不知道产生的具体异常，所以用Exception这个根类来接收所有的异常对象，就相当于父类的引用引用子类的实例。
		{                   //e: 是接收异常的对象，可以换一个名字，但是一般都是用 e 作为异常对象的名字
			System.out.println(age);
		}
		System.out.println("产生了异常！");
	}
	//打印结果：
//	zhangsan年龄是：
//	1
//	产生了异常！
	
	/*
	 *通过打印的结果可以知道：
	 *使用了异常处理机制try-catch异常之后，整个程序并不会中断 
	 */
}
