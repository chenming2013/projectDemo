package com.chenming.core.jihe;

import java.util.ArrayList;
import java.util.Iterator;

//既然有集合，那么就要提供遍历集合中元素的方法，这里介绍三种常用的方法。
//不使用泛型，那么集合中就能够存放各种类型的元素，那么在遍历的时候就要强制类型转换
class ArrayListDemo2
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();

		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		Student stu5 = new Student();

		al.add(stu1);
		al.add(stu2);
		al.add(stu3);
		al.add(stu4);
		al.add(stu5);

		System.out.println(al.size());
		System.out.println(al);
		
		System.out.println("=======================");

		//第一种使用for循环遍历
		System.out.println("第一遍历集合的方式: 使用for循环");
		for(int i =0;i<al.size();i++)
		{
			Student s = (Student)al.get(i);  //因为ArrayList集合没有使用泛型，所以里面默认存放的类型是Object类型，所以这里要取出Student类型的元素就要进行强制类型转换。
			System.out.print(s+"  ");
		}
		System.out.println();
		System.out.println("========================");

		//第二种使用foreach遍历
		System.out.println("第二种遍历集合的方式: 使用foreach");
		for(Object obj:al)
		{
			if(obj instanceof Student)
			{
				Student s = (Student)obj;
				System.out.print(s+"  ");
			}
		}
		System.out.println();
		System.out.println("========================");

		//第三种Iterator(迭代器)遍历      所谓迭代就是遍历，通俗来讲就是将集合中的元素一个个拿出来。
		System.out.println("第三种遍历集合的方式: 使用迭代器");
		Iterator it = al.iterator(); //集合调用Iterator()方法，返回一个Iterator对象。
		while(it.hasNext()) //判断是否有下一个元素，有的话就用next()取出来。
		{
			Student s = (Student)it.next();
			System.out.print(s+"  ");
		}
		/*
		通过观察上面三种遍历方式，可以知道若是没有使用泛型，那么集合中存放元素默认的类型是Object，那么在遍历的时候就要强制转换。
		因为这里存放的元素都是Student类的，如果有其他类型的，那么就会出现异常了，详情：ArrayListDemo3.java
		*/
	}
}

