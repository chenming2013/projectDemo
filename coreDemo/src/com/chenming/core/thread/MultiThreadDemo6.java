package com.chenming.core.thread;

//线程通信测试：
//使用两个线程打印1~100，线程1、线程2交替打印
public class MultiThreadDemo6
{
	public static void main(String[] args)
	{
		PrintNum pu = new PrintNum();
		
		Thread t1 = new Thread(pu);
		t1.setName("线程A");
		Thread t2 = new Thread(pu);
		t2.setName("线程B");
		
		t1.start();
		t2.start();
	}
}
class PrintNum extends Thread
{
	private int num = 1;
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		synchronized(this)  
		{
			
			for(int i=0;i<=100;i++)
			{
				System.out.println(Thread.currentThread().getName());
				notify();   //注意，这个notify()方法只能放在这里
				if(num<=100)
				{
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+num++);
					
				}
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
