package com.chenming.core.loop;

/**
 * 测试break关键字：
 * 	1.break跳出最里层循环
 * 	2.可以指定跳出某一层循环
 * 
 * 这里测试最常用的跳出最里层循环
 * @author Lenovo
 *
 */
public class BreakTest01
{
	public static void main(String[] args)
	{
		
		for(int i=0;i<10;i++) 
		{
			if(i==5)
			{
				break;
			}
			System.out.println("i: "+i);
		}
		/**
		 * 输出结果：
		 * 	i: 0
		 *	i: 1
		 *	i: 2
		 *	i: 3
		 *	i: 4
		 */
		
		
		
	}
}
