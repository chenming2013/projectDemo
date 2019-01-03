package com.chenming.core.thread;

public class MultiThreadDemo1_3
{
	public static void main(String[] args)
	{
		SubThread st = new SubThread();
		st.start();   //这是子线程
		
		//这是main()方法中的线程，是主线程
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i);
			//测试yield()方法：
//			if(i%10==0)
//			Thread.currentThread().yield();  
//		//yield():调用此方法的线程释放当前CPU的执行权
//		//当i=10、20、30...的时候，主方法执行yield()方法，此时主方法会释放CPU的执行权，但是释放之后，有可能是被子线程抢到CPU资源，也有可能仍然是被主线程抢到CPU资源。
//		//所以最后的执行结果多种多样。
			
			
//			//测试join()方法
//			if(i==20)
//				try
//				{
//					st.join();
//				} catch (InterruptedException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			//join():在A线程中调用B线程的join()方法，表示当执行到此方法的时候，A线程停止执行，直至B线程执行完毕，A线程再接着join()之后的代码执行。
			
		}
		System.out.println(st.isAlive());
	}
}
class SubThread extends Thread
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}