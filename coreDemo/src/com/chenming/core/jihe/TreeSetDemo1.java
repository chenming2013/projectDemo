package com.chenming.core.jihe;

import java.util.TreeSet;

//TreeSet是一种红黑树结构，会将元素有序存放，既然是有序的，那么就有一种排序规则。
public class TreeSetDemo1
{
	public static void main(String[] args)
	{
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("hello");
		ts.add("world");
	//	ts.add(null);  //TreeSet是一种红黑树，也是一种树结构，其集合中的每一个元素就相当于一个节点，树结构不允许节点为null，所以这里add(null)的话，运行就会出错。
		ts.add("java");
		ts.add("C");
		ts.add("C++");
		ts.add("world");  //TreeSet 不允许添加重复元素，所以这个添加不进去
		
		System.out.println(ts.size());
		System.out.println(ts);
		/*
		 *因为String类中 有自己的比较规则compareTo()方法，所以我们不用自己定义比较规则。而如果我们存入TreeSet中的元素是我们自定义的类的对象，那么我们就要人为 的定义一种比较规则，否则就会出错。
		 *String类中的compareTo()方法是按字母的升序进行排序的。
		 */
	}
}
