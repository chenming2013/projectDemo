package com.chenming.core.jihe;

import java.util.ArrayList;

//既然是集合，那么就要提供遍历的方式

public class ArrayListDemo4
{
	public static void main(String[] args)
	{
		//使用泛型，限定了添加对象的类型
		ArrayList<Student> al = new ArrayList<Student>();
		Student stu1 = new Student("小红","001");
		Student stu2 = new Student("小明","002");
		Student stu3 = new Student("小张","003");
		Student stu4 = new Student("小刘","004");
		Student stu5 = new Student("小胡","005");
		Student stux = new Student("小红","001");
		
		al.add(stu1);
		al.add(stu2);
		al.add(stu3);
		al.add(stu4);
		al.add(stu5);
		
		System.out.println(al);
		//判断ArrayList集合中是否包含stux元素
		System.out.println(al.contains(stux));
		/*
		 * 在Student类没有重写equals()方法之前,调用al.contains(stux)返回的是false(因为equals方法默认比较是的地址,String类是重写了equals方法,才会是比较内容)
		 * 当我们重写了equals()方法之后,调用al.contains(stux)返回的就是true
		 */
		
		/*
		 *从结果分析可知，因为stux元素没有添加到集合中，所以集合认为不包含stux
		 *现实世界中，我们认为stu1和stux的name、id都一样，那么我们就可以认为stu1与stux是同一个对象。
		 *但是这和运行的结果又有出入，那么如何解决呢？我们可以看一看源代码： 
		 *在源代码中contains()方法调用了indexOf()方法，而indexOf()方法又使用了equals()来实现，所以contains()方法最后还是要使用equals()方法，
		 *而对象调用equals()方法默认比较的是地址。
		 *因此这里我们需要重写equals()方法，重新定义对象的比较方式。（不再是比较地址）
		 */
		
		
		 
		
	}
}
