package com.chenming.core.abstractAndInterface;

public class InterfaceTest4
{
	public static void main(String[] args)
	{
		NStudent stu = new NStudent();
		stu.sing();
		stu.dance();
		
		Sing s = new NStudent(); //向上转型
		Dance d = (Dance)s;      //向下转型
		//在定义结构上来讲，Sing类与Dance类没有什么直接联系，但是这两个接口却同时拥有一个NStudent子类，这样两个层的对象就建立了联系。
		//但是让两个没有联系的对象建立联系，这样并不好
		System.out.println(s instanceof Sing); //true
		System.out.println(s instanceof Dance);//true
		System.out.println(d instanceof Sing);//true
		System.out.println(d instanceof Dance);//true
	}
}
interface Sing
{
	public void sing();
}
interface Dance
{
	public void dance();
}
class NStudent implements Sing,Dance  //学生类实现了sing接口和dance接口，说明学生对象既能sing又能dance
{
	public void sing()
	{
		System.out.println("能唱歌...");
	}
	public void dance()
	{
		System.out.println("能跳舞...");
	}
}