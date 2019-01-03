package com.chenming.core.innerClass;

//如何避免修改接口而实现同一个类中两个同名方法的调用。
public class InnerClassTest4
{
	public static void main(String[] args)
	{
		Son son = new Son();
		son.show(); 
		son.showInnerC();
	}
}

abstract class Parent
{
	public abstract void show();
//	public void print(){}  //抽象类中可以有抽象方法，也可以有普通方法
}
interface Action
{
	public void show();  //接口中只能有抽象方法
}

/*
class Son extends implements Action
{
	//抽象类与接口中的抽象方法具有相同的方法名，那么在Son类中应该重写谁的抽象方法呢？如果要将两个抽象方法都重写，那怎么办呢？
	//此时这样的实现方式就不行了
}
*/
//使用下面的形式能够实现重写抽象类与接口中的相同方法
class Son extends Parent
{   //重写抽象类中的抽象方法
	public void show()
	{
		System.out.println("抽象类中的show()方法");
	}
	//定义内部类实现接口
	private class InnerC implements Action
	{
		public void show()
		{
			System.out.println("接口中的show()方法");
		}
	}
	public void showInnerC()
	{
		new InnerC().show();
	}
}