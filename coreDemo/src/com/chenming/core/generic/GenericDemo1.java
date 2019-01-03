package com.chenming.core.generic;
//创建一个泛型类
public class GenericDemo1
{
	public static void main(String[] args)
	{
		//将泛型限定为String类型  
		GenericClass<String> gc = new GenericClass<String>();
		gc.setData("chenming");
//		gc.setData(10);  限定了泛型类为String，因此不能传入Integer类型值
		System.out.println(gc.getData());
		
		//将泛型限定为Integer类型  注意：泛型类型只能是引用数据类型
		GenericClass<Integer> gc2 = new GenericClass<Integer>();
		gc2.setData(10);
//		gc2.setData("cm");   限定了泛型类型为Integer，因此不能传入String类型值
		System.out.println(gc2.getData());
		
	}
}
//创建泛型类
class GenericClass<T>   //T:是type的首字母，表示数据类型，只能是引用数据类型，如果是基本数据类型，则变成他们的包装类。
{
	private T data;   //泛型可以声明数据类型。
	//构造方法
	public GenericClass()  //不能是public GenericClass<T>(){}  解释：泛型的对一个集群使用的，是不具体抽象的；而一个对象就是具体的，与泛型的思想冲突。
	{
		
	}
	public GenericClass(T data)
	{
		this.data = data;
	}
	
	public void setData(T data)   //泛型可以声明形式参数
	{
		this.data = data;
	}
	public T getData()   //泛型可以声明返回值
	{
		return this.data;
	}
	
}
