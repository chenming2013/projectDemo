package com.chenming.core.meiju;
//枚举类可以在每一个对象后面使用匿名内部类的形式实现抽象方法
public class EnumDemo5
{
	public static void main(String[] args)
	{
		MessageA msg = ColorE.RED;
		System.out.println(msg.getTitle());
	}
}
enum ColorE implements MessageA
{
	//枚举对象必须放在首行
	//定义颜色基色对象    此处为实例化对象，即实例化了三个Color类对象。枚举对象之间用逗号隔开，最后加上分号
	RED("红色"){
		public String getTitle()
		{
			return "RED对象中自己的"+this;
		}
	},   //注意：这里有个枚举常量之间的逗号
	GREEN("绿色"){
		public String getTitle()
		{
			return "GREEN对象中自己的"+this;
		}
	},   //注意：这里有个枚举常量之间的逗号
	BLUE("蓝色"){
		public String getTitle()
		{
			return "BLUE对象中自己的"+this;
		}
	};  //注意：这里有个分号。
	
	private String title;
	//定义构造方法  注意：枚举中的构造方法不能用public声明，建议最好用private声明，当然也可以用protected、default
	ColorE(String title)
	{
		this.title = title;
	}
	public String toString()
	{
		return this.title;
	}
}
interface MessageA
{
	public String getTitle();
}
