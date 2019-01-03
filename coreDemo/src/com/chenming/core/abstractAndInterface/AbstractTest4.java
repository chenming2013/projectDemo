package com.chenming.core.abstractAndInterface;

public class AbstractTest4
{
	public static void main(String[] args)
	{
		
	}
}
abstract class AC
{
	class AV
	{
		public void print()
		{
			System.out.println("aa...");
		}
	}
}
class BC extends AC
{
	class AB extends AV
	{
		public void print()
		{
			System.out.println("bb...");
		}
	}
}
/*
 * ����ķ�ʽ�Ǵ���� 
 */
/*
class CC extends AC.AV
{
	public void print()
	{
		
	}
}
*/