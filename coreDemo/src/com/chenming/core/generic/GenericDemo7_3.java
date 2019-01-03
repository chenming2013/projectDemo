package com.chenming.core.generic;


public class GenericDemo7_3
{
	public static void main(String[] args)
	{
		
		GenClass7_3<Integer> gc = new GenClass7_3<Integer>(100);
		System.out.println(gc.getData());
		
		GenClass7_3<Number> gc2 = new GenClass7_3<Number>(30);
		System.out.println(gc2.getData());
		
//		gc2 = gc; 这与之前讲的一样，GenClass7_3<Number>、GenClass7_3<Integer>都是独立的一个个桶，尽管Integer是Number的子类，但是GenClass7_3<Number>、GenClass7_3<Integer>却没有什么关系。
		//而GenClass7_3<? extends Number>则是所有 “GenClass7_3<Number>及其子类” 的父类。
		GenClass7_3<? extends Number> gc3 = new GenClass7_3<Double>(10.9);  
		gc3 = gc;
		gc3 = gc2;
		System.out.println(gc3.getData());
	}
}
class GenClass7_3<T extends Number>  //extends 限定上限
{
	private T data;
	public GenClass7_3(T data)
	{
		this.data = data;
	}
	public T getData()
	{
		return this.data;
	}
}

