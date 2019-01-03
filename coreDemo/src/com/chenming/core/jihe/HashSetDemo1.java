package com.chenming.core.jihe;

import java.util.HashSet;

class HashSetDemo1 
{
	public static void main(String[] args) 
	{
		HashSet<String> hs = new HashSet<String>();

		hs.add(null);
		hs.add("hello");
		hs.add("hello");
		hs.add("world");
		hs.add("apple");
		
		System.out.println(hs);
		/* 打印结果：
		 * [null, apple, world, hello]
		 * 从打印结果可知，HashSet允许存放null，但是不允许存放重复元素，而且元素是无需存放的。
		*/
		//HashSet也有add()、remove()、 size()等方法。
	}
}
