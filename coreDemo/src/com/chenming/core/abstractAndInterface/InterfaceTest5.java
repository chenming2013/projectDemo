package com.chenming.core.abstractAndInterface;



public class InterfaceTest5
{
	public static void main(String[] args)
	{
		Fly f1 = new Bird();   //从语法角度可以认为  父类的引用引用了子类的实例
		Fly f2 = new Plane();
		f1.fly();
		f2.fly();
		
		
		Person1 p1 = new Person1();
		p1.getOneFly().fly();
	}
}
interface Fly  //定义Fly这个接口，如果实现了Fly接口的类的对象就认为具有Fly的能力、功能
{
	public void fly();
}
class Bird implements Fly   //Bird类实现了Fly接口，就认为Bird对象具备Fly的能力。  若是没有使用关键字implements，直接写成class Brid就不能认为Bird类具有Fly的能力。
{
	public void fly()
	{
		System.out.println("bird is flying...");
	}
}
class Plane implements Fly  //Plane类实现了Fly接口，就认为Plane对象具备Fly的能力。  若是没有使用关键字implements，直接写成class Plane就不能认为Plane类具有Fly的能力。
{
	public void fly()
	{
		System.out.println("plane is flying...");
	}
}
class Person1
{
	public void toFly(Fly f) //该方法参数是一个接口，调用方法时用传递的是实现了该接口的类的对象
	{
		f.fly();
	}
	public Fly getOneFly()  //该方法的返回类型是接口，返回的是实现了该接口的类的对象。
	{
		return new Bird();
	}
}