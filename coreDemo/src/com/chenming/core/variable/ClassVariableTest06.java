package com.chenming.core.variable;

/**
 * 测试static变量
 * @author Lenovo
 *
 */
public class ClassVariableTest06
{
	private static String name;
	
	private static Test2 test2;
	
	public static void main(String[] args)
	{
		
	}
	/**
	 * 这种情况下并不会有任何输入：
	 * 	原因：
	 * 		程序执行到static变量test2的时候,的确会去加载Test2这个类,但是此时并没有对Test2这个类初始化
	 * 	
	 *  有且只有四种情况必须立即对类进行初始化：
	 *  	1)遇到 new、getstatic、putstatic、invokestatic 这四条字节码指令时，如果类还没有进行过初始化，则需要先触发其初始化。生成这四条指令最常见的 Java 代码场景是：使用 new 关键字实例化对象时、读取或设置一个类的静态字段（static）时（被 static 修饰又被 final 修饰的，已在编译期把结果放入常量池的静态字段除外）、以及调用一个类的静态方法时。
	 *		2)使用 Java.lang.refect 包的方法对类进行反射调用时，如果类还没有进行过初始化，则需要先触发其初始化。
	 *		3)当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
	 *		4)当虚拟机启动时，用户需要指定一个要执行的主类，虚拟机会先执行该主类。
	 *
	 *	如果我们将上面的代码修改成：
	 *		private static Test2 test2 = new Test2();
	 *	那么就会对Test2这个类进行初始化,那么static代码块中的代码就会执行
	 */
}

class Test2
{
	private static Test test;
	static
	{
		System.out.println("Test2...test>static{}...");
		test = new Test();
	}
}

