package com.chenming.core.jihe;

import java.util.Comparator;
import java.util.TreeSet;

//
public class TreeSetDemo3
{
	public static void main(String[] args)
	{
		TreeSet<UserA> ts = new TreeSet<UserA>(new UserAComparator()); 
		
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
	
	//自己定义比较规则，创建一个MyComparator类来实现Comparator接口，因为这是一个内部类，最好还是定义成static
	static class UserAComparator implements Comparator<UserA>
	{
		//重写Comparator接口中的compare()方法		
		@Override
		public int compare(UserA o1, UserA o2)
		{
			// TODO Auto-generated method stub
			return o1.getUName().compareTo(o2.getUName());
		}	
	}
	
}
