package com.chenming.core.exception;

import java.util.Scanner;

public class ExceptionTest5
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
//			return;     //见到return语句,方法就不再继续执行;但是finally中的语句还是要继续执行
		}
		catch(Exception e)  //因为不知道具体出现的异常类型，所以用Exception这个根类来接收异常
		{
			System.out.println("*****出现了异常*****");
		}
		finally
		{
			System.out.println("finally语句块中始终要执行！");
		}
		System.out.println("除法计算结束");
	}
	//下面是一次正常执行、一次异常的打印结果：
	//正常执行结果：
//	除法计算开始
//	请输入被除数和除数：
//	20
//	6
//	执行出现异常之前的语句
//	除法计算：3
//	执行出现异常之后的语句
//	finally语句块中始终要执行！
//	除法计算结束
	
    //异常结果：
//	除法计算开始
//	请输入被除数和除数：
//	20
//	0
//	执行出现异常之前的语句
//	*****出现了异常*****
//	finally语句块中始终要执行！
//	除法计算结束

	
	/*
	 *通过上面的程序可以知道：
	 *使用异常处理机制之后，try语句块中的异常语句之前的语句能够正常执行，但是异常语句之后的语句（try语句块中的）却是不能执行。
	 *而这条异常语句会找到catch，而后在catch里处理异常。
	 * 
	 *不管程序是否产生异常，finally语句块中的语句块都要执行。
	 */
}
