package com.chenming.core.variable;

/**
 * 测试static变量初始化顺序
 * @author Lenovo
 *
 */
public class ClassVariableTest05
{
	private static int i;
	static
	{
		System.out.println("i: "+i);
		i = 20171224;
		System.out.println("ClassVariable...i>static{}...");
		//System.out.println("age: "+age);  //Cannot reference a field before it is defined
	}
	
	private static Test test = new Test();
	
	private static int age;
	static 
	{
		age = 22;
		System.out.println("ClassVariableTest05...age>statci{}...");
	}
	
	public static void main(String[] args)
	{
		
	}
	/**
	 * 通过debug可以看出static变量的初始化顺序
	 * 	1.当类加载的时候,就开始顺序的加载static变量:
	 * 		1)先加载static变量i:
	 * 			①当我们没有显式的为i变量初始化的时候,JVM会为i变量默认初始化为0;
	 * 			②当我们有显式的为变量i初始化的时候,JVM会先为i变量默认初始化为0,然后立刻为变量i显式初始化。
	 * 		2)static变量i加载并且初始化完了,继续向下执行加载static代码块,执行static代码块中的代码
	 * 		3)继续向下执行,加载static变量test,先为test引用变量默认初始化为null,然后立刻显式初始化为Test对象,
	 * 		    此时去执行Test类的Test()构造函数,创建一个Test实例对象
	 * 		4)继续向下执行,加载static变量age,默认初始化为0
	 * 		5)继续向下执行,指向static代码块中的内容
	 * 
	 */
	
}
