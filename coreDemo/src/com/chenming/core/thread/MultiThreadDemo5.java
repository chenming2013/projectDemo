package com.chenming.core.thread;

public class MultiThreadDemo5
{
	public static void main(String[] args)
	{
		Example example = new Example();
		
		DieThread1 dt1 = new DieThread1(example);
		DieThread2 dt2 = new DieThread2(example);
		dt1.start();
		dt2.start();
		/*
		 * 最后的结果会发现：死锁
		 * 解释：
		 * 1.当线程dt1抢占到CPU资源，就会执行run()方法，而run()方法又调用method1()方法，执行同步代码synchronize（obj1），此时dt1线程就获得了obj1对象的锁，
		 *   然后执行Thread.sleep（1000），此时dt1虽然会释放CPU资源，但是仍然持有obj1的锁。
		 * 2.dt1释放CPU资源，而dt2抢占到资源，就开始执行run()方法，run()方法中调用method2()方法，此时dt2线程就获得了obj2对象的锁，
		 *   然后执行Thread.sleep（1000），此时dt2虽然会释放CPU资源，但是仍然持有obj2的锁。
		 * 3.dt1超时自动苏醒，再次抢占到CPU资源，然后执行同步代码synchronize（obj2），却发现dt2把持着obj2的锁，所以无法执行同步代码块中的代码，一直在等待dt2释放obj2的锁
		 *   所以这样就产生了死锁。
		 */
	}
}
//创建线程类
class DieThread1 extends Thread
{
	Example example = null;
	public DieThread1(Example example)
	{
		this.example = example;
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		super.run();
		example.method1();
	}
}
class DieThread2 extends Thread
{
	Example example = null;
	public DieThread2(Example example)
	{
		this.example = example;
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		super.run();
		example.method2();
	}
}

class Example
{
	//每一个对象都有一个锁
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	public void method1()
	{
		synchronized (obj1)   //获取obj1对象的锁
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (obj2)  //获取了obj1对象的锁，又想获取obj2对象的锁
			{
				System.out.println("method1");
			}
		}
	}
	
	public void method2()
	{
		synchronized (obj2)   //获取obj2对象的锁
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (obj1)  //获取了obj2对象的锁，又想获取obj1对象的锁
			{
				System.out.println("method2");
			}
		}
	}
}