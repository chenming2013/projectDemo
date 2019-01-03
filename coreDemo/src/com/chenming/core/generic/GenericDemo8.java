package com.chenming.core.generic;

public class GenericDemo8
{
	public static void main(String[] args)
	{
		GenClass<String> gc = new GenClass<String>();
		gc.print("普通的一种方法，都是只能传入一种类型的数据");  //如果是定义成泛型类的话，那么print()方法传入的参数只能是String类型，打印的内容也只能是根据传入类型输出的内容。
		               //那么能不能让print()方法根据传入的类型打印出不同类型的内容呢？
		               //此时就需要使用泛型方法了。
		
		GenClass2 gc2 = new GenClass2();
		gc2.<String>print("而泛型方法，却可以根据传入的类型，输出不同类型的内容");   //按照要去输出String型内容
		gc2.<Integer>print(10);                         //按照要求输出Integer型内容
		gc2.<Student>print(new Student());              //按照要求输出Student型内容
		gc2.<Fruit>print(new Apple());                  //按照要求输出Fruit型内容，
		gc2.<Animal>print(new Dog());                   //因为Animal是抽象类，所以只能new Dog()
		gc2.print(new Teacher());
	}
}
class GenClass<T>
{
	public void print(T content)
	{
		System.out.println(content);
	}
}

class GenClass2
{   //定义一个普通类，但是类中可以声明泛型方法，也可以声明普通方法。
	public void show(String msg)
	{
		System.out.println(msg);
	}
	public static <T> void info(T content)   //如果施加类型约束的方法是静态方法，那么就只能将其定义为泛型方法，因为静态方法在类加载的时候就会被加载，而泛型类型是在实例化的时候才确定的，所以就相当于静态的不能引用非静态的。
	{                                        //这里的参数是用泛型，且被定义成static，那么就只能将这个方法定义成泛型方法，否则会报错。
		System.out.println("如果施加类型约束的方法是静态方法，那么就只能将其定义为泛型方法");
	}
	public void info()
	{  //try-catch中不可以使用泛型。
//		try
//		{
//			
//		}
//		catch(T t)
//		{
//			
//		}
	}
	
	public <T> void print(T content)
	{
		System.out.println(content);
	}
	//泛型方法能够重载 因为方法的参数类型不同
	public <T extends Animal> void print(T content)
	{
		System.out.println("这是重载的泛型方法！");
		System.out.println(content);
	}
}