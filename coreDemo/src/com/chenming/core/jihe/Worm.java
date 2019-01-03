package com.chenming.core.jihe;

import java.util.LinkedList;

public class Worm
{
	LinkedList<Point> ledl = new LinkedList<Point>();
	public static final int UP = -10; //定义上方向
	public static final int DOWN = 10;//定义下方向
	public static final int LEFT = -1; //定义左方向
	public static final int RIGHT = 1; //定义右方向
	private int dir; //存储当前方向
	
	public Worm()
	{
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,0);
		Point p3 = new Point(2,0);
		Point p4 = new Point(2,1);
		Point p5 = new Point(2,2);
		Point p6 = new Point(2,3);
		Point p7 = new Point(3,3);
		Point p8 = new Point(3,4);

		ledl.add(p1);
		ledl.add(p2);
		ledl.add(p3);
		ledl.add(p4);
		ledl.add(p5);
		ledl.add(p6);
		ledl.add(p7);
		ledl.add(p8);
		
		dir = LEFT; //默认当前方向为RIGHT向右走。
	}
	
	public boolean contains(Point p)
	{
		return ledl.contains(p);
	}
	
	public void step()
	{
		Point head = ledl.getFirst();
		//去尾巴
		ledl.removeLast();
		//加头
		int x = head.getX()+dir/10;
		int y = head.getY()+dir%10;
		ledl.addFirst(new Point(x,y));
		
	}
	
/*	public void step(int dir) throws Exception
	{
		if(this.dir+dir==0)
			throw new Exception("不能往反方向");
		this.dir = dir;
		step();
	}*/
}
