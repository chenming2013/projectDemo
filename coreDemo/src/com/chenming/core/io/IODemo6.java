package com.chenming.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//测试过滤流
public class IODemo6
{
	public static void main(String[] args)
	{
		File file = new File("C:\\Users\\Lenovo\\Videos\\电子商务\\4第二章 电子商务商业模式.ppt");
		File target = new File("f:\\tempDirectory\\IOTest\\codeTest\\God is a girl 2.mp3");
		FileCopyUtil3.copyFile(file, target);
	}
}	
class FileCopyUtil3
{
	//将指定位置的文件复制到另一个目录下
	public static void copyFile(File file,File target)
	{
		try
		{
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(target);
			//对FileInputStream、FileOutputStream增加缓冲区的功能。
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int data = -1;
			long time1 = System.currentTimeMillis();
			//注意：这里的read()方法和FileInputStream的read()方法是一样的,都是一个一个字节的读取,
			//只不过FileInputStream是从文件中一个一个的读取,而BufferedInPutStream是从FileInPutStream中一个一个的读取。
			while((data=bis.read())!=-1)  
			{
				System.out.println("数据： "+data);
				bos.write(data);  //这里的write()方法是先将数据写入到缓冲区中，当缓冲区满了（也是最大是8K）之后，再一次性将缓冲区中的数据写到输出流中去。
			}
			bis.close();
			bos.close();
			long time2 = System.currentTimeMillis();
			System.out.println("复制完成，功花费"+(time2-time1)+"毫秒");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}