package com.chenming.core.modifier;

/**
 * 测试private修饰符
 * 	1.范围: 在同一类中可见(注意:这里即便是子类也不可见)
 * 	2.使用对象: 变量、方法、内部类(注意不能是外部类)
 * @author Lenovo
 *
 */
public class PrivateTest02 extends Test2
{
	/*
	 * PrivateTest02继承了Test2类,同时也会继承Test2的 所有 的属性和方法,但是对于继承来的私有成员没有访问的权限
	 * 所以PrivateTest02类中有name、age和method1()这san个成员变量
	 * 	1).对于不是private修饰的age和method1():
	 * 		子类要想访问它们的话,此时还要考虑age和method1()的访问权限
	 * 	2).对于是private修饰的name成员变量
	 * 		子类无法直接访问
	 */
	
	
	public static void main(String[] args)
	{
		PrivateTest02 pt = new PrivateTest02();
		//对于非private修饰的成员变量,此时还要考虑访问权限
		//对于修饰符为default的age变量,因为Test2和PrivateTest02在同一个包中,所以也能够访问
		System.out.println("age: "+pt.age);   //age: 22
		//对于修饰符为public的成员,不论是否在同一个包中,都可以访问(注意：此时还要受限于Test2的访问权限)
		pt.method1();
		
		//对于private修饰的成员变量,子类继承了,但是无法访问,所以下面的语句会报错
		//System.out.println("name: "+pt.name);
	}
}
class Test2
{
	private String name = "chenming";
	
	int age = 22;
	
	public void method1()
	{
		System.out.println("Test2...method1()...");
	}
}
