package com.chenming.core.jihe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		
		UserA u1 = new UserA("zhangsan","001");
		UserA u2 = new UserA("lisi","002");
		UserA u3 = new UserA("wangwu","003");
		UserA u4 = new UserA("zhanliu","004");
		UserA u5 = new UserA("qianqi","005");
		UserA u6 = new UserA("qianqi","006");
		
		//key是唯一标识，每一个key都可以得到唯一的value值。
		hm.put(u1.getUName(),u1); //通过uname能够得到u1这个对象 
		hm.put(u2.getUName(),u2); //通过uname能够得到u2这个对象 
		hm.put(u3.getUName(),u3); //通过uname能够得到u3这个对象 
		hm.put(u4.getUName(),u4); //通过uname能够得到u4这个对象 
		hm.put(u5.getUName(),u5); //通过uname能够得到u5这个对象 
		hm.put(u5.getUName(),u1); //HashMap中不允许存放相同的key，否则会将前面的覆盖，
		hm.put(u6.getUName(), u6);
		hm.put(null,u1);  //能存放null
		
		System.out.println(hm.size());
		//直接打印Map对象会打印key的toString=value的toString；
		System.out.println(hm); //直接打印对象，就会打印出：key=value。
		
		//key、value都是Object
		//因为没有使用泛型。所以要强制类型转换 
		UserA user = (UserA)hm.get("zhangsan");  //get(key)得到value
		System.out.println(user);
		
		//是否包含某个key
		System.out.println(hm.containsKey("wangwu"));  //true
		System.out.println(hm.containsKey("chenming")); //false
		
		System.out.println("==========分割符==============");
		
		//遍历方式一：把Map中所有的key都放入Set集合中，然后遍历Set集合。得到key，通过key获取value。
		Set set = hm.keySet();  
		for(Object obj:set)
		{
			String key = (String)obj;  //将Set集合中的key一个个取出来
			UserA value = (UserA)hm.get(key); //get(key)得到value
			System.out.println(key+"="+value);
		}
		
		System.out.println("==========分割符==============");

		//遍历方式二：放入HashMap集合中的key、value其实都会被包装成Map.Entry这个内部类的属性，
		//          有一个键值对就存在一个Map.Entry的实例对象。
		//          通过entrySet()方法可以把这些实例对象都放入Set集合中。
		Set set1 = hm.entrySet(); //将封装键值对的entry实例对象都放入Set集合中。
		for(Object obj:set1)
		{
			Map.Entry me = (Map.Entry)obj;
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
	
}