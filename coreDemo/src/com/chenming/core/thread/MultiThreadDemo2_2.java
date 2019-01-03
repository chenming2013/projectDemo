package com.chenming.core.thread;

public class MultiThreadDemo2_2
{
	public static void main(String[] args)
	{
		HelloThread2 ht1 = new HelloThread2();
		Thread thread1 = new Thread(ht1);  //也可以 Thread thread1 = new Thread(ht1,"线程1");这样可以直接为线程取名
		thread1.setName("线程1");  //可以使用set()方法，也可以在创建Thread对象的时候，调用带两个参数的构造方法
		thread1.start();
		
		HelloThread2 ht2 = new HelloThread2();
		Thread thread2 = new Thread(ht2,"线程2");
		thread2.start();
	}
}
class HelloThread2 implements Runnable
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i);   //currentThread()方法返回当前对象的引用
		}
	}
}