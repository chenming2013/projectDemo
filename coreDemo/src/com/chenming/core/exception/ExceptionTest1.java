package com.chenming.core.exception;

public class ExceptionTest1
{
	public static void main(String[] args)
	{
		String name = "zhangsan";
		System.out.println(name + "年龄是：");
		int age = Integer.parseInt("20P");
		System.out.println(age);
		System.out.println("产生了异常！");
		//运行结果如下：
//		zhangsan年龄是：
//		Exception in thread "main" java.lang.NumberFormatException: For input string: "20P"
//			at java.lang.NumberFormatException.forInputString(Unknown Source)
//			at java.lang.Integer.parseInt(Unknown Source)
//			at java.lang.Integer.parseInt(Unknown Source)
//			at exception.ExceptionTest1.main(ExceptionTest1.java:9)
		
		/*
		 *通过运行程序可以知道，程序由上向下执行，System.out.println(name + "年龄是：") 这一句代码能够正常执行，
		 *但是执行到Integer.parseInt()时发生异常，整个程序就中断了，所以后面的System.out.println（“产生了异常”）也就没有执行到。 
		 */
	}
}
