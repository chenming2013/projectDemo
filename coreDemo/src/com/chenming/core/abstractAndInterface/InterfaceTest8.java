package com.chenming.core.abstractAndInterface;

public class InterfaceTest8
{
	public static void main(String[] args)
	{
		Computer cp = new Computer();
		cp.plugin(new UPan());  //把U盘插入电脑
		cp.plugin(new Printer());  //把打印机插入电脑
	}
}
//定义接口USB，就是定义一个标准，接口能够实现不同层之间的操作
interface USB
{//接口中定义两个抽象方法
	public void start();
	public void stop();
}
class Computer
{
	public void plugin(USB usb)
	{
		usb.start();
		usb.stop();
	}
}
class UPan implements USB  //按照接口USB定义的标准来实现U盘UPan
{
	public void start()
	{
		System.out.println("U盘开始使用");
	}
	public void stop()
	{
		System.out.println("U盘停止使用");
	}
}
class Printer implements USB  //按照接口USB定义的标准来实现打印机Printer
{
	public void start()
	{
		System.out.println("打印接开始使用");
	}
	public void stop()
	{
		System.out.println("打印机停止使用");
	}
}