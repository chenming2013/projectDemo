package com.chenming.core.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest6
{
	public static void main(String[] args)
	{
		System.out.println("除法计算开始");
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入被除数和除数：");
		
		try
		{	
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			System.out.println("执行出现异常之前的语句"); //这一句执行了
			System.out.println("除法计算：" + (num1/num2));      //异常语句
			System.out.println("执行出现异常之后的语句"); //这一句没有执行
		}
		//当try语句中监测到出现异常，会由try语句来捕获产生的异常类实例对象，而后与try语句
		//后的每一个catch语句进行比较，如果现在有符合的捕获类型，则使用当前catch的语句来进行异常
		//的处理。如果不匹配，则向下继续匹配其它的catch。
		catch(ArithmeticException e)  
		{
			System.out.println("*****出现了算术异常*****");
		}
		catch(InputMismatchException e)
		{
			System.out.println("*****出现了输入不匹配异常*****");
		}
		//Exception异常是多有异常的父类，能够捕捉所有的异常类型，就相当于父类的引用引用子类的对象。
		//如果不知道try语句中究竟会出现什么异常，那么就可以使用Exception接收所有的异常。
		//注意：Exception异常只能在所有异常的最后，因为Exception异常能够捕捉所有的异常，如果放在前面的话，那么那些具体的异常ArithmeticException、InputMismatchException就没有作用。
		catch(Exception e)
		{
			System.out.println("*****捕获所有的异常*****");
		}
		//不管有没有捕捉到异常，finally语句块中的语句都要执行（当然这里因为有EXception异常类，所以能够捕捉所有的异常，那么程序肯定能够执行）
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
