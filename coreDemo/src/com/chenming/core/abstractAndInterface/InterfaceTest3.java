package com.chenming.core.abstractAndInterface;

public class InterfaceTest3
{
	public static void main(String[] args)
	{
		
	}
}

interface DU
{
	public void print();
}
interface DI
{
	public void fun();
}
//接口可以继承多个接口
interface DO extends DU,DI   //接口DO继承接口DU，DI，故而接口DO中也继承了这两个接口里面的全部抽象方法
{
	public void show();
}
abstract class DP implements DO  
{
	public void print()
	{
		
	}
	@Override
	public void fun()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}
	
	public DP()
	{
		// TODO Auto-generated constructor stub
	}
}