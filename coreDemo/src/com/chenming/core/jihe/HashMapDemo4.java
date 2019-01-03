package com.chenming.core.jihe;
/*
 *统计一个字符串中每一个字符出现的次数，并且要求按照次数顺序排序，如果次数相同，则按字母顺序排序。 
 *思路：通过HashMap集合就可以实现计算次数的操作。如果要进行排序，我们可以采用TreeSet集合。并且是根据放入TreeSet中的对象的属性来进行排序的。
 */
import java.util.HashMap;
import java.util.TreeSet;

public class HashMapDemo4
{
	public static void main(String[] args)
	{
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		String str = "dahdahebslsieceuabjvcmzko";
		for(int i=0;i<str.length();i++)
		{
			String s = str.substring(i,i+1);
			if(hm.containsKey(s))
			{
				hm.put(s,hm.get(s)+1);
			}
			else
			{
				hm.put(s,1);
			}
		}
		//遍历HashMap集合，然后把每一个key、value都包装成T对象的实例放入TreeSet集合，就完成了排序。
		TreeSet<T> ts = new TreeSet<T>();  //创建TreeSet集合
		for(String key:hm.keySet())
		{
			T t = new T(key,hm.get(key));
			ts.add(t);
		}
		System.out.println(ts);
	}
}
class T implements Comparable<T>
{
	private String name;
	private int count;
	/**
	 * @return the name
	 */
	public T()
	{
		
	}
	public T(String name,int count)
	{
		this.name = name;
		this.count = count;
	}
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return name+"="+count;
	}
	@Override
	public int compareTo(T o)
	{ 
		// TODO Auto-generated method stub
		if(this.count!=o.count)
			return o.count-this.count;
		else
			return this.name.compareTo(o.name);
	}
	
}
