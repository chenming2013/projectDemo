package com.chenming.core.jihe;
//TreeSet是一种红黑树结构，也是树结构的一种，

import java.util.TreeSet;
//这是实现Comparable接口来定义比较规则
public class TreeSetDemo2
{
	public static void main(String[] args)
	{
		User u1 = new User("zhangsan","001");
		User u2 = new User("lisi","002");
		User u3 = new User("wangwu","003 ");
		
		TreeSet<User> ts = new TreeSet<User>();
		
		//这里我们向TreeSet中添加的是我们自定义的类的对象，那么我们就要对对象定义一种比较规则，就要实现Comparable接口。
		ts.add(u1);
		ts.add(u2);
		ts.add(u3);
		
		System.out.println(ts); //打印输出的结果就是按照字母升序排序的。
		
	}

}
