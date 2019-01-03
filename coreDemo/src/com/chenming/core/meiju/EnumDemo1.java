package com.chenming.core.meiju;

//定义一个多例设计模式


class EnumDemo1 
{
	public static void main(String[] args) 
	{
		Color red = Color.getInstance(1);
		System.out.println(red);
		System.out.println(red.toString());
	}
}
//声明一个颜色基色的类
class Color
{
	private String title;
	//构建出颜色基色的对象,设置成静态常量。
	private static final Color RED = new Color("红色");
	private static final Color GREEN = new Color("绿色");
	private static final Color BLUE = new Color("蓝色");

	public Color(String title)
	{
		this.title = title;
	}

	public static Color getInstance(int ch)
	{
		switch(ch)
		{
			case 1:
				return RED;
			case 2:
				return GREEN;
			case 3:
				return BLUE;
			default:
				return null;
		}
	}
	public String toString()
	{
		return this.title;
	}
}
