package com.chenming.core.exception;

import java.util.Scanner;

public class ExceptionTest4
{
	public static void main(String[] args)
	{
		System.out.println("除法计算开始");
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入被除数和除数：");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		try
		{	
			System.out.println("执行出现异常之前的语句"); //这一句执行了
			System.out.println("除法计算：" + (num1/num2));      //异常语句
			System.out.println("执行出现异常之后的语句"); //这一句没有执行
		}
		catch(Exception e)  //因为不知道具体出现的异常类型，所以用Exception这个根类来接收异常
		{
			System.out.println("*****出现了异常*****");
		}
		System.out.println("除法计算结束");
	}
	//打印结果：
//	除法计算开始
//	出现异常之前的语句执行吗？
//	*****出现了异常*****
//	除法计算结束
	
	/*
	 *通过上面的程序可以知道：
	 *使用异常处理机制之后，try语句块中的异常语句之前的语句能够正常执行，但是异常语句之后的语句（try语句块中的）却是不能执行。
	 *而这条异常语句会找到catch，而后在catch里处理异常。
	 * 
	 */
}
