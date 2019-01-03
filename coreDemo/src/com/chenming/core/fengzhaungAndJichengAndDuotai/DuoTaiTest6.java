package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class DuoTaiTest6
{
	public static void main(String[] args)
	{
		AP ap = new BP();
		ap.print();
	}
}
class AP
{
	public void print()
	{
		System.out.println("aa...");
		this.fun();
		System.out.println("bb...");
	}
	public void fun()
	{
		System.out.println("cc...");
	}
}
class BP extends AP
{
	public void fun()
	{
		System.out.println("dd...");
	}
}