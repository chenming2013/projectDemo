package com.chenming.core.abstractAndInterface;

public class AbstractTest3
{   
	public static void main(String[] args)  //static�����һ�������ⲿ����ڲ��ࡣ
	{   
		AL.AZ lz = new BZ();  //����ת��
		lz.print();
		lz.fun();
		
		
		AL al = new BL();
		al.show();
	}
}
abstract class AL
{
	static abstract class AZ
	{
		public abstract void print();
		public void fun()
		{
			System.out.println("aa...");
		}
	}
	public void show()
	{
		System.out.println("bb...");
	}
}
class BZ extends AL.AZ   //�̳е�ʱ��ʹ�á��ⲿ��.�ڲ��ࡱ����ʽ��ʾ������
{
	public void print()
	{
		System.out.println("cc...");
	}
}
class BL extends AL
{
	
}
