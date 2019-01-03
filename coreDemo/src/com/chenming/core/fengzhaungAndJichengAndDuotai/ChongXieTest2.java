package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class ChongXieTest2
{
	public static void main(String[] args)
	{
		DD dd = new DD();
		dd.fun();    //�������� Oracle  java
		dd.print();  //��������  PHP
	}
}
class CC
{
	public void fun()
	{
		System.out.println("Oracle");
		this.print();
		System.out.println(this);
	}
	private void print()     //ע�⣺������private,�����public,��ô����ǲ�һ����
	{
		System.out.println("java");
	}
}
class DD extends CC
{
	public void print()    //��������ͬ�ķ�����private��ʱ��,��������Ͳ�����д��,����DD���Լ�����ķ���,���ǲ��ſ���ʹ��@Overrideע�����
	{
		System.out.println("PHP");
	}
}