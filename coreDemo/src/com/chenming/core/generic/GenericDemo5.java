package com.chenming.core.generic;
//测试泛型类可以实现泛型接口
public class GenericDemo5
{
	public static void main(String[] args)
	{
		Student stu = new Student("zhangsan");
		SubClass<String,Integer,Student> sc = new SubClass<String,Integer,Student>("张三",10,stu);
		sc.show(stu);
		sc.print();
	}
}
//创建泛型接口
interface IInfo<T>
{
	//接口中的所有属性都是private final static 修饰的
	//接口中的所有方法都是public abstract 修饰的
	public void show(T var);
}
//泛型类可以继承泛型类，也可以实现一个接口
class SubClass<T1,T2,T> extends SuperClass<T1> implements IInfo<T>
{
	private T2 data2;
	public SubClass()
	{
		
	}
	public SubClass(T1 data1,T2 data2,T var)
	{
		super(data1);
		this.data2 = data2;
	}
	
	@Override
	public void show(T var)
	{
		// TODO Auto-generated method stub
		System.out.println(var);
	}
	
}
//创建泛型类
class SuperClass<T1>
{
	private T1 data1;
	public SuperClass()
	{
		
	}
	public SuperClass(T1 data1)
	{
		this.data1 = data1;
	}
	
	public void setData1(T1 data1)
	{
		this.data1 = data1;
	}
	public T1 getData1()
	{
		return this.data1;
	}
	
	public void print()
	{
		System.out.println("打印输出"+this.data1);
	}
}