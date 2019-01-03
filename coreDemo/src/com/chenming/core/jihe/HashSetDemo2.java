package com.chenming.core.jihe;
//如果一个元素在删除之前，他的标识属性（hashcode算法有关）被修改了，那么就无法删除此元素。
import java.util.HashSet;

public class HashSetDemo2
{
	public static void main(String[] args)
	{
		HashSet<Student> hs = new HashSet<Student>();
		
		Student stu1 = new Student("张三","001");
		Student stu2 = new Student("李四","002");
		Student stu3 = new Student("王五","003");
		
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		//打印输出集合中的元素,输出顺序与hashcode()算法有关，并不是元素存放的顺序。
		System.out.println(hs);
		
		//此时没有改动元素的标识（name、id），那么就能够正常的删除集合中的一个元素
		hs.remove(stu1);
		System.out.println(hs);
		
		//如果改动了元素的唯一标识，那么就不能无法删除此元素。【这里的唯一标识是name】
		stu2.setName("李老大"); //只要修改元素的多个标识中的一个标识，那么就无法删除此元素，当然能够将元素的所有标识全部修改。
		System.out.println(hs);
		hs.remove(stu2);   //删除失败
		System.out.println(hs); //修改了元素标识之后，打印输出的就是修改后的元素。
	
		/* 总结：
		  HashSet存放元素的位置是和对象的hashcode算法得到的int值有关。那么去查找元素时，也要根据这个算法的值，然后找到相关的位置，移除元素。如果没有元素存在，remove()方法返回false。
		    如果跟算法相关的属性值在放入容器后被修改了，意味着hashcode算法得到的int值和之前放入容器时的不一样了， 那么此时查找的位置和元素的位置就不一样了，从而找不到之前的对象，导致元素不能移除，久而久之会产生内存泄露。
		 * 
		*/
	}
}
