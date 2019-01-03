package com.chenming.core.jihe;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

//Vector类也是实现List接口，其底层也是数组，所以在性质上与ArrayList很像。
//Vector有四种常用的遍历方式，比ArrayList多了一种
//ArrayList是线程不安全的，vector是线程安全的。
public class VectorDemo1
{
	public static void main(String[] args)
	{
		Vector<String> vc = new Vector<String>();
		vc.add("hello");
		vc.add("world");
		vc.add("java");
		vc.add("C");
		vc.add("C++");
		
		//for循环遍历
		for(int i=0;i<vc.size();i++)
		{
			System.out.println(vc.get(i));
		}
		System.out.println("================分割====================");
		
		//foreach遍历
		for(String i:vc)
		{
			System.out.println(i);
		}
		System.out.println("================分割====================");
		
		//Iterator遍历
		Iterator<String> it = vc.iterator();//创建一个遍历器Iterator
		while(it.hasNext())
		{
			String str = it.next();
			System.out.println(str);
		}
		System.out.println("================分割====================");
		
		//这是老版本遗留的遍历方式
		Enumeration<String> e = vc.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
	}
}
