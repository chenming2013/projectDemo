package com.chenming.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//测试标准的输入输出流
public class MyIODemo5
{
	public static void main(String[] args)
	{
		/*
		 * 从键盘输入字符串，要求将读取到的字符串转成大写输出，然后继续进行输入操作，
		 * 直至当输入“e”或者“exit”时，退出执行。
		 */
		BufferedReader br = null;
		try
		{
			InputStream is = System.in;  //从接盘输入字节
			InputStreamReader isr = new InputStreamReader(is);   //转换流，将字节转换成字符
			br = new BufferedReader(isr);
			String str = null;
			while(true)
			{
				System.out.println("请输入字符串：");
				str = br.readLine();
				if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit"))
				{
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br!=null)
				{
					br.close();
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
