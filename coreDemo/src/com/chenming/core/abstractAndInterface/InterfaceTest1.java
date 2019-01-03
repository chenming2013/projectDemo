package com.chenming.core.abstractAndInterface;

public class InterfaceTest1
{
	
	public static void main(String[] args)
	{
		DW dw = new DW();
		System.out.println(DW.name);
	}
}
interface DQ
{   //接口中的访问权限只有public
	String name = "chenming";  //全局常量
	//在接口中定义的属性都自动是public static final的，即相当于：public static final String = "chenming"; 这就是全局常量
	void print();  //抽象方法
	//在接口中定义的方法都是abstract的（没有普通方法），且是public的，即相当于：public abstract void print();
	void fun();
}
 abstract class FQ implements DQ  //注意：抽象类实现接口的话，可以重写interface中的全部或部分abstract方法，也可以不重写interface中的abstract方法。
{
//	public abstract void fun();
/*	public void print()
	{
		
	}
*/
}
class DW implements DQ  //普通类实现接口的话，必须要全部重写接口中的abstract方法
{
	public void print()
	{
		
	}
	public void fun()
	{
		
	}
}
class DE extends FQ    //若是一个普通类再继承一个实现了接口的抽象类的话，则抽象类中的全部抽象方法都要重写。注意：这里的全部抽象类包括从接口实现而来的。
{
	public void print()
	{
		
	}
	public void fun()
	{
		
	}
}
