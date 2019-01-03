package com.chenming.core.io;

//测试装饰模式
public class IODemo8
{
	public static void main(String[] args)
	{
		ConcreteComponent conComponent = new ConcreteComponent();
		conComponent.doThingA();
		System.out.println();
		ConcreteDecorator1 conDecorator1 = new ConcreteDecorator1(conComponent);
		conDecorator1.doThingA();
		System.out.println();
		ConcreteDecorator2 conDecorator2 = new ConcreteDecorator2(conDecorator1);
		conDecorator2.doThingA();
	}
}

//创建抽象构件角色
//这个接口就相当于InputStream这个类
interface Component
{
	public void doThingA();
}
//创建具体构件角色    类似于FileInputStream
class ConcreteComponent implements Component
{

	@Override
	public void doThingA()
	{
		// TODO Auto-generated method stub
		System.out.println("do A thing");
	}
}
//创建装饰角色   相当于FilterInputStream
class Decorator implements Component
{
	private Component component = null;
	
	public Decorator(Component component)
	{
		this.component = component;
	}
	@Override
	public void doThingA()
	{
		// TODO Auto-generated method stub
		component.doThingA();  //调用被装饰对象的方法
	}
}
//创建具体装饰角色    相当于BufferedInputStream
class ConcreteDecorator1 extends Decorator
{

	public ConcreteDecorator1(Component component)
	{
		super(component);
		// TODO Auto-generated constructor stub
		
	}
	public void doThingA()
	{
		super.doThingA();  //调用被包装类的方法
		doThingB();
	}
	//扩展的功能
	private void doThingB()
	{
		System.out.println("do B thing");
	}
}
//创建具体装饰角色    相当于DataInputStream
class ConcreteDecorator2 extends Decorator
{

	public ConcreteDecorator2(Component component)
	{
		super(component);
		// TODO Auto-generated constructor stub
		
	}
	public void doThingA()
	{
		super.doThingA();  //调用被包装类的方法
		doThingC();
	}
	//扩展的功能
	private void doThingC()
	{
		System.out.println("do C thing");
	}
}
