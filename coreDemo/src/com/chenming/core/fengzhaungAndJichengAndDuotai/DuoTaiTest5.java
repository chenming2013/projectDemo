package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class DuoTaiTest5
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		BS bs = new BS();
		//ִ��˳��
		//1.����BS����󣬵��ù��췽��--->����Ĺ��췽����Ĭ�����ȵ��ø�����޲ι��췽����
		//2.this--->һ���Ǿ�̬��Ա�������ʷǾ�̬��Ա��ǰ��ʡ����this�ؼ��֡��������fun�����Ѿ������ˣ�
		//  this���ǵ�ǰ����AS��ʵ�������ã�--->��������������Ǹ�����BS����
		//  ��������AS��ʵ������������BS�Ķ��󣬼���������������������ʵ����
		//3.AS���췽�������fun������fun����������д�����Ե�������ķ�����
		
		
	}
}
class AS
{
	public AS()
	{
		System.out.println("aa...");
		this.fun();
		System.out.println(this);   //jicheng_jiekou_duotai.BS@152b6651
		System.out.println("bb...");
	}
	public void fun()
	{
		System.out.println("cc...");
	}
}
class BS extends AS
{
	public BS()
	{
		//super();
		System.out.println("dd...");
	}
	public void fun()
	{
		System.out.println("ee...");
	}
}
