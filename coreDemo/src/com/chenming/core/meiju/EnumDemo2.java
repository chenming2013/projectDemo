package com.chenming.core.meiju;


class EnumDemo2 
{
	public static void main(String[] args) 
	{
		ColorA red = ColorA.RED;
		System.out.println(red);
		
	}
}
//定义枚举类
//当JVM去加载使用枚举类的时候，会预先创建多个枚举类型的对象，供外部对象来使用。

enum ColorA
{
	//此处为实例化对象，即实例化了三个ColorA类对象。枚举对象之间用逗号隔开，最后加上分号。
	/*
	 * 当加载枚举类 的时候，会预先做下面的事情：
	 * public static final ColorA RED = new Color();
	 * public static final ColorA GREEN = new Color();
	 * public static final ColorA BLUE = new Color();
	 * */
	RED,GREEN,BLUE;  
}
