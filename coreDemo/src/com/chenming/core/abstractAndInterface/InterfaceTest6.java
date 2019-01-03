package com.chenming.core.abstractAndInterface;
/*
 *编程：使用多态实现士兵作战程序 
 *     编写一个Soldier类，描述具有普遍行为和属性的一个士兵对象
 *     编写陆军士兵、海军士兵、军官类来拓展Soldier类
 *     运行结果：
 *     准备攻击
 *     张三使用步枪射击
 *     攻击完成
 *     准备攻击
 *     李四使用鱼雷射击
 *     攻击完成
 *     准备攻击
 *     王五使用手枪射击
 *     攻击完成
 */
public class InterfaceTest6
{
	public static void main(String[] args)
	{
		Officer officer = new Officer("王五");
		officer.callToAttack();
		System.out.println("###########################");
		officer.callToAttack(officer.getSoldier()[0]);
	}
}
abstract class Soldier
{
	private String name;
	public Soldier(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void action()
	{
		start();
		attack();  
		end();
	}
	public void start()
	{
		System.out.println("准备攻击");
	}
	//士兵攻击的手段不同，具体的实现怎样攻击要到子类去做
	public abstract void attack();
	public void end()
	{
		System.out.println("攻击完成");
	}
}
class LandSoldier extends Soldier  //陆军继承Soldier
{
	public LandSoldier(String name)
	{
		super(name);
	}
	//实现抽象类Soldier类中的抽象方法
	public void attack()
	{
		System.out.println(this.getName() + "使用步枪射击");
	}
}
class OceanSoldier extends Soldier //海军继承Soldier
{
	public OceanSoldier(String name)
	{
		super(name);
	}
	public void attack()
	{
		System.out.println(this.getName() + "使用鱼雷射击");
	}
}
class Officer extends Soldier  //军官继承Soldier类
{
	//军官持有两个士兵,一个陆军士兵。一个海军士兵
	private Soldier[] soldiers = new Soldier[2];
	public Officer(String name)
	{
		super(name);
		soldiers[0] = new LandSoldier("张三");
		soldiers[1] = new LandSoldier("李四");
	}
	//将数组整个返回
	public Soldier[] getSoldier()
	{
		return soldiers;
	}
	
	public void attack()
	{
		System.out.println(this.getName() + "使用手枪射击");
	}
	//军官除了继承而来的attack方法外，还有自己的指挥方法，能够只会士兵作战
	public void callToAttack() //军官让他所持有的所有士兵一起发动攻击，包括自己
	{
		for(int i=0;i<soldiers.length;i++)
		{
			soldiers[i].action();  //每个士兵调用其自身的攻击方法
		}
		this.action(); //自己参与攻击
	}
	//军官让其所持有的其中一个士兵攻击     上面的callToAttack（）方法是让所有的士兵一起攻击
	public void callToAttack(Soldier soldier)
	{
		soldier.action();
	}
}