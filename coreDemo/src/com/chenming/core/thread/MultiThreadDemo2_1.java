package com.chenming.core.thread;

public class MultiThreadDemo2_1
{
	public static void main(String[] args)
	{
		//创建三个资源
		MyThread2 mt1 = new MyThread2("线程A");
		MyThread2 mt2 = new MyThread2("线程B");
		MyThread2 mt3 = new MyThread2("线程c");
		//多线程启动的唯一方法就是Thread类中的start()方法,注意：调用start()方法，JVM会执行该线程的run()方法。
		//由于MyThread2类是实现Runnable接口，而并没有继承Thread类，所以MyThread对象并不是一个线程对象，此时就需要创建线程对象
		
		//创建三个线程，每一个线程执行相应的资源。
		Thread thread1 = new Thread(mt1);   //调用 public Thread(Runnabel target) 构造方法
		Thread thread2 = new Thread(mt2);
		Thread thread3 = new Thread(mt3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		//此时每一个线程对象抢占资源，交替执行
	}
}
class MyThread2 implements Runnable  //这是一个多线程的操作主类
{
	private String name;
	public MyThread2(String name)  //定义构造方法
	{
		this.name = name;
	}
	@Override
	public void run()  //重写run()方法，作为线程的主题操作方法
	{
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			System.out.println(this.name+"--->"+i);
		}
	}
}