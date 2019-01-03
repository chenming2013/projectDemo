package com.chenming.core.fengzhaungAndJichengAndDuotai;

/**
 * ������һ�����ʣ�Ϊʲô h.fun()�ᱨ��
 * 	�����Ϊ����ת��,�ᶪʧ�������еķ���,�������﷢������ת��֮��,�����fun()������ʧ��,��������ᱨ��
 * @author Lenovo
 *
 */
public class DuoTaiTest2
{
	public static void main(String[] args)
	{
		HH h = new I(); //����ת��
		h.print();   //��ӡ�����bb...
//		h.fun();   // ��Ϊ������û��fun�����������޷�����fun����
		System.out.println(h);
		
		I i = (I)h;   //����ת��
		i.fun();
		
//		I i = new I();
//		i.print();
//		i.fun();
	}
}
class HH
{
	public void print()
	{
		System.out.println("aa...");
	}
}
class I extends HH
{

	@Override
	public void print()
	{
		System.out.println("bb...");
	}
	
	public void fun()
	{
		System.out.println("cc...");
	}
}