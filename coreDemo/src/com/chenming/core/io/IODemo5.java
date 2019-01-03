package com.chenming.core.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

//测试ByteArrayInPutStream、ByteArrayOutPutStream
public class IODemo5
{
	public static void main(String[] args)
	{
		
//		try
//		{
//			String str = "hello world!";
//			ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
//			int len = -1;
//			内存从缓存中读取数据
//			while((len=bais.read())!=-1)  //这是一个一个字节的读取
//			{
//				System.out.println((char)len);
//			}
//			bais.close();
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try
		{
			ByteArrayOutputStream bros = new ByteArrayOutputStream(32);  //带有32字节的缓存数组的构造方法
			//由内存向缓存中写入数据
			bros.write(97);  //将97这个int型数据写入缓存中
			bros.write(65);
			bros.write("hello world".getBytes());
			//调用toString()、toByteArray()输出数据
			System.out.println(bros.toString());
			byte[] buf = bros.toByteArray();
			for(byte data:buf)
			{
				System.out.println((char)data);
			}
			
			//将缓存中的数据存入文件中
			FileOutputStream fos = new FileOutputStream("e:\\aa.txt",true);
			bros.writeTo(fos);  //吧ByteArrayOutPutStream内部缓冲区的数据写到对应的文件输出流中。
			bros.close();
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
