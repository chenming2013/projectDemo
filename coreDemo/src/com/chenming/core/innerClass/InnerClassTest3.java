package com.chenming.core.innerClass;
 
//使用内部类间接实现多继承（这种方法就像是子女继承父亲与母亲的基因一样的）
public class InnerClassTest3
{
	public static void main(String[] args)
	{
		C c = new C();
		//怎么才能调用A中showA方法，B中的showB方法？
		//第一种方法：
		c.new D().showA();
		c.new E().showB();
		//第二种方法，实质上与第一种方法一样，只不过形式上简单一点
		c.getInstanceD().showA();
		c.getInstanceE().showB();
		//第三种方法，实质上与第一种、第二种方法一样，只是更简单了
		c.showA();
		c.showB();
	}
}

class A
{
	public void showA()
	{
		System.out.println("A...");
	}
}
class B
{
	public void showB()
	{
		System.out.println("B...");
	}
}

class C
{   //用这种内部类的方式就间接实现了多继承
	class D extends A   //创建内部类继承A
	{
		public void showA()
		{
			super.showA(); //调用父类 A 的 showA() 方法 
		}
	}
	class E extends B  //创建内部类继承B
	{
		public void showB()
		{
			super.showB(); //调用父类 B 的 showB() 方法 
		}
	}
	
	public D getInstanceD()
	{
		return new D();
	}
	public E getInstanceE()
	{
		return new E();
	}
	
	
	public void showA()
	{
		new D().showA();
	}
	public void showB()
	{
		new E().showB();
	}
}
