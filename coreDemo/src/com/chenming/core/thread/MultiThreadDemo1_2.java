package com.chenming.core.thread;

public class MultiThreadDemo1_2
{
	public static void main(String[] args)
	{
		
		HelloThread1 ht1 = new HelloThread1();
		ht1.setName("线程1");  //为线程取一个名字，也可以声明带参数的构造方法，在创建线程的时候就取好名字
		ht1.start();
		
		HelloThread1 ht2 = new HelloThread1();
		ht2.setName("线程2");
		ht2.start();
		
		
	}
}
class HelloThread1 extends Thread
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{
			System.out.println(this.getName()+":"+i);
		}
	}
}