package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class ChongXieTest
{
	public static void main(String[] args)
	{
		P t = new T();
		t.fun();
		System.out.println(t);
	}
}
class P
{
	public void fun()
	{
		System.out.println("P���е�fun��������");
	}
}
class T extends P
{
	public void fun()
	{
		System.out.println("T���е���дfun��������");
	}
}