package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//API上说read()返回的是0~255范围内的int字节值，
//但是byte的取值范围不是-128~127吗？
//这又是为什么？
//拿几个负数来做一下测试，看看返回的int值是什么？
public class Test1
{
	public static void main(String[] args)
	{
		//将一个负数写入文件件，然后在读取这个负数，看看read()方法返回的int字节值是多少
		try
		{
			File target = new File("e:\\codeTest\\Test1.txt");
			String str = "-6";
			byte[] buf = str.getBytes();
			FileOutputStream fos = new FileOutputStream(target);
			fos.write(buf);
			fos.close();
			System.out.println("写入成功!");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//读取文件中的负数，看看返回的int字节值的多少？      山( 23665,0000_0000_0000_0000_0101_1100_0111_0001 )---201,189
		try
		{
			FileInputStream fis = new FileInputStream("e:\\codeTest\\Test1.txt");
			byte[] buf = new byte[1];
			
			int len = 0;
			while((len=fis.read(buf))!=-1)
			{
				System.out.println(new String(buf,0,len));
			}
			fis.close();
			System.out.println("读取成功!");   //45、54
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//从这个结果可以知道，当我们输入一个负数的时候，它是将负数一个一个字节的拆解。即：“-6”变成两个字节“-”和“6”
		//而“-”的字节值就是45，“6”这个字节值就是54
		
		
	}
}
