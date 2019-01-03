package com.chenming.core.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo7_1
{
	public static void main(String[] args)
	{
		//Apple是Fruit的子类，所以Fruit对象能够引用Apple对象---->父类的引用引用子类的实例
		//所以下面的一段代码是能够成立的
		Fruit fruit = new Fruit();
		Apple apple = new Apple();
		fruit = apple;
		//那么List<Fruit>能否引用List<Apple>呢？
		//看下面一段代码：
		List<Fruit> flist = new ArrayList<Fruit>();
		List<Apple> alist = new ArrayList<Apple>();
//		flist = alist;  //编译器报错，也就是说List<Apple>并不是List<Fruit>的子类
		/*
		 * 可以发现这样的引用编译器直接报错，那么是什么原因呢？
		 * 解释：
		 * 		我们能说Apple类是Fruit类的子类，所以Fruit对象能够引用Apple对象，但是当我们将Fruit、Apple都放进集合中去了之后，
		 *      那么List<Fruit>、List<Apple>就相当于两个桶了，尽管他们里面装的东西有联系，但是这两个桶却没有联系。
		 *      所以List<Fruit>不能引用List<Apple>
		 *【注意：并不是说只有泛型集合是这样的，而是所有的泛型都是这样的,就像下面的一段代码也是不能引用的】
		 *	GenericClass<Animal> agc = new GenericClass<Animal>();
			GenericClass<Dog> dgc = new GenericClass<Dog>();
			agc = dgc;  //编译器报错
		 */
		//那么问题来了，一个泛型类想要引用另一个泛型类，该怎么做呢？
		//此时就要用到通配符“？”了。
		List<?> list = null;
		list = flist; //能够引用List<Fruit>对象，也就是说List<Fruit>是List<?>的子类
		list = alist; //能够引用List<Apple>对象，也就是说List<Apple>是List<?>的子类
		List<Student> slist = new ArrayList<Student>();
		list = slist; //能够引用List<Student>对象，也就是说List<Student>是List<?>的子类
		/*
		 * 使用了“？”通配符后，那么List<?>就是所有List<具体类>的父类。
		 * 
		 * */
	}
}


