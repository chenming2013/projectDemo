package com.chenming.core.exception;
//测试自定义异常
public class ExceptionTest12
{
	public static void main(String[] args)
	{
		Bar bar = new Bar();
		try
		{
			bar.enter(16);
		}
		catch(AgeLessThanEighteenException e)
		{
			e.printStackTrace();
//			System.out.println("错误信息：" + e.getMessage());
		}
		System.out.println("end!");
	}
}

//创建一个自定义的异常类，必须继承一个已有的异常类，通常是Exception类
@SuppressWarnings("serial")
class AgeLessThanEighteenException extends Exception  //定义一个 "年龄小于18岁的异常"
{
	private String message;//描述异常信息
	public AgeLessThanEighteenException(String message)
	{
		this.message = message;
	}
	//重写父类中描述异常信息的方法getMessage（）
	public String getMessage()
	{
		return this.message;
	}
}

class Bar //自由满18岁才能进入酒吧
{
	public void enter(int age) throws AgeLessThanEighteenException 
	{
		if(age<18)
			throw new AgeLessThanEighteenException("年龄小于18岁，禁止进入酒吧！");
		else 
			System.out.println("欢迎光临！");
	}
}
