package com.chenming.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//测试缓冲流
public class MyIODemo4
{
	public static void main(String[] args)
	{
		BufferedReader br = null;
		try
		{
			File file = new File("e:\\codeTest\\test\\IOTest3.txt");
			FileReader fr = new FileReader(file);  //字符输入流
			br = new BufferedReader(fr);
			char[] ch = new char[2];
			int len = 0;
			while((len=br.read(ch))!=-1)  
			{
				System.out.println(new String(ch,0,len));
			}
			
			/* 
			 * 问题：BufferedReader自带有一个指定大小的char[]数组，那么还要定义char[] ch = new char[2]干什么？
			 * 解答：定义char[] ch = new char[2]是指每次从FileReader流中读取到缓冲区中的字符的个数。
			 */
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
}
