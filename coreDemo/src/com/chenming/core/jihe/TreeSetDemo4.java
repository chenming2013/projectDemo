package com.chenming.core.jihe;

import java.util.Comparator;
import java.util.TreeSet;

//
public class TreeSetDemo4
{
	public static void main(String[] args)
	{
		TreeSet<UserA> ts = new TreeSet<UserA>(new Comparator<UserA>(){ //这是匿名内部类，new出来的是实现了Comparator接口的类

			@Override
			public int compare(UserA o1, UserA o2)
			{
				// TODO Auto-generated method stub
				return o1.getUName().compareTo(o2.getUName());
			}
			
		}); 
		
		UserA usera1 = new UserA("zhangsan","001");
		UserA usera2 = new UserA("lisi","002");
		UserA usera3 = new UserA("wangwu","003");
		UserA usera4 = new UserA("zhaoliu","004");
		UserA usera5 = new UserA("tianqi","005");
		
		ts.add(usera1);
		ts.add(usera2);
		ts.add(usera3);
		ts.add(usera4);
		ts.add(usera5);
		
		System.out.println(ts);
	}
}
