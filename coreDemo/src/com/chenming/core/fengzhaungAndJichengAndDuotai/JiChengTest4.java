package com.chenming.core.fengzhaungAndJichengAndDuotai;
/*
 * �����������֮ǰһ����Ĭ�ϵ��ø���Ĺ��죨Ĭ��ʹ���޲ι��죩���Ա�֤���������ʵ����������ʵ���������������û�и�����������ִ�����̳��أ���
*/
public class JiChengTest4
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		BBB bbb = new BBB();  //������  �� AAA��Ĺ��췽��
		                      //          BBB��Ĺ��췽��
	}                         //˵����ʵ����BBB�����֮ǰ���Ѿ���ʵ������AAA��Ķ���
}
class AAA
{
	public AAA()
	{
		System.out.println("AAA��Ĺ��췽��");
	}
}
class BBB extends AAA
{
	public BBB()
	{   //super();   ��������һ��Ĭ�ϵ�super�����޲ι��췽����
		System.out.println("BBB��Ĺ��췽��");
	}
}