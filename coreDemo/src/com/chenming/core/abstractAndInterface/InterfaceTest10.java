package com.chenming.core.abstractAndInterface;

public class InterfaceTest10
{
	public static void main(String[] args)
	{
		
	}
}
interface CanFly
{
	public abstract void fly();
	
	public abstract void show();
}
interface CanSing
{
	public abstract void sing();
	
	public abstract void show();
}
abstract class Parent
{
	public abstract void fly();
}
class Son extends Parent implements CanFly,CanSing
{

	@Override
	public void sing()
	{
		// TODO Auto-generated method stub
		System.out.println("Son...sing()...");
	}

	@Override
	public void fly()
	{
		// TODO Auto-generated method stub
		System.out.println("Son...fly()...");
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		System.out.println("Son...show()...");
	}
	
}