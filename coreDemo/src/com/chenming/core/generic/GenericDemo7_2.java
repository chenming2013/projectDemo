package com.chenming.core.generic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//测试通配符“？”
public class GenericDemo7_2
{
	public static void main(String[] args)
	{
		List<String> list1 = new LinkedList<String>();
		list1.add("java");
		list1.add("hello");
		list1.add("world");
		list1.add("C");
		list1.add("C++");
		
		List<?> list2 = null;
		//list<?>是所有具体List<具体类>的父类，所以List<?>能够引用LinkedList<String>
		list2 = list1;
		//可以读取声明为通配符的类中的元素
		Iterator<?> it = list2.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());  //it.next()返回的类型是Object ,不能是“？”
		}
		
		//不能像声明为通配符的类中添加元素
//		list2.add("cm");
//		list2.add(10);
		
		
		
	}
}
