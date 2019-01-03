package com.chenming.core.thread;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MultiThreadDemo10
{
	public static void main(String[] args)
	{
		PriorityTest.init(new PriorityTest(), 100, 100);
	}
}
class PriorityTest extends JFrame
{
	Thread threadA;
	Thread threadB;
	Thread threadC;
	Thread threadD;
	
	public PriorityTest()
	{
		//创建进度条
		JProgressBar progressBar = new JProgressBar();
		JProgressBar progressBar2 = new JProgressBar();
		JProgressBar progressBar3 = new JProgressBar();
		JProgressBar progressBar4 = new JProgressBar();
		//将进度条设置在窗体的合适位置
		getContentPane().add(progressBar,BorderLayout.NORTH);
		getContentPane().add(progressBar2,BorderLayout.PAGE_START);
		getContentPane().add(progressBar3,BorderLayout.CENTER);
		getContentPane().add(progressBar4,BorderLayout.SOUTH);
		//设置进度条显示数字字符
		progressBar.setStringPainted(true);
		progressBar2.setStringPainted(true);
		progressBar3.setStringPainted(true);
		progressBar4.setStringPainted(true);
		int count = 0;
		//分别实例化四个线程
		threadA = new Thread(new MyThread(progressBar));
		threadB = new Thread(new MyThread(progressBar2));
		threadC = new Thread(new MyThread(progressBar3));
		threadD = new Thread(new MyThread(progressBar4));
		setPriority("threadA",5,threadA);
		setPriority("threadB",5,threadB);
		setPriority("threadC",2,threadC);
		setPriority("threadD",1,threadD);
	}

	private void setPriority(String threadName,int priority,Thread t)
	{
		// TODO Auto-generated method stub
		t.setPriority(priority);
		t.setName(threadName);
		t.start();
	}
	private final class MyThread implements Runnable
	{
		int count = 0;
		private final JProgressBar bar;
		public MyThread(JProgressBar bar)
		{
			this.bar = bar;
		}
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			while(true)
			{
				bar.setValue(count+=10);
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					System.out.println("当前线程被中断！");
				}
			}
		}
		
	}
	public static void init(JFrame frame,int width,int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
}
