package com.chenming.core.meiju;
//枚举类型中同样可以有setter、getter方法
public class EnumDemo6
{
	public static void main(String[] args)
	{
		System.out.println(ColorF.RED);
		
		//调用setter方法为颜色赋值
		ColorF.RED.setColorName("黄色");
		System.out.println(ColorF.RED.getColorName());
	}
}
//枚举中同样给能使用setter、getter方法
enum ColorF
{
	//预先创建枚举对象
	RED("红色"),GREEN("绿色"),BLUE("蓝色");   // 相当于 private static final ColorF RED = new ColorF("红色");  但是private static final 却不能显式的声明
	
	private String colorName;
	
	ColorF(String colorName)   //枚举类型的构造方法不能声明为public
	{
		this.colorName = colorName;
	}
	
	//setter、getter方法
	public void setColorName(String colorName)
	{
		this.colorName = colorName;
	}
	public String getColorName()
	{
		return this.colorName;
	}
	
	//重写toString()方法
	public String toString()
	{
		return "颜色是："+ this.colorName;
	}
	
}