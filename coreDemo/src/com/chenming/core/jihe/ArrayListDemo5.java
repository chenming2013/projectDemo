package com.chenming.core.jihe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

//这个程序主要是为了测试泛型
//泛型操作主要是为了在编译阶段防止错误输入，有了泛型我们就不用进行强制类型转换的，因为存入集合中的元素都是同一个类型的。
//注意：因为编译器的开发商与运行环境的开发商不是同一个，由于泛型只是在编译阶段有效，如果绕过编译，那么就可以绕过泛型。
public class ArrayListDemo5
{
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("hello");
		al.add("world");
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String str = it.next(); //因为使用了泛型，所以这里就不用就（it.next()）返回的元素强制转换成String类型。
			System.out.println(str);
		}
		//反射都是绕过编译的，下面的操作就是绕过泛型的操作。
		ArrayList al2 = new ArrayList();  //并没有使用泛型
		
		//验证一：泛型只在编译阶段有效，编译后是去泛型化的。
		System.out.println(al.getClass()==al2.getClass()); //运行后结果是 true，说明编译后是去泛型化的。
		System.out.println(al.getClass()==ArrayList.class); //运行结果是true，
		
		//验证二：用add()方法的反射来进行操作
		try
		{
			Method m = al.getClass().getMethod("add",new Class[]{Object.class});
			m.invoke(al, new Object[]{100});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(al.size());
		
		//注意：现在再用foreach遍历就会有类型转换异常。
		
	}
}
