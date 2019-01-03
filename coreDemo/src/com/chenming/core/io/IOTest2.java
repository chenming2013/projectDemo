package com.chenming.core.io;

import java.io.File;
import java.io.IOException;

//创建文件
public class IOTest2
{
	public static void main(String[] args)
	{
		File file = new File("word.txt"); 
		System.out.println(file.getAbsolutePath());
		if(file.exists())
		{
			file.delete();
			System.out.println("文件已删除！");
		}
		else
		{
			try
			{
				file.createNewFile();
				System.out.println("文件已创建");  //注意创建出来的文件是在study目录下
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getParentFile());
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("==========================");
		//测试list()与listFiles()
		//列出f:\\tempDirectory\\IOTest盘下所有的目录和文件
		File file2 = new File("f:\\tempDirectory\\IOTest");
		
		String[] arr = file2.list();
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println();
		File[] files = file2.listFiles();
		for(int i=0;i<files.length;i++)
		{
			System.out.println(files[i]);
		}
	}
}
