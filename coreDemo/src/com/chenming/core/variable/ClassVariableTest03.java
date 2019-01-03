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
 * 		测试类变量的初始化
 *
 */
public class ClassVariableTest03
{
	static int i;
	
	//类成员是ClassVariableTest03实例
	private static ClassVariableTest03 bean = new ClassVariableTest03(5.0);
	
	//在定义一个类变量
	static double initPrice = 20;
	
	//定义实例变量
	double currentPrice = 160;
	
	public ClassVariableTest03(double discount) 
	{
		System.out.println(">>> initPrice="+initPrice+" <<<");
		System.out.println(">>> currentPrice="+currentPrice+" <<<");
		System.out.println("haha");
		currentPrice = initPrice - discount;
		System.out.println(this.toString());
	}
	
	public static void main(String[] args) 
	{
		System.out.println(ClassVariableTest03.initPrice);	//20.0
		System.out.println(ClassVariableTest03.bean.initPrice);   //输出:20.0
		System.out.println(ClassVariableTest03.bean.currentPrice);  //输出:-5.0,为什么会是-5.0?
		
		/**
		 * 这里为什么会输出 -5.0？
		 * 
		 * 	解析：
		 * 		注意：初始化有默认初始化和显式初始化之分
		 * 		过程：
		 * 		1.首先加载 ClassVariableTest03 类,随着 ClassVariableTest03 类的加载,类变量(静态变量)也随之加载,
		 * 		    类变量的加载顺序是从上往下的。
		 * 		2.ClassVariableTest03加载了,静态变量bean随后加载,并且在加载的时候就有一个默认初始化值null(注意:此时是还没有initPrice这个类变量),
		 * 		    继续执行,为bean变量显示初始化,赋值为一个ClassVariableTest03对象,此时这个对象只有一个实例变量currentPrice,
		 * 		    因为为bean变量显式赋值的时候,还没有加载到initPrice这个类变量,所以initPrice类变量只有一个默认初始化值0.0,
		 * 		    此时,currentPrice = initPrice(0.0)-discountPrice(5.0) = -5.0
		 * 		
		 * 
		 * 
		 */
	}
}
