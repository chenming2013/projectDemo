package com.chenming.core.generic;
//测试泛型类可以同时设置多个参数
public class GenericDemo3
{
	public static void main(String[] args)
	{
		GenericClass3<String,Integer> gc = new GenericClass3<String,Integer>();
		gc.setData1("chenming");
		gc.setData2(1);
		System.out.println(gc.getData1()+"-"+gc.getData2());
	}
}
//创建带有两个泛型参数的泛型类
class GenericClass3<T1,T2>
{
	private T1 data1;
	private T2 data2;
	
	public GenericClass3()
	{
		
	}
	public GenericClass3(T1 data1,T2 data2)
	{
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public void setData1(T1 data1)
	{
		this.data1 = data1;
	}
	public T1 getData1()
	{
		return this.data1; 
	}
	public void setData2(T2 data2)
	{
		this.data2 = data2;
	}
	public T2 getData2()
	{
		return this.data2;
	}
	
}
