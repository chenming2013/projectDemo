package com.chenming.core.thread;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

//测试join()方法
//创建一个类，该实例包括两个进度条，进度条的进度由线程来控制，通过使用join()方法使上面的进度条必须等待下面的进度条完成之后才可以继续。
public class MultiThreadDemo8
{
	public static void main(String[] args)
	{
		JoinTest.init(new JoinTest(), 100,100);
	}
}
class JoinTest extends JFrame
{
	private Thread threadA;
	private Thread threadB;
	final JProgressBar progressBar = new JProgressBar();
	final JProgressBar progressBar2 = new JProgressBar();
	int count = 0;
	public JoinTest()
	{
		//将进度条设置在窗体最北面
		getContentPane().add(progressBar,BorderLayout.NORTH);
		//将进度条设置在窗体最南面
		getContentPane().add(progressBar2,BorderLayout.SOUTH);
		progressBar.setStringPainted(true);  //设置进度条显示数字字符
		progressBar2.setStringPainted(true);  //设置进度条显示数字字符
		threadA = new Thread(new Runnable(){  //匿名函数
			int count = 0;
			public void run()
			{
				while(true)
				{
					progressBar.setValue(++count);
					try
					{
						Thread.sleep(100);
						threadB.join();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		threadA.start();
		threadB = new Thread(new Runnable(){
			int count = 0;
			public void run()
			{
				while(true)
				{
					progressBar2.setValue(++count);
					try
					{
						Thread.sleep(100);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(count == 100)
						break;
				}
			}
		});
		threadB.start();
	}
	public static void init(JFrame frame,int width,int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
	
}
