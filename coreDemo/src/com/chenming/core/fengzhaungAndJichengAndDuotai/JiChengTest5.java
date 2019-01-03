package com.chenming.core.fengzhaungAndJichengAndDuotai;
/*
 * ��������û���޲ι��췽��ʱ��û���޲ι��췽������ض��д������Ĺ��췽������
 * ��ô�ͱ���ʹ��super(����)��ȷ���ø�����вι��췽������super������Ҳ�Ǵ��в����ġ�
 */
public class JiChengTest5
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		N n = new N();  //������  ������
		                //         N��Ĺ��췽��
	}
}
class M
{
	public M(String s)
	{
		System.out.println(s);
	}
	
}
class N extends M
{
	public N()
	{
		super("����");  //��Ϊ����û���޲ι��췽�������������super������ʾ��������super�Ǵ��в����ġ����Ƿ������С�
		System.out.println("N��Ĺ��췽��");
	}
}