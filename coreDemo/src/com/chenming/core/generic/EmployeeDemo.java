package com.chenming.core.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

/*
 创建5 个Employee类对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型来定义），
分别按以下两种方式对集合中的元素进行排序，并遍历输出：

1). 使Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。 
 * 
 */
public class EmployeeDemo
{
	public static void main(String[] args)
	{
		//第一种：使Employee实现Comparable接口，重写compareTo方法，按照name排序
		Set<Employee> set = new TreeSet<Employee>();
		Employee e1 = new Employee("zhangsan",20,new MyDate("1994","03","03"));
		Employee e2 = new Employee("lisi",20,new MyDate("1994","04","04"));
		Employee e3 = new Employee("wangwu",20,new MyDate("1994","05","05"));
		Employee e4 = new Employee("zhaoliu",20,new MyDate("1994","06","06"));
		Employee e5 = new Employee("qianqi",20,new MyDate("1994","07","07"));
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		//遍历set集合中的所有Employee对象
		Iterator<Employee> it = set.iterator();
		while(it.hasNext())
		{
			Employee employee = it.next();
			System.out.println(employee);
		}
		//注意：这里的name如果变成中文，那么就不能按照要排序。
		
		System.out.println("=================分割符=====================");
		
		//第二种：使用自定的比较类
		Set<Employee> set2 = new TreeSet<Employee>(new MyComparator());
		set2.add(e1);
		set2.add(e2);
		set2.add(e3);
		set2.add(e4);
		set2.add(e5);
		Iterator<Employee> it2 = set2.iterator();
		while(it2.hasNext())
		{
			Employee employee = it2.next();
			System.out.println(employee);
		}
	}
	
	
	
	//第二种自定义MyComparator比较类实现Comparator接口，自定义比较方法
	public static class MyComparator implements Comparator<Employee>
	{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
	}
}
