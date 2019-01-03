package com.chenming.core.variable;

/**
 * 测试变量(这里只测试基础类型变量)：
 * 	变量可以分为：
 * 		1.类变量(静态变量)
 * 		2.常量
 * 		3.实例变量(成员变量)
 * 		4.局部变量
 * 
 * 	这里测试类变量
 *		类变量是被所有的类对象所共享的
 */
public class ClassVariableTest02
{
	private static String name = "chenming";
	
	public static void main(String[] args)
	{
		/**
		 * 类变量是被所有的类对象所共享的
		 */
		ClassVariableTest02.name = "hello";
		System.out.println(ClassVariableTest02.name);  //输出：hello
		
		//test02_1这个对象对name类变量进行修改,其他的ClassVariableTest02对象获取到的值是修改后的
		ClassVariableTest02 test02_1 = new ClassVariableTest02();
		test02_1.name = "world";
		
		ClassVariableTest02 test02_2 = new ClassVariableTest02();
		System.out.println(test02_2.name);    //输出：world
		
	}
}
