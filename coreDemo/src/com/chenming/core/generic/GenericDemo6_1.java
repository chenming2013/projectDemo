package com.chenming.core.generic;
//测试泛型限制      extends----> 泛型上限
public class GenericDemo6_1
{
	public static void main(String[] args)
	{
		Generic1<Animal> dgc = new Generic1<Animal>();
		dgc.setObj(new Dog());
		dgc.getObj().eat();
		
		System.out.println("======================分割符======================");
		
		Generic1<Cat> cgc = new Generic1<Cat>();
		cgc.setObj(new Cat());
		cgc.getObj().eat();
		
		System.out.println("*********************分割符**********************");
		
		Generic2<Teacher>  gc = new Generic2<Teacher>();
		gc.setObj(new Teacher());
		gc.getObj().speak();
	}
}
//泛型类所接受的参数做了限制，只能接收Animal类或者Animal类的子类。
class Generic1<T extends Animal>
{
	private T obj;
	public void setObj(T obj)
	{
		this.obj = obj;
	}
	public T getObj()
	{
		return this.obj;
	}
}

class Generic2<T extends Person>   //即使Person类是接口 ，但是也只能用extends来限制泛型,
{
	private T obj;
	public void setObj(T obj)
	{
		this.obj = obj;
	}
	public T getObj()
	{
		return this.obj;
	}
}

//定义抽象类
abstract class Animal
{
	public abstract void eat();
}
//定义接口
interface Person
{
	public void speak();
}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("狗在啃骨头！");
	}
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("猫在吃鱼肉！");
	}
}

class Teacher implements Person
{

	@Override
	public void speak()
	{
		// TODO Auto-generated method stub
		System.out.println("老师讲课！");
	}
	
}