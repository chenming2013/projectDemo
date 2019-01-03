package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class DuoTaiTest
{
	public static void main(String[] args)
	{
		BBS b = new BBS();
		b.info();   //2.A�е�iΪ��21       ����BBS��û����дinfo���������ø����info��������ʱ�����i��Ϊ�����i
		b.print();  //2��B�е�iΪ��41     ������д�˸����print����������print����ʱ�����ǵ���������д��print��������ʱ��iΪ�����i
		b.fun();    //B�е�iΪ��41
		System.out.println(b.i);
	}
}
class H
{
	public int i = 21; 
	public void print()
	{
		System.out.println("A�е�iΪ��" + i);
	}
	public void info()
	{
		System.out.println("2.A�е�iΪ��" + i);
	}
}
class BBS extends H
{
	public byte i = 41;
	public void fun()
	{
		System.out.println("B�е�iΪ��" + i);
	}
	public void print()
	{
		System.out.println("2��B�е�iΪ��" + i);
	}
}