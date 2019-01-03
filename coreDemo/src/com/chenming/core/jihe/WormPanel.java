package com.chenming.core.jihe;

public class WormPanel
{
	Worm worm = new Worm();
	public Worm getWorm()
	{
		return this.worm;
	}
	public void print()
	{
		for(int i=0;i<=10;i++)
		{
			for(int j=0;j<=32;j++)
			{
				if(i==0 || i==10)
				{
					System.out.print("-");
				}
				else if(j==0 || j==32)
				{
					System.out.print("|");
				}
				else if(worm.contains(new Point(i,j)))
				{
					System.out.print("#");
				}
				else 
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
