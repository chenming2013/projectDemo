package com.chenming.core.array;

import com.chenming.core.serializable.Person;

/**
 * 这是测试数组
 * @author Lenovo
 *
 */
public class ArrayTest01
{
	public static void main(String[] args)
	{
		
		double[] dArray = new double[3];
		System.out.println("array的类名是: "+dArray.getClass().getName());   //array的类名是: [D
		
		
		String[] sArray = new String[2];
		System.out.println("array的类名是: "+sArray.getClass().getName());  //[Ljava.lang.String;
		
		
		Person p = new Person();
		System.out.println("Person的类名是: "+p.getClass().getName()); //com.chenming.core.serializable.Person
		
		Person[] pArray = new Person[2];
		System.out.println(pArray.getClass().getName());  //[Lcom.chenming.core.serializable.Person;
		
	}
}
