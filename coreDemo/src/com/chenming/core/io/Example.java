package com.chenming.core.io;

import java.io.File;
import java.util.ArrayList;

//迭代一个目录，并把目录结构按层次显示
public class Example
{
	public static void main(String[] args)
	{
		IteratorUtil.iteratorDir(new File("d:\\360Downloads"));
	}
}
class IteratorUtil
{
	private static int level = 0;  //层级数
	public static void iteratorDir(File file)
	{
		if(file!=null)
		{
			//找出递归的出口
			//如果是文件或者是空文件夹，就返回
			if(file.isFile() || file.listFiles().length==0)
				return;
			else
			{
				File[] files = file.listFiles();
				//要求是先输出文件夹，再输出文件
				files = sort(files);  //将没有排序的数组进行先文件夹，再文件的排序
				for(File f:files)
				{
					//这是一个动态字符串
					StringBuilder sb = new StringBuilder();
					if(f.isFile())
					{
						sb.append(getTab(level));
						sb.append(f.getName());
					}
					else
					{
						sb.append(getTab(level));
						sb.append(f.getName());
						sb.append("\\");
					}
					System.out.println(sb.toString());
					//如果是文件夹
					if(f.isDirectory())
					{
						level++;  //进入目录遍历，层级加1
						//递归遍历
						iteratorDir(f);
						level--;  //目录层级减1，返回上一级目录，继续打印输出。
					}
				}
				
			}
		}
	}
	//定义一个方法，作用是将File类型的数组进行先文件夹，再文件的存放
	private static File[] sort(File[] files)
	{
		ArrayList<File> flist = new ArrayList<File>();
		//通过这两个循环，就实现了先存放文件夹，再存放文件
		for(File f:files)
		{
			if(f.isDirectory())
			{
				flist.add(f);
			}
		}
		for(File f:files)
		{
			if(f.isFile())
			{
				flist.add(f);
			}
		}
		//将ArrayList容器转化为File[]
		return flist.toArray(new File[flist.size()]);
	}
	//根据层级数来得到制表符的个数
	private static String getTab(int level)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<level;i++)
		{
			sb.append("\t");
		}
		return sb.toString();
	}
}