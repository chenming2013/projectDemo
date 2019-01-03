package com.chenming.core.fengzhaungAndJichengAndDuotai;
public class JiChengTest6
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		QQ qq = new QQ();
	}
}
class PP
{
	PP()   //���췽��
	{
		System.out.println("aa.....");
	}
	
	static   //��̬�����ʼ����
	{
		System.out.println("bb.....");
	}
	
	{  //�����ʼ����
		System.out.println("cc.....");
	}
}
class QQ extends PP
{
	QQ()  //���췽��
	{
		System.out.println("dd.....");
	}
	
	static 
	{
		System.out.println("ee.....");
	}
	
	{
		System.out.println("ff.....");
	}
}