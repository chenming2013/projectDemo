package com.chenming.core.thread;

//编程：
//某银行账户上有500元现金，一个人拿着存折去取钱，同时另一个人拿着卡去ATM上取钱，都想取400
//要求取钱过程中不能出现资源竞争：比如400元被取出两次，银行卡的账目不能小于0
public class MultiThreadDemo4_1
{
	public static void main(String[] args)
	{
		Bank bank = new Bank();
		//产生两个线程类对象
		BankThread bk1 = new BankThread(bank);
		BankThread bk2 = new BankThread(bank);
		
		bk1.start();  //柜台取钱
		bk2.start();  //ATM取钱
		//因为根据抢占的资源情况不同，所以会有多个结果，但我们会发现一共出现了两次 “取钱金额：400”，这也就是说总共取了800块钱，这与实际情况肯定不相符
		//那么为什么会出现这样的情况呢？我们不是创建了两个线程同时执行一个资源吗？为什么还会出现这样的问题？
		/*
		 * 解答：
		 * 1.首先明确，这的确是创建了两个线程，两个线程共同抢占一个资源，在一个线程抢占到资源的时候，另一个线程只能等待，这个思想并没有错。
		 * 2.造成这种结果的原因是Thread.sleep()；当线程bk1抢占到了资源，并起执行了run()方法，由run()方法调用getMoney()方法，当线程执行到Thread.sleep（1000）的时候，bk1就会被置入阻塞集中，此时bk1就会释放资源。
		 *   bk1释放了资源，线程bk2机会抢占到资源，执行与bk1相同的步骤，当执行到Thread.sleep（1000）的时候，同样会被置入阻塞集中，释放资源。而此时的bk1已经超时自动苏醒，再次抢占到资源，继续向下执行。
		 * 3.这样不等bk1取完钱更新判断条件money，bk2就已经进来了，所以不bk2的判断条件仍是money<500;
		 * 4.这样就造成了这种结果。
		 * 
		 * 那有什么方法能够解决这种问题呢？
		 * 1、将money -= num; 移到Thread.sleep(1000)的前面。--->但是按照实际情况，我们一般是要先等待，然后才有钱出来，所以这种方法不可取
		 * 2、将getMoney()方法或方法中的执行代码声明成synchronize同步，只能是一个线程结束，第二个线程才能开始。
		 *    具体做法参考 MultiThreadDemo4_2.java
		 */
	}
}
//定义一个线程类
class BankThread extends Thread
{
	private Bank bank = null;  //
	public BankThread(Bank bank)
	{
		this.bank = bank;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("取钱金额："+bank.getMoney(400));
	}
}

class Bank
{
	private int money = 500;
	//定义一个取钱的方法
	public int getMoney(int num)  //参数传入要取的数量
	{
		if(num<0)
			return -1;
		else if(money<0)
			return -2;
		else if(num>money)
			return -3;
		else
		{
			try
			{
				Thread.sleep(1000);   //模拟取钱时的等待时间
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//等待完之后就能取钱了
			money -= num;  //账户余额      //money在sleep之后就造成了问题
			System.out.println("账户余额："+money);
		}
		return num;
	}
}
