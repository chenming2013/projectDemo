package com.chenming.core.exception;

public class ExceptionTest9
{
	public static void main(String[] args)
	{
		BarA bara = new BarA();
	/*	bara.enter(15);
		System.out.println("抛出异常时，这一句是否执行？");
		//根据输出结果可知，当抛出异常时，整个程序就中断，所以这一句没有执行
		//若想程序不中断，那么就要对程序进行捕获处理	
    */
		try
		{
			bara.enter(16);
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		System.out.println("当捕捉了异常，那么这一句还执行吗？");
		//根据输出结果可知，当程序进行了异常捕获，那么整个程序就不会中断，所以这一个打印语句能够执行
	
		System.out.println("======================================");
		
		BarB barb = new BarB();
		try
		{
			System.out.println("输入的年龄符合规定");
			barb.enter2(22);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("输入的年龄不符合规定");
			barb.enter2(17);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class BarA  //定义酒吧类
{
	public void enter(int age) throws IllegalArgumentException
	{
		if(age<18)
			throw new IllegalArgumentException("年龄小于18，不准进入酒吧！");
		else
			System.out.println("欢迎光临！");
	}
}
class BarB
{
/*	因为这里的Exception是非RunTimeException，所以如果在自己的方法中不进行捕获的话（当然在自己的方法中进行捕获就没有什么意义了），那么就必须要throws给调用者
 *  而这里的方法又没有throws给调用者，所以编译都无法通过。
    public void enter1(int age)
	{
		if(age<18)
			throw new Exception();
		else
		{
			System.out.println("欢迎光临！");
		}
	}
*/
	public void enter2(int age) throws AgeException //如果在方法体内抛出的不是一个运行时异常，那么就要在方法上声明该异常
	{
		if(age<18)
			throw new AgeException();
		else
		{
			System.out.println("欢迎光临！");
		}
	}
}

/**
 * 自定义一个AgeException
 * @author Lenovo
 *
 */
class AgeException extends Exception
{
	
}