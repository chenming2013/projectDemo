package com.chenming.core.abstractAndInterface;

public class InterfaceTest2
{

}
interface DR
{
	void smoke();
}
interface DT
{
	void draw();
}
class DY implements DR,DT  //一个类可以实现多个interface，但是必须重写实现的接口里面的全部抽象方法。
{
	public void smoke()
	{
		
	}
	public void draw()
	{
		
	}
}
