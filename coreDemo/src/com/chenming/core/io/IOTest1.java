package com.chenming.core.io;

import java.io.File;
import java.io.IOException;
//测试File类
public class IOTest1
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("f:\\tempDirectory\\IOTest\\demo\\hello.txt");  //会报错，因为f:\\tempDirectory\\IOTest下没有demo这个目录。

		//那么此时我们应该怎么做呢？
		//此时没有这个目录，那我们应该先创建demo目录
		if(!file.getParentFile().exists())    //首先判断hello.txt的父目录demo是否存在
		{
			file.getParentFile().mkdir();   //创建父路径，即demo这个目录
		}
		if(file.exists())   //在上面已经存在了demo这个父目录的前提下，我们来创建aa.txt这个文件
		{
			file.delete();
		}
		else
		{
			file.createNewFile();
		}
		
		System.out.println("==============================分割符========================");
		
		//但是上面有一个问题，mkdir()方法只能创建一级目录，也就是直接父目录，并不能创建二级甚至多级父目录，看以下的情况
		File file2 = new File("f:\\tempDirectory\\IOTest\\demo\\hello\\nihao\\bb.txt");  
		//此时bb.txt的一级目录就是nihao,二级目录就是hello,使用mkdir()只能创建出nihao这个目录，其他的目录创建不出。所以程序还是会报错。 
		//那么此时我们就要使用mkdirs()这个方法了      mkdirs():创建指定路径上存在或不存在的目录
		System.out.println(file2.getParentFile().exists());  //false
		if(!file2.getParentFile().exists())
		{
			System.out.println("fileName: "+file2.getParentFile().getName());
			file2.getParentFile().mkdirs();
		}
		if(file2.exists())
		{
			file2.delete();
		}
		else
		{
			file2.createNewFile();
		}
		System.out.println(file2.getParent());  //e:\demo2\hello\nihao
		System.out.println(file2.getName());   //bb.txt
		System.out.println(file2.getPath());    //e:\demo2\hello\nihao\bb.txt
		System.out.println(file2.getAbsolutePath());  //e:\demo2\hello\nihao\bb.txt
		System.out.println(file2.getAbsoluteFile());    //e:\demo2\hello\nihao\bb.txt
	}
}
