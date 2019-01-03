package com.chenming.core.modifier;

/**
 * 这是测试private修饰符
 * 	1.范围: 在同一类中可见
 * 	2.使用对象: 变量、方法、内部类(注意不能是外部类)
 * @author Lenovo
 *
 */
public class PrivateTest01
{
	private String word = "private";
	
	public static void main(String[] args)
	{
		Test1 test1 = new Test1();
		//num被声明成default,在同一个包下的类都可以访问,所以这里编译运行都是正常
		System.out.println(test1.num);
		
		//private修饰的只能在本类中的访问,这里出了本类的范围,访问不到,所以编译报错
		//System.out.println(test1.name);
	}
}

class Test1
{
	private String name = "chenming";
	
	int num = 3;
}
