package com.chenming.core.exception;

//重要的代码模型：异常的使用格式
//要求定义一个div()方法，要求，这个方法再进行计算之前打印提示信息，在计算结束完毕也打印提示信息，
//如果在计算之中产生了异常，则交给调用处处理。
public class ExceptionTest11
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println( Mymath.div1(10,0) );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
class Mymath
{
	public static int div1(int x,int y) throws Exception
	{
/*		
		int result = 0;
		System.out.println("*****除法计算开始*****");
		result = x / y;
		System.out.println("*****除法计算开始*****");
		
		当try中的语句调用div1（）方法时，执行到“result = x/y”出发生异常，那么try语句块中异常发生之后的语句都不会执行。
		所以这里只会输出：*****除法计算开始*****、以及异常信息
		但是这却与要求的输出   *****除法计算结束***** 不一致
		所以明显这种做法不符合要求，那么就要换一种方法了 
*/		  
		 
		int result = 0;
		System.out.println("*****除法计算开始*****");
		try
		{
			result = x/y;
		}
		catch(Exception e)
		{
			throw e; //【注意看这里】因为这里的异常是要交给调用处处理，所以这里捕获到的异常抛出给调用处
		}
		finally
		{
			System.out.println("*****除法计算开始*****");
		}
		return result;
	}
}