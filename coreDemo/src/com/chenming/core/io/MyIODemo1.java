package com.chenming.core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyIODemo1
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File("f:\\tempDirectory\\IOTest\\codeTest\\EditPlus\\IO\\1.txt");
			if(!file.getParentFile().exists())
			{
				file.getParentFile().mkdirs();  
				//file.mkdirs();
			}
			/*
			注意：
				1.file.getParentFile().mkdirs()与file.mkdirs()的区别？
				  file.getParentFile().mkdirs()是创建指定路径的父目录，即创建出来的目录是f:\\tempDirectory\\IOTest\\codeTest\\EditPlus\\IO\\，那么就会将1.txt当成文件，那么之后输出流的数据就会写入1.txt文件中。
				  file.mkdirs()是创建指定路径的目录，即创建出来的目录是f:\\tempDirectory\\IOTest\\codeTest\\EditPlus\\IO\\1.txt，此时的1.txt也被当成是一个目录，所以之后若是想将输出流的数据写入就会出错，因为它没有文件可写入。
			*/
			FileOutputStream fos = new FileOutputStream(file);
			String str = "今古山河无定据，画角声中，牧马频来去！";
			byte[] data = str.getBytes();
			fos.write(data);
			fos.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
