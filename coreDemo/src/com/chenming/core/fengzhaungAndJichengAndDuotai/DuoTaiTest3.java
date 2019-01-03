package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class DuoTaiTest3
{
	public static void main(String[] args)
	{
		R r1 = new R();   
		//��Ϊû�з�������ת�ͣ����Ը��� R ����֪�����Լ�����Щ���࣬���� r1 instanceof R1 ����false
		System.out.println(r1 instanceof R);  //��ӡ�����true
		System.out.println(r1 instanceof R1);  //��ӡ�����false
		
		R r2 = new R1();
		//��Ϊ����������ת�ͣ��������ñ�����������ʵ�������Դ�ʱ���� R ��֪�������Լ���R1������࣬����r2 instanceof R1 ����true
		System.out.println(r2 instanceof R);  //��ӡ�����true
		System.out.println(r2 instanceof R1);  //��ӡ�����true
		if(r2 instanceof R1)  //���r2������R1���ʵ��
		{
			R1 a = (R1)r2;
			a.fun();
			a.print();
		}
	}
}
class R
{
	public void print()
	{
		System.out.println("aa...");
	}
}
class R1 extends R
{
	public void print()
	{
		System.out.println("bb...");
	}
	public void fun()
	{
		System.out.println("cc...");
	}
}
