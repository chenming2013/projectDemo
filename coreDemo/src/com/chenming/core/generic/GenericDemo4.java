package com.chenming.core.generic;
//测试泛型类可以继承泛型类
public class GenericDemo4
{
	public static void main(String[] args)
	{
		SubGenericClass4<String,Integer> gc = new SubGenericClass4<String,Integer>("张三",10);
		
//		gc.setVar1("cm");  //子类继承了父类的setter、getter方法，所以能够为父类赋值。
//		gc.getVar1();     //子类继承了父类的setter、getter方法，所以能够取得父类赋值。
		
		System.out.println(gc.show1());
	}
}

//创建泛型类
class SuperGenericClass4<T1>
{
	private T1 var1;
	
	public SuperGenericClass4()
	{
		
	}
	public SuperGenericClass4(T1 var1)
	{
		this.var1 = var1;
	}
	
	public T1 show1()
	{
		return this.var1;
	}
	
	public void setVar1(T1 var1)
	{
		this.var1 = var1;
	}
	public T1 getVar1()
	{
		return this.var1;
	}
}
//创建一个泛型子类继承泛型父类
class SubGenericClass4<T1,T2> extends SuperGenericClass4<T1>
{
	private T2 var2;
	
	public SubGenericClass4()   //子类的构造方法会默认调用父类的无参构造方法
	{
		
	}
	public SubGenericClass4(T1 var1,T2 var2)
	{
		super(var1);  //为父类对象赋值初始化
		this.var2 = var2;
	}
	public void setVar2(T2 var2)
	{
		this.var2 = var2;
	}
	public T2 getVar2()
	{
		return this.var2;
	}
	//重写父类的show方法
	public T1 show1()
	{
		return super.show1();
	}
}
