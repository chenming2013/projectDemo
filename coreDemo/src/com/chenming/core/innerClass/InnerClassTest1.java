package com.chenming.core.innerClass;

public class InnerClassTest1
{
	public static void main(String[] args)
	{
		//内部类属于外部类，要想创建内部类对象，必须先创建外部类对象
		//创建外部类对象
		
/*		//创建内部类对象的第一种方法
        OuterA.InnerA innera = new OuterA().new InnerA();
		innera.innerShow();
*/
		//创建内部类对象的第二种方法
		OuterA outera = new OuterA();
		OuterA.InnerA innera = outera.new InnerA();
		innera.innerShow();
		
		System.out.println("=========================");
		
		outera.show();
		
	}
}

class OuterA
{
	private String name = "张三";
	private int num1 = 10;
	private int num2 = 20;
	public void outerShow()
	{
		System.out.println(name);  //成员方法访问成员属性name
		System.out.println(num1);  //成员方法访问成员属性num1
	}
	public void print()  //外部类的成员方法
	{
		System.out.println("hello world!");
	}
	
	public void show()
	{
	//	System.out.println(num3);   //外部类不能直接访问内部类的属性
	//	innerFun();                 //外部类不能直接访问内部类的方法
		//外部内若要访问内部类中的属性和方法，应该用下面的两种方法
		//方法一：创建内部类对象，对象访问内部类中的属性和方法
		InnerA innera = new InnerA();
		System.out.println(innera.num3);
		innera.innerFun();
		//方法二：
		System.out.println(new InnerA().num3);
		new InnerA().innerFun();
	}
	
	//定义成员内部类  ，这个类的地位就等价于一个类的普通成员，其可以用public private、default、protected四种权限修饰符
	public class InnerA  //内部类如果被private修饰，那么这个内部类只能为外部类使用，其他的所有类根本就不能访问这个内部类
	{
	    private String name = "李四";  //成员内部类中的属性
		private int num1 = 30;
		private int num3 = 40;        //成员内部类中的属性
	//	private static int age = 22;  //语法错误：成员内部类中不能定义static属性和方法,除了全局变量,即static final修饰的变量
		private static final String msg = "陈明"; // 内部类中不能定义static成员，但是与final一起使用定义成常量就行了。
		
		public void innerShow()
		{
			System.out.println(name);  //访问内部类中的属性
			System.out.println(num1);  //访问内部类中的属性		
			innerFun();                //访问内部类中的方法
			//上面的是访问内部类中的属性，如果想访问外部类中的属性和方法，怎么办？也是像上面的代码一样吗？
			System.out.println(num2);  //打印的是外部类中的属性num2
			System.out.println(num3);  //打印的是内部类中的属性num3
			//通过上面的两个代码可以发现，如果内部类里面有与外部类同名的属性或行为，内部类会先找调用内部类里面的属性和方法。
			//如果内部类中没有与外部类同名的属性和行为，那么就会直接调用外部类的属性和行为。
			//那么如果我们想要指定调用外部类中的某些属性和行为，又怎么做呢？
			//此时可以采用 “外部类.this.成员” 的形式访问      【声明： this 表示本类对象的引用，在前面加上 OuterA 变成 OuterA.this 形式则是表明外部类对象的引用】
			System.out.println(OuterA.this.name);  //打印结果：张三
			System.out.println(OuterA.this.num1);  //打印结果：10
			OuterA.this.print();  //因为内部类中没有print方法，所以此处不写 OuterA.this 也是一样
			print();    //内部类也可以直接访问外部类中的成员。
			
			
		}
		public void innerFun()
		{
			System.out.println("hello java！");
		}
	}
}