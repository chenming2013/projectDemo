package com.chenming.core.innerClass;
//测试匿名内部类
public class InnerClassTest7
{
	public static void main(String[] args)
	{
		//这是传统的做法，没用到匿名内部类
	/*	Person p = new Person();
		Animal dog = new Dog();
		p.feed(dog);
    */
		//使用匿名内部类的做法    即：没有dog这个名字
		Person p = new Person();
		//new出来的是Animal类的子类，就必须要实现Animal类中的抽象方法
		p.feed(new Animal()     //假设这里new出来的一条狗    第一条狗
				{
					public void eat()
					{
						System.out.println("啃骨头...");
					}
				});
		p.feed(new Animal()  //假设这里new出来的是一只猫  
				{
					public void eat()
					{
						System.out.println("吃鱼肉...");
					}
				});
		p.feed(new Animal()     //这里又new出来了一条狗  
				{
					public void eat()
					{
						System.out.println("啃骨头...");
					}
				});
		//这里又new出来了一条狗，注意：这里的狗和第一次new出来的狗不是同一条，每次“喂养”一次就要多出一条不同的狗。而如果我们要求还是“喂养”第一条狗，那怎么办呢？
		//这时就需要用下面的办法了：
		Animal dog = new Animal()   //将匿名内部类赋值给一个引用变量
				{   //这是重写Animal的方法
					public void eat()
					{
						System.out.println("啃骨头...");
					}
					//这是自己定义的方法
					public void show()
					{
						System.out.println("自己定义的方法");
					}
				};
		p.feed(dog);
		p.feed(dog);
		//用这样的方式，上面的两次p.feed（dog）“喂养”的就是同一条狗了
		
		//同样的，接口也能够用这样的匿名类的做法，并且调用匿名类中自己定义的show()方法
		new InterfaceAnimal()   //new出来一个牛类
		{
			//重写接口中的抽象方法
			public void eat()
			{
				System.out.println("吃草...");
			}
			//自己定义的方法
			public void show()
			{
				System.out.println("看，老牛正在吃嫩草！");
			}
		}.show();
	}
}

class Person
{
	public void feed(Animal animal)  //多态机制
	{
		animal.eat();
	}
	//这是为了测试接口而特意声明的方法
	public void feed(InterfaceAnimal interfaceAnimal)
	{
		interfaceAnimal.eat();
	}
}
abstract class Animal
{
	public abstract void eat();
}
//这是为了测试接口而特意定义的接口
interface InterfaceAnimal
{
	public abstract void eat();
}
/*
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("啃骨头...");
	}
}
*/