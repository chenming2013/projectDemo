package com.chenming.core.thread;

//编程：
//某银行账户上有500元现金，一个人拿着存折去取钱，同时另一个人拿着卡去ATM上取钱，都想取400
//要求取钱过程中不能出现资源竞争：比如400元被取出两次，银行卡的账目不能小于0

//在MultiThreadDemo4_1.java 中，出现了两个线程各取400的情况，而出现这样问题的解决办法就是让两个线程同步，即只有一个线程执行完了，另一个线程才能开始执行。
public class MultiThreadDemo4_2
{
	public static void main(String[] args)
	{
		Bank2 bank = new Bank2();
		//产生两个线程类对象
		BankThread2 bk1 = new BankThread2(bank);
		BankThread2 bk2 = new BankThread2(bank);
		
		bk1.start();  //柜台取钱
		bk2.start();  //ATM取钱
		
	}
}
//定义一个线程类
class BankThread2 extends Thread
{
	private Bank2 bank = null;  //
	public BankThread2(Bank2 bank)
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

class Bank2
{
	private int money = 500;  //共享的资源
	//定义一个取钱的方法
	//实现线程同步两种方法：
	//1.将方法用synchronize关键字声明为同步  --->当一个线程去调用同步方法的时候，这个线程就获得了当前对象的锁 ，其它线程调用同步方法的时候只能等待 
	//2.将代码用关键字synchronize声明为同步
	public /*synchronized*/ int getMoney(int num)   
	{                           //参数传入要取的数量
		synchronized (this)  //每个对象都有一个锁，传入的参数是要锁的对象，这里 “this”代表本类对象，即Bank2的对象 
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
		}
		return num;
	}
}
