package com.chenming.core.jihe;

import java.util.LinkedList;

//LinkedList是链表结构，基本方法与ArrayList差不多
public class LinkedListDemo1
{
	public static void main(String[] args)
	{
		LinkedList<String> ledl = new LinkedList<String>();
		
		ledl.add("hello");
		ledl.add("world");
		ledl.add("java");
		ledl.add("C");
		ledl.add("C++");
		
		System.out.println(ledl);
		
		
	}
}
