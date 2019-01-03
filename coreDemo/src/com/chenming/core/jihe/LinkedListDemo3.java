package com.chenming.core.jihe;

import java.util.Iterator;
import java.util.LinkedList;

//用LinkedList来实现栈和队列的功能。
public class LinkedListDemo3
{
	public static void main(String[] args)
	{
		//栈是先进后出的结构 ，向栈中添加数据称为压栈，从栈中取出数据称为出栈。
		//测试栈结构
		MyStack<String> mystack = new MyStack();
		
		mystack.push("zhangsan");
		mystack.push(null);
		mystack.push("lisi");
		mystack.push("wangwu");
		
		Iterator<String> it = mystack.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("=============分割符===========");
		
		mystack.pop();
		mystack.pop();
		Iterator<String> it2 = mystack.iterator();
		while(it2.hasNext())
		{
			String s = it2.next();
			System.out.println(s);
		}
		
		System.out.println("=============分割符=============");
		
		//队列是先进先出   
		//测试队列结构
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);

		Iterator<Integer> it3 = myQueue.iterator();
		while(it3.hasNext())
		{
			Integer in = it3.next();
			System.out.println(in);
		}
		System.out.println("===========分割符==========");
		
		myQueue.pop();
		myQueue.pop();
		Iterator<Integer> it4 = myQueue.iterator();
		while(it4.hasNext())
		{
			Integer in = it4.next();
			System.out.println(in);
		}
	}
}
//自定义栈
class MyStack<T>
{
	private LinkedList<T> data = null;
	public MyStack()
	{
		data = new LinkedList<T>();
	}
	//压栈的方法
	public void push(T obj)
	{
		data.addFirst(obj);
	}
	//出栈的方法
	public T pop()
	{
		return data.removeFirst();
	}
	public Iterator<T> iterator()
	{
		return data.iterator();
	}
}
//自定义队列
class MyQueue<T>
{
	private LinkedList<T> data = null;
	public MyQueue()
	{
		data = new LinkedList<T>();
	}
	public void push(T obj)
	{
		data.addFirst(obj);
	}
	public T pop()
	{
		return data.removeLast();
	}
	public Iterator<T> iterator()
	{
		return data.iterator();
	}
}