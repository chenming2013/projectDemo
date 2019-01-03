package com.chenming.core.jihe;

import java.util.HashMap;

public class HashMapDemo2 
{
	public static void main(String[] args) 
	{
		HashMap hm = new HashMap();

		Student stu1 = new Student("zhangsan","001");
		Student stu2 = new Student("lisi","002");
		Student stu3 = new Student("wangwu","003");
		//向HashMap集合中添加三个元素。
		//每一个key都对应一个唯一的value。
		//将stu.name（key） 与 字符串（value）绑定。得到一个key，就可以得到这个key的value。
		//这里是即将name作为唯一标识，下面的代码是将id作为唯一标识
		hm.put(stu1.getName(),"学习java");
		hm.put(stu2.getName(),"学习PHP");
		hm.put(stu3.getName(),"学习C++");
		System.out.println(hm);

		//再一次将stu1的元素添加
		hm.put(stu1.getName(),"学习Oracle");
		System.out.println(hm); //直接打印对象，就会打印出：key=value
		/*
		由打印结果可知，当向HashMap集合中添加的元素的key相同，那么就会覆盖之前的value。
		那么，key如何才算相同呢？----> 这就要重写equals()方法，看相同key的具体定义。
		*/
		
		HashMap hm1 = new HashMap();
		//将stu.id（key）与 stu这个对象绑定，每得到一个key，就可以得到一个stu对象的信息。
		//这里将id作为唯一标识。
		hm1.put(stu1.getId(),stu1);
		hm1.put(stu2.getId(),stu1);
		hm1.put(stu3.getId(),stu1);
		System.out.println(hm1);
	}
}

