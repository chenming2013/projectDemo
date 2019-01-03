package com.chenming.core.jihe;


//这段代码模拟简单的贪吃蛇移动、吃食
public class LinkedListDemo2
{
	public static void main(String[] args)
	{
		WormPanel wp = new WormPanel();
		wp.print();
		Worm worm = wp.getWorm();
		//走十次
		for(int k=0;k<10;k++)
		{
			wp.print();
			worm.step();
			try
			{
				Thread.sleep(1000); //每移动一次就睡一定的时间
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
}


