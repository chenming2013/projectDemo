package com.chenming.core.variable;

/**
 * 测试 类变量 的使用 
 * 	static变量：static的初始化只有在必要的时候才会进行,即类初始化的时候
 * 		遇到 new、getstatic、putstatic、invokestatic 这四条字节码指令时，如果类还没有进行过初始化，则需要先触发其初始化。生成这四条指令最常见的 Java 代码场景是：使用 new 关键字实例化对象时、读取或设置一个类的静态字段（static）时（被 static 修饰又被 final 修饰的，已在编译期把结果放入常量池的静态字段除外）、以及调用一个类的静态方法时。
 *		使用 Java.lang.refect 包的方法对类进行反射调用时，如果类还没有进行过初始化，则需要先触发其初始化。
 *		当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
 *		当虚拟机启动时，用户需要指定一个要执行的主类，虚拟机会先执行该主类。
 * @author Lenovo
 *
 */

class Cup{  
    Cup(int marker){  
        System.out.println("Cup("+marker+")");  
    }  
    void f(int marker){  
        System.out.println("f("+marker+")");  
    }  
}  
class Cups{  
    static Cup c1;  
    static Cup c2;  
    static{  
        c1 = new Cup(1);  
        c2 = new Cup(2);  
    }  
    Cups(){  
        System.out.println("Cups()");  
    }  
}  

public class ClassVariableTest04
{
/**	
 * 情况一:
	public static void main(String[] args){
	}
	static Cups x;
	static Cups y;
	
	
 	1.输出结果：
 		无
	2.解释：
		(1)程序运行,加载ClassVariableTest04类,x,y两个静态变量随之加载,并且为它们默认初始化为null,
			但是因为并没有使用x、y这两个静态变量,所以不会为它们显式初始化,所以就是什么都不输出
*/

/**
 * 情况二：
	public static void main(String[] args){}
	static Cups x;
	static Cups y = new Cups();
	
	
	1.输出结果：
		Cup(1)
		Cup(2)
		Cups()
	2.解释：
		(1)程序运行,加载ClassVariableTest04类,x,y两个静态变量随之加载,先加载x,并为它默认初始化为null,什么都不执行
			加载到y的时候,先为它默认初始化为null,紧接着立刻显式初始化为 new Cups(),在创建对象之前会初始化Cups中c1、c2静态变量,
			结果就是Cup(1)、Cup(2),然后才调用Cups()构造方法,输出Cups();
*/
	
/**	
 * 情况三：
	public static void main(String[] args){}
	static Cups x = new Cups();
	static Cups y = new Cups();
	
	1.输出结果：
		Cup(1)
		Cup(2)
		Cups()
		Cups()
	2.解释：
		(1)与 情况二 很相似,执行 static Cups x = new Cups();的时候就已经输出了 Cup(1)、Cup(2)、Cups(),
			然后因为静态变量只初始化一次,所以执行 static Cups y = new Cups()的时候,并不会为c1、c2两个静态变量初始化,
			而是调用Cups()构造方法,输出Cups()
*/

/**
 * 情况四：
	public static void main(String[] args){
		Cup c = Cups.c1;
	}
	
	1.输出结果:
		Cup(1)
		Cup(2)
	2.解释：
		(1)这种情况也是因为使用了静态变量,所以静态变量才去初始化,
*/

/**
 * 情况五：
	public static void main(String[] args){
		Cup c = Cups.c1;
	}
	static Cups x;
	
	1.输出结果：
		Cup(1)
		Cup(2)
	2.解释：
		(1)x静态变量没有使用,所以不会输出;c1静态变量被使用了,所以会输出
*/

/**
 * 情况六
	public static void main(String[] args){
		Cup c = Cups.c1;
	}
	static Cups x = new Cups();
	
	1.输出结果；
		Cup(1)
		Cup(2)
		Cups()
	2.解释：
		(1)执行 static Cups x = new Cups();的时候,就已经输出了Cups(1)、Cups(2)、Cups()
*/
}
