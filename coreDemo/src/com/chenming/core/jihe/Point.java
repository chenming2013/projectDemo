package com.chenming.core.jihe;

public class Point 
{
	private int x;
	private int y;
	//构造方法
	public Point()
	{
		
	}
	public Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	//setter、getter方法
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return this.x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return this.y;
	}
	//重写toString()方法
	public String toString()
	{
		return "(" + this.x + "," + this.y + ")";
	}
	//重写equals()方法
	
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		Point p = (Point)obj;
		if(this.x!=p.x)
			return false;
		if(this.y!=p.y)
			return false;
		return true;
			
	}
	
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
}