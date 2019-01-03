package com.chenming.core.fengzhaungAndJichengAndDuotai;
public class DuoTaiTest1
{
	public static void main(String[] args)
	{
		K1 k = new K1();
		k.print( new Object() );  //��ӡ�����aa...
		k.print( new Person() );  //��ӡ�����bb...
		                          //���˵����K1����������print���������������е�print�����������أ�ȴ������д��
	}
}
class K
{
	public void print(Object obj)
	{
		System.out.println("aa...");
	}
}
class K1 extends K
{
	public void print(Person p)  //�����print�����븸���print������������д�Ĺ�ϵ���������صĹ�ϵ
	{
		System.out.println("bb...");
	}

}