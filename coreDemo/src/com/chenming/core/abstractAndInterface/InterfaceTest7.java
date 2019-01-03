package com.chenming.core.abstractAndInterface;

public class InterfaceTest7
{
	public static void main(String[] args)
	{
		DK dk = new DK();
		dk.a();
		DL dl = new DL();
		dl.d();
	}
}
interface DF  //接口DF中有很多的抽象方法
{
	public void a();
	public void b();
	public void c();
	public void d();
	public void e();
}
/*
class DG implements DF  //DG实现了DF接口，也就继承了DF的全部抽象方法，但是我们却只需要 a（）方法，那么其他的方法就是多余的了
{
	public void a()
	{
		System.out.println("aa...");
	}
	public void b(){}
	public void c(){}
	public void d(){}
	public void e(){}
}
class DH implements DF //DH实现了DF接口，也就继承了DF的全部抽象方法，但是我们却只需要 b（）方法，那么其他的方法就是多余的了
{
	public void a(){}
	public void b()
	{
		System.out.println("bb...");
	}
	public void c(){}
	public void d(){}
	public void e(){}
}
class DJ implements DF  //DJ实现了DF接口，也就继承了DF的全部抽象方法，但是我们却只需要 c（）方法，那么其他的方法就是多余的了
{
	public void a(){}
	public void b(){}
	public void c()
	{
		System.out.println("cc...");
	}
	public void d(){}
	public void e(){}
}
//通过上面的代码可以发现，存在许多我们根本用不上的方法，说明了接口设计的肥胖了，有一点小问题，因此用适配器解决这个问题
 */
//用适配器解决上面的问题
abstract class DFAdapter implements DF //DF的适配器DFAdapter直接实现接口,适配器只是一个中间介质，定义成abstract，不需要对象
{ // 且适配类被定义成abstract类，但是类里面没有抽象方法。
	public void a(){}
	public void b(){}
	public void c(){}
	public void d(){}
	public void e(){}
}
//然后在来继承DFAdapter
class DK extends DFAdapter  //重写a（）方法
{//可以只重写从DFAdapter继承而来的一个方法
	public void a()
	{
		System.out.println("aa...");
	}
}
class DL extends DFAdapter  //重写b（）方法
{//可以只重写从DFAdapter继承而来的一个方法
	public void b()
	{
		System.out.println("bb...");
	}
}
