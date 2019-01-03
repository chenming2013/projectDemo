package com.chenming.core.innerClass;
//测试局部内部类
public class InnerClassTest8
{
	public static void main(String[] args)
	{
		OuterG outerg = new OuterG();
		outerg.showOuter();
	}
}

class OuterG
{
	private String name = "张三";
	private int num1 = 10;
	private static int num2 = 20;
	public void showOuter()
	{
		final int num4 = 50;
		//定义一个局部内部类
	//	InnerG innerg = new InnerG();  //方法里面的代码是从上往下执行的，当执行到这条语句时，局部内部类变量都没有产生，又怎么能够创建类对象呢？
		class InnerG  //此局部内部类相当于方法中的局部变量，是不能用权限修饰符的
		{
			private int num3 = 30;
			private int num1 = 40;
			public void showInner()
			{
				System.out.println(num3);
				System.out.println(num1);  //先从局部内部类中找num1属性，没有是话就找外部类中的num1属性
				System.out.println(OuterG.this.num1);  //指定访问外部类成员属性num1
				System.out.println(name);  //先从局部内部类中找name属性，没有是话就找外部类中的name属性
				System.out.println(num4);  //在JDK1.8之前，在方法的局部内部类里面访问方法内的属性或者参数，则这些属性或者参数，必须被定义成final的
			}
		}
		InnerG innerg = new InnerG();  //此局部内部类的作用域就是方法体中，在其他的外部类中是不能创建对象的。
		innerg.showInner();
	}
}
