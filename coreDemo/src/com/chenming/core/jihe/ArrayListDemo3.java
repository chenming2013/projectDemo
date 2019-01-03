package com.chenming.core.jihe;

import java.util.ArrayList;
import java.util.Iterator;

//因为集合没有使用泛型，那么也就是说可以添加所有类型，当添加了不同元素类型的时候，就要取出每一个元素查看它的类型。
class ArrayListDemo3
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		
		Animal an1 = new Animal();
		Animal an2 = new Animal();
		Animal an3 = new Animal();
		
		al.add(an1); //添加Animal类型的元素
		al.add(an2);
		al.add(an3);
		al.add("hello"); //添加String类型的元素
		al.add(10); //添加int型的元素
		al.add(10.2); //添加double型的元素

		System.out.println(al.size());
		Iterator it = al.iterator();
		
		while(it.hasNext())
		{
			Object obj = it.next();
			if(obj instanceof Animal)
			{
				Animal an = (Animal)obj;
				System.out.println(an);
			}
			else if(obj instanceof String)
			{
				String s = (String)obj;
				System.out.println(s);
			}
			else if(obj instanceof Integer)
			{
				Integer i = (Integer)obj;
				System.out.println(i);
			} 
			else
			{
				Double d = (Double)obj;
				System.out.println(d);
			}
		}
	}
}
