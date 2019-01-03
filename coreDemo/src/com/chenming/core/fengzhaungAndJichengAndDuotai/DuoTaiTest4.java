package com.chenming.core.fengzhaungAndJichengAndDuotai;
public class DuoTaiTest4
{
	public static void main(String[] args)
	{
		AM am = new PM();  //����ת�ͣ�����������������ʵ������
		am.print();
		
	}
}
class AM
{
	public void print()
	{
		System.out.println("aa...");
	}
}
class PM extends AM
{
	public void print()
	{
		System.out.println("bb...");
	}
}