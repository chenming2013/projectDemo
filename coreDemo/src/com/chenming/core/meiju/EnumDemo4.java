package com.chenming.core.meiju;
//枚举类还可以实现接口
public class EnumDemo4
{
	public static void main(String[] args)
	{
		Message msg = ColorD.RED;
		System.out.println(msg.getTitle());
	}
}
//枚举实现接口
enum ColorD implements Message
{
	//枚举对象必须放在首行
	//定义颜色基色对象
	RED("红色"),GREEN("绿色"),BLUE("蓝色");  //此处为实例化对象，即实例化了三个ColorD类对象。枚举对象之间用逗号隔开，最后加上分号
	private String title;
	//定义构造方法  注意：枚举中的构造方法不能用public声明，建议最好用private声明，当然也可以用protected、default
	ColorD(String title)
	{
		this.title = title;
	}
	public String toString()
	{
		return this.title;
	}
	@Override
	public String getTitle()
	{
		// TODO Auto-generated method stub
		return this.title;
	}
}
interface Message
{
	public abstract String getTitle();
}
