package com.chenming.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAcessFile:支持随机访问
 * 	1.既可以充当一个输入流，也可以充当一个输出流
 * 	2.支持从文件的开头读取、写入
 * 	3.支持从任意位置的读取、写入
 */
public class MyIODemo8
{
	public static void main(String[] args)
	{
		//创建连个流，一个读，一个写
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try
		{
			raf1 = new RandomAccessFile("e:\\codeTest\\test\\MyIODemo8.txt","r");
			raf2 = new RandomAccessFile("e:\\codeTest\\test\\MyIODemo8.txt","rw");
			byte[] b = new byte[2];
			int len = 0;
			while((len=raf1.read(b))!=-1)
			{
				raf2.write(b,0,len);
			}
		}catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{	
			try
			{
				if(raf2!=null)
				{
					raf2.close();
				}
				if(raf1!=null)
				{
					raf1.close();
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		//向文件中的指定位置插入数据
		RandomAccessFile raf3 = null;
		try
		{
			raf3 = new RandomAccessFile("e:\\codeTest\\test\\MyIODemo8.txt", "rw");
			//将指针从0调到指定的位置。
			raf3.seek(4);
			raf3.write("najdhid".getBytes());
		}catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{	if(raf3!=null)
			{
				try
				{
					raf3.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
