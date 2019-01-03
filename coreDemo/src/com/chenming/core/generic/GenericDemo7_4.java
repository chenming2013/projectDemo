package com.chenming.core.generic;

//测试  "? extends" 类   与   "? super"  类
//“? extends 类”: 泛型上限，可以在声明上和方法参数上使用
//“? super 类”  ：泛型下限，只能在方法参数上使用。

public class GenericDemo7_4
{
	public static void main(String[] args)
	{
		GenClass7_4_1<Number> gc = new GenClass7_4_1<Number>(10);
		System.out.println(gc.getData());  //输出10
		gc.<Double>show(10.8);
		
	}
}
class GenClass7_4_1<T extends Number>
{
	private T data;
	public GenClass7_4_1(T data)
	{
		this.data = data;
	}
	public T getData()
	{
		return this.data;
	}
	public <U extends Number>void show(U content)
	{
		System.out.println(content);
	}
}
class GenClass7_4_2<T>
{
	private T data;
	public GenClass7_4_2(T data)
	{
		this.data = data;
	}
	public void show(GenClass7_4_1<? super Number> content)  //? super 类只能用在方法参数中。
	{
		
	}
	
}
