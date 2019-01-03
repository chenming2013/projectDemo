package com.chenming.core.thread;

//资源共享测试
//多线程实现卖出10张票
public class MultiThreadDemo3_1
{
	public static void main(String[] args)
	{	
		MyThread3 mt = new MyThread3();  //创建一个MyThread对象，就相当于是一个资源
		
		//创建三个线程共同抢占资源，这就是资源共享
		Thread  thread1 = new Thread(mt,"线程1");
		Thread  thread2 = new Thread(mt,"线程2");
		Thread  thread3 = new Thread(mt,"线程3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		//最后的结果虽然也能三个线程共同卖10涨票，但是却有不合适的地方：
		//MyThread3这个类继承了Thread类，本来就有start()方法，但我们又创建Thread对象，调用Thread对象的start()方法启动线程，这不是矛盾吗？
	}
}
class MyThread3 extends Thread
{
	private int ticket = 10;
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			if(this.ticket>0)
				System.out.println(Thread.currentThread()+"卖票，ticket=" + this.ticket--);
		}
	}
}
