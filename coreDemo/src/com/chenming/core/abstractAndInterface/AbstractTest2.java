package com.chenming.core.abstractAndInterface;

public class AbstractTest2
{
	public static void main(String[] args)
	{
		AK ak = new BK();
		ak.print(); //��ӡ�����bb...
		ak.fun();   //��ӡ�����aa...
	}
}
abstract class AK
{
	public abstract void print();
	public void fun()
	{
		System.out.println("aa...");
	}
}
class BK extends AK   //һ������ֻ�ܼ̳�һ�������࣬���ڵ��̳о���
{
	public void print()
	{
		System.out.println("bb...");
	}
}