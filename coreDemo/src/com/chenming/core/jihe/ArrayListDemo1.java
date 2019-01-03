package com.chenming.core.jihe;
//这里没有使用泛型，所以集合中任何类型的元素都可以存放，那么在遍历的时候就容易出现异常。
import java.util.ArrayList;
class ArrayListDemo1
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		//ArrayList集合中存放的是有序的元素，且这些元素能够重复。
		ArrayList al = new ArrayList();
		Product p1 = new Product("java","001",100);

		al.add(p1);
		al.add(new Product("C","002",90));
		al.add(new Product("C++","003",100));
		al.add(new Product("PHP","004",80));
		al.add(new Product("JAVA WEB","005",90));
		
		System.out.println("刚开始时集合中有效元素个数: "+al.size());
		
		System.out.println("============================分割符=======================");
		
		//ArrayList能添加重复的元素。(添加到数组末尾)
		al.add(p1);
		System.out.println(al);
		//向集合中的指定位置添加元素
		al.add(2,new Product("UI","009",99));
		System.out.println(al);
		//用新的元素替换集合中指定位置的元素。
		al.set(3,new Product("HTML","010",50));
		System.out.println(al);
		//ArrayList集合允许存放null元素。
		al.add(null);
		al.add(null);
		al.add(null);
		System.out.println(al);
		
		//因为集合中只有8个元素，下标从0~7，且每个元素都是依次顺序放置的，所以数组之间不能有空开，下面的添加位置就是不正确的,会抛出 indexOutOfBoundsException 异常
		//al.add(8,new Product("C#","008",120)); //正确的添加位置下标只能是0~7

		
		//查看集合中有效元素的个数
		System.out.println(al.size());
		//输出集合中的所有元素
		System.out.println(al);
		System.out.println(al.toString()); //打印对象，就是打印对象的toString()方法.所以这个结果和上面是一样的。

		System.out.println("================================================");

		//根据下标获取某个元素
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		System.out.println(al.get(3));
		System.out.println(al.get(4));
		System.out.println(al.get(5));
		System.out.println(al.get(6));
		System.out.println(al.get(7));
		//因为集合中只有8个元素，下标从0~7，且每个元素都是依次顺序放置的，所以下面找不到get(8)，运行时就会抛出 indexOutOfBoundsException 异常
		//System.out.println(al.get(8));

		
		//查找某个元素是否在集合中
		System.out.println(al.indexOf(p1));  //找到返回下标
		Product p9 = new Product();
		System.out.println(al.indexOf(p9));  //找不到返回-1
		
	}
}




