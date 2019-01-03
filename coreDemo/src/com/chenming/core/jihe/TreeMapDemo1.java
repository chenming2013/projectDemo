package com.chenming.core.jihe;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo1
{
	public static void main(String[] args)
	{
		//定义的第一种比较规则，实现Comparable接口
		//因为之前写的User类已经实现了Comparable接口，所以这里就创建User类对象。
		TreeMap<User,Integer> tm = new TreeMap<User,Integer>();
		User u1 = new User("zhangsan","001");
		User u2 = new User("lisi","002");
		User u3 = new User("wangwu","003");
		
		tm.put(u1,1);
		tm.put(u2,2);
		tm.put(u3,3);
		tm.put(u3,4);  //key相同，后面的就会将前面相同key的元素覆盖。
		System.out.println(tm);  //打印输出对象就会打印输出key=value
		
		
		//定义的第二种比较规则，实现Comparator接口.这里就用UserA类对象
		TreeMap<UserA, Integer> tm1 = new TreeMap<UserA,Integer>(new Comparator<UserA>(){//new出来的是实现Comparator接口的对象

			@Override
			public int compare(UserA o1, UserA o2)
			{
				// TODO Auto-generated method stub
				return o1.getUName().compareTo(o2.getUName());
			} 
			
			
		});
		
		UserA usera1 = new UserA("zhangsan","110");
		UserA usera2 = new UserA("lisi","119");
		UserA usera3 = new UserA("wangwu","120");
		tm1.put(usera1,1);
		tm1.put(usera2,2);
		tm1.put(usera3,3);
		
		System.out.println(tm1);
	}
}
