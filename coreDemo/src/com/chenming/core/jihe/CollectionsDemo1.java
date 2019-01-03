package com.chenming.core.jihe;

import java.util.ArrayList;
import java.util.Collections;

//Collections类是对集合（List、Set、Map）的操作. 类似于Arrays
public class CollectionsDemo1
{
	public static void main(String[] args)
	{
		//Collections是对集合的操作，因此首先要操作集合
		//定义一个ArrayList集合
		ArrayList<String> al = new ArrayList<String>();
		//向集合中添加元素   ArrayList集合可以添加重复元素（包括null）
		al.add("小红");
		al.add("小明");
		al.add("小刚");
		al.add("小王");
		al.add("小红");
		al.add("小张");
		al.add("小刘");
		//操作前
		System.out.println("操作前：");
		for(int i=0;i<al.size();i++)
		{
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		System.out.println("=================分割符===================");
		//交换顺序
		System.out.println("交换顺序后：");
		Collections.swap(al,1,2); //将al集合中下标为1的元素与下标为2的元素交换位置
		for(int i=0;i<al.size();i++)
		{
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
		System.out.println("=================分割符===================");
		//自然排序
		System.out.println("自然排序后：");
		Collections.sort(al);
		for(int i=0;i<al.size();i++)
		{
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
		System.out.println("=================分割符===================");
		//二分查找    注意：二分查找必须是在先排好序后
		System.out.println("二分查找后：");
		System.out.println(Collections.binarySearch(al, "小明"));
		System.out.println();
		System.out.println("=================分割符===================");
		//将集合中的元素重新打乱
		System.out.println("重新打乱后：");
		Collections.shuffle(al);
		for(int i=0;i<al.size();i++)
		{
			System.out.print(al.get(i) + " ");
		}
		
	}
}
