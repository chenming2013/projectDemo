package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//helloworld hellojava hellophp hellomen
public class IOTest5
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("F:\\tempDirectory\\IOTest\\IODemo2_1.txt");
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		while((len=fis.read())!=-1)
		{
			
			System.out.println(len);
		}
		fis.close();
	}
}
