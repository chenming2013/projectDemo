package com.chenming.core.fengzhaungAndJichengAndDuotai;

public class ChongXieTest3 
{
	public static void main(String[] args) 
	{
		AAZ a = new BBZ();
		System.out.println(a.fun());

		CCZ c = new DDZ();
		c.print();
	}
}
class AAZ
{
	AAZ()
	{
		System.out.println("AZ�Ĺ��췽��");
	}
	 int fun()
	{
		return 1;
	}
}
class BBZ extends AAZ
{
	BBZ()
	{
		//super();
		System.out.println("BZ�Ĺ��췽��");
	}
	int fun()
	{
		return 2;
	}
}

class CCZ
{
	public AAZ print()
	{
		return new AAZ();
	}
}
class DDZ extends CCZ
{
	public AAZ print()   //��д �� ����ֵֻ����AAZ���ͻ�����AAZ���͵�����
	{
		return new AAZ();
	}
}