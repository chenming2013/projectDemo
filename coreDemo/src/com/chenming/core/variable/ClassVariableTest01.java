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
 *
 */
public class ClassVariableTest01
{
	/**
	 * 类变量:也叫静态变量,即被static关键字声明的变量
	 * 	1.随着类的加载而加载,随着类的销毁而销毁
	 * 	2.类变量是被所有的类的实例(对象)所共享的,即一个类不论创建了多少个对象,类只拥有类变量的一份拷贝
	 * 	3.类变量存储在静态存储区
	 * 	4.默认值和实例变量相似。数值型变量默认值是0，布尔型默认值是false，引用类型默认值是null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
	 */
	public static String name = "chenming";
	
	public static void main(String[] args)
	{
		
	}
}
