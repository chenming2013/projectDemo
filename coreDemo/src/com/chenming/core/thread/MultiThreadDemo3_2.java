package com.chenming.core.thread;

//资源共享测试
//多线程实现卖出10张票
public class MultiThreadDemo3_2
{
	public static void main(String[] args)
	{
		MyThread4 mt = new MyThread4();   //创建一个MyThread类,就相当于是一个资源
		
		//新建三个线程抢占资源，这就是资源共享
		Thread thread1 = new Thread(mt);
		Thread thread2 = new Thread(mt);
		Thread thread3 = new Thread(mt);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
class MyThread4 implements Runnable
{
	private int ticket = 10;
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			if(this.ticket>0)
				System.out.println("卖票，ticket=" + this.ticket--);
		}
	}
}
