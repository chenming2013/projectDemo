package com.chenming.core.abstractAndInterface;

public class InterfaceTest9
{
	public static void main(String[] args)
	{
		Fruit f1 = new Apple();  //interface对象不能实例化。 只能是父类的引用引用子类的实例。
		Fruit f2 = new Orange();
		f1.eat();
		f2.eat();
		//上面每新建一个实例对象都需要new一下，对于客户端而言是不合理的，因为 客户并不知道new是什么。因而就采取了工厂设计模式
		
		
		Fruit f3 = Factory.getInstance("Orange");
		f3.eat();
	}
}
interface Fruit
{
	public void eat();	
}
class Apple implements Fruit  //苹果实现Fruit接口
{
	public void eat()
	{
		System.out.println("吃苹果...");
	}
}
class Orange implements Fruit
{
	public void eat()
	{
		System.out.println("吃橘子...");
	}
}
//Factory类是新增加的
class Factory
{
	public static Fruit getInstance(String className)  //static定义是为了不用实例化出对象，能够类名直接调用
	{
		if("Apple".equals(className))
			return new Apple();
		else if("Orange".equals(className))
			return new Orange();
		else
			return null;
	}
}