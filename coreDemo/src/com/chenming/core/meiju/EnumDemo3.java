package com.chenming.core.meiju;
//扩充枚举类中的功能，向枚举类中添加属性、方法
public class EnumDemo3
{
	public static void main(String[] args)
	{
		for(ColorC color:ColorC.values())    //values()方法将枚举对象返回成数组
		{
			//输出每一个枚举常量，并且将其次序也输出
			System.out.print(color+" -编号是- "+ color.ordinal());   //ordinal()方法得到当前枚举常量的次序
			System.out.println();
			
			System.out.println("是否与要查找的颜色匹配："+color.equals(ColorC.BLUE));  //枚举类型的equals方法比较的是地址

			
			 //枚举类型的equals方法比较的是地址
			if(color.equals(ColorC.BLUE))   //注意：color是对象
			{
				System.out.println(color.ordinal());
			}
			
		}
		
	}
}
enum ColorC
{
	//枚举对象必须放在首行
	//定义颜色基色对象
	RED("红色"),GREEN("绿色"),BLUE("蓝色");  //此处为实例化对象，即实例化了三个Color类对象。枚举对象之间用逗号隔开，最后加上分号
	/*
	 * 上面就相当于下面的三行代码：
	 * 	public static final ColorC RED = new ColorC("红色");
	 * 	public static final ColorC GREEN = new ColorC("绿色");
	 * 	public static final ColorC BLUE = new ColorC("蓝色");
	 * 
	 **/
	private String title;
	//定义构造方法  注意：枚举中的构造方法不能用public、protected声明，建议最好用private声明，当然也可以用default
	//也就是说外部类不能new一个枚举类的对象。
	
	ColorC(String title)
	{
		this.title = title;
	}
	public String toString()
	{
		return this.title;
	}
	
	
}
