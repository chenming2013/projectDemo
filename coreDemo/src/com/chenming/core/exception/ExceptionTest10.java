package com.chenming.core.exception;

import java.io.IOException;

public class ExceptionTest10
{
	public static void main(String[] args)
	{
		
	}
}
class A
{   //IOException、ClassNotFoundException都是非RunTimeException
	public void test1() throws IOException,ClassNotFoundException
	{
		
	}
}
class B extends A
{
	//子类重写父类的方法，不能抛出比父类更大的异常，除非是RunTimeException
	//也就是说子类可以不抛出异常，也可以抛出比父类少的异常，也可以抛出与父类一样的异常，甚至可以抛出比父类更多的异常(只不过这种异常是RunTimeException)，能够被IVM自动处理
	public void test1() throws IOException, ClassNotFoundException,ClassCastException   //这里的ClassCastException是RunTimeException,所以可以抛出
	{
		super.test1();
	}
}
