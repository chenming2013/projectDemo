package com.chenming.core.innerClass;
//测试局部内部类
public class InnerClassTest9
{
	public static void main(String[] args)
	{
		Persony p = new Persony();
		p.getOneFly().fly();
	}
}

class Persony  
{   //虽然在Package jicheng_jiekou_duotai 中有Fly接口，但是因为没有定义成public，所以也不能访问。所以这里在定义了一个Fly接口。
	public Fly getOneFly()  //看到返回值类型是接口，返回的是实现了该接口的类的对象
	{
		class Bird implements Fly  //这个类声明在了一个方法的内部，这就是局部内部类，只在
		{
			public void fly()
			{
				System.out.println("bird is flying...");
			}
		}
		class Plane implements Fly
		{
			public void fly()
			{
				System.out.println("plane is flying...");
			}
		}
		return new Bird();
	}
}