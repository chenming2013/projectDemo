package com.chenming.core.jihe;

import java.util.HashMap;

//编程实现：计算一个字符串中每个字符出现的次数。
public class HashMapDemo3
{
	public static void main(String[] args)
	{
		//方法一：使用HashMap里key相同，后面添加的就会将前面的覆盖.
		/*
		 *思路：那个每个字符，作为key放入HashMap中，如果Map中不存在，那么put(key,1),如果已存在，那么put(key,value+1) 
		*/
		HashMap<String,Integer> hm = new HashMap<String,Integer>(); //key、value都是Object类型，所以value不能是int，而是int的包装类Integer
		//计算下面字符串中每个字符出现的次数。
		String str = "adhaduiabdqncwiofwnvcwjchsioan";
		
		for(int i=0;i<str.length();i++)
		{
			//将str整个字符串每一个字符都截取出来。
			String s = str.substring(i,i+1);
			if(hm.containsKey(s))
			{
				hm.put(s,hm.get(s)+1);
			}
			else
			{
				hm.put(s,1);
			}
		}
		System.out.println(hm);
		
		System.out.println("===========分割符=============");
		
		//第二种方法：
		//将字符串中的每一个字符都截取出来,放在数组中
		char[] charr = new char[str.length()];  //字符串：adhaduiabdqncwiofwnvcwjchsioan
		for(int i=0;i<str.length();i++)
		{
			charr[i] = str.charAt(i);
		}
		for(char ch='a';ch<'z';ch++)
		{
			int count=0;
			int i=0;
			for(i=0;i<charr.length;i++)
			{
				if(charr[i]==ch)
					count++;
				if(count>0 && i==charr.length-1)
					System.out.println(ch +"出现的次数为："+count);
			}
		}
	}
}
