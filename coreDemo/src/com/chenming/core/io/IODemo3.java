package com.chenming.core.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//将一个文件从磁盘中一个目录拷贝到另一个目录，并且为其指定文件名
//本程序是将e:\word.txt文件拷贝到e:\codeTest目录下，并且重命名为iotest.txt
public class IODemo3
{
	public static void main(String[] args)
	{
		FileCopyUtil.copyFile(new File("e:\\word.txt"), new File("e:\\codeTest\\iotest.txt"));
		System.out.println("文件拷贝成功！");
	}
}
class FileCopyUtil
{
	//定义方法，将file文件拷贝到指定目录下
	public static void copyFile(File file,File target)
	{
		try
		{	
			//创建内存与源文件之间的输入流，读取源文件中的数据
			FileInputStream fis = new FileInputStream(file);
			//创建内存与目标文件之间的输出流
			FileOutputStream fos = new FileOutputStream(target);
			int data = -1;
			long time1 = System.currentTimeMillis();			
			while( (data = fis.read())!=-1 )   //public int read() throws IOException  //读取流之中的一个个字节
			{
				fos.write(data);
			}
			fis.close();
			fos.close();
			long time2 = System.currentTimeMillis();
			System.out.println("执行一个一个字节读入需要的时间是："+(time2-time1)+"毫秒");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//由于本程序中的word.txt所占空间只有100多字节，大小很小，所以本程序的执行速度很快，但是如果换了一个几M的文件，那么本程序的运行速度就会很慢，
	//究其原因是因为，我们这里是一个一个字节读取，然后一个一个字节写入到磁盘中的另一个目录下，所以很慢，那么有没有什么办法能够让它快速的执行呢？
	//此时我们可以将读入的字节存入缓存中，当指定分配的缓存空间满了之后，再将整个缓存空间的内容写到目标文件中。
	//详细用法观察 IODemo4.java
}
