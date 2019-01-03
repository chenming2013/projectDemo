package com.chenming.core.generic;

import java.util.Arrays;
import java.util.List;

//编程：自定义一个可以存放指定数据的容器
//要求：设计定义一个泛型类、设置add()方法来给容器添加数据、设计get()方法获取容器中指定位置的数据、设计size()方法获得容器中数据的多少、要求容器超过容量要自动扩容
//结果：下面的代码有一些问题，他并没有自己扩容
public class GenericDemo9
{
	public static void main(String[] rags) 
	{
		IContainer<String> list = new ArrayList<String>();
		//想容器中添加元素 
		for(int i=0;i<11;i++)
		{
			list.add("data"+(i+1));
		}
		//输出容器中的元素
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
}
class ArrayList<T> implements IContainer<T>
{
//	private T[] data = new T[10];  不能创建泛型数组
	private Object[] data = null;
	private int size = 0;  //记录容器元素的个数
	public ArrayList() //这个构造方法是设置初始数组默认大小
	{
		data = new Object[10];  //Object[]数组初始大小为10
	}
	public ArrayList(int capacity)  //这个构造方法是指定数组大小
	{
		data = new Object[capacity];
	}
	@Override
	public void add(T obj)
	{
		// TODO Auto-generated method stub
		ensureCapacity(size+1); //判断元素的个数是否已经超过了容器的大小，超过了就要对容器进行扩容
		data[size++] = obj; //将元素添加进容器中
	}
	@Override
	public T get(int index)
	{
		// TODO Auto-generated method stub
		return (T)data[index];
	}
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}
	private void ensureCapacity(int capacity)
	{
		if(capacity>data.length)
		{
			int oldCapacity = data.length;  //获取原有数组容器的大小
			int newCapacity = oldCapacity + oldCapacity>>2;  //扩容为原有数组的1.5倍。
			data = Arrays.copyOf(data,newCapacity);  //把原有数组中的数据拷贝到新创建的数组中
		}
	}
	
	
}
interface IContainer<T>
{
	public void add(T obj);  //给容器添加数据
	public T get(int index); //获取制定下标位置处的元素内容
	public int size();       //返回容器中元素的个数
}