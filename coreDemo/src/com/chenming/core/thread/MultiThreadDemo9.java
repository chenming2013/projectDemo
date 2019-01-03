package com.chenming.core.thread;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

//测试线程中断
public class MultiThreadDemo9
{
	public static void main(String[] args)
	{
		InterruptedSwing.init(new InterruptedSwing(),100,100);
	}
}
class InterruptedSwing extends JFrame
{
	Thread thread;
	public InterruptedSwing()
	{
		//创建进度条
		final JProgressBar progressBar = new JProgressBar();
		//将进度条设置在窗体中的位置
		getContentPane().add(progressBar,BorderLayout.NORTH);
		//设置进度条上显示数字
		progressBar.setStringPainted(true);
		thread = new Thread(new Runnable(){
			int count = 0;
			public void run()
			{
				while(true)
				{
					progressBar.setValue(++count);  //设置进度条的当前值
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e)  //捕捉InterruptedException
					{
						System.out.println("当前线程被中断");
						break;
					}
				}
			}
		});
		thread.start();
		thread.interrupt();
	}
	public static void init(JFrame frame,int width,int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
}