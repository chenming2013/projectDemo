package com.chenming.core.thread;

public class MultiThreadDemo1_1
{
	public static void main(String[] args)
	{
		//创建三个线程，让他们各自执行自己的任务
		MyThread mt1 = new MyThread("线程A");   //这是在创建线程的时候就为线程取号名字，也可以通过setName()方法另外设置
		MyThread mt2 = new MyThread("线程B");
		MyThread mt3 = new MyThread("线程c");
		//多线程启动的唯一方法就是Thread类中的start()方法,注意：调用start()方法，JVM会执行该线程的run()方法。
		//由于MyThread类继承了Thread类，类中有start()方法，所以每一个MyThread对象就是一个线程对象，可以直接调用start()方法启动
		mt1.start();
//		mt1.start();   //如果这里又调用了一次start()方法会怎样？---->一个线程没有结束之前，只能调用一次start()方法，如果多次调用start()方法，启动该线程，就会报 “IllegalThreadStateException” 异常
		mt2.start();
//		mt2.start();
		mt3.start();
		//此时每一个线程对象抢占资源，交替执行
	}
}
class MyThread extends Thread  //这是一个多线程的操作主类
{
	private String name;
	public MyThread(String name)  //定义构造方法
	{
		this.name = name;
	}
	@Override
	public void run()  //重写run()方法，作为线程的主体操作方法
	{
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			System.out.println(this.name+"--->"+i);
		}
	}
}