package com.chenming.core.loop;

/**
 * 测试break关键字：
 * 	1.break跳出最里层循环
 * 	2.可以指定跳出某一层循环
 * 
 * 这里测试跳出指定循环
 * @author Lenovo
 *
 */
public class BreakTest02
{
	public static void main(String[] args)
	{
		outer:
		for(int i=1;i<=9;i++)
		{
			inner:
			for(int j=1;j<=i;j++)
			{
				if(i==6) 
				{
					//break inner;   //指定跳出inner标识的那一层循环
					break outer;   //指定跳出outer标识的那一层循环
				}
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}
}
