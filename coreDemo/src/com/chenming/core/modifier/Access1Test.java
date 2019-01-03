package com.chenming.core.modifier;
import com.chenming.core.test.*;

/**
 * 测试权限控制符
 * 	test包下有Access1和Access2两个类,这两个类唯一的不同就是他们的访问控制权限不同
 * 	Access1是public修饰的,Access2是default修饰的
 * 	
 * @author Lenovo
 *
 */
public class Access1Test extends Access1
{
	public static void main(String[] args)
	{
		/**
		 * Access1Test与Access1两个类不在同一个包下,此时要考虑Access1类的访问权限
		 * 因为Access1的访问权限是public,所以任何类都可以访问到这个类(无论是不是在同一个包中),
		 * 在这个前提下,访问类中成员,就要看程序员的访问权限了
		 * 
		 */
		Access1Test at = new Access1Test();
		/**
		 * protected: 在同一个包的类和所有子类可见
		 */
		System.out.println(at.address);
		System.out.println(at.school);
		
		//
	}
}
