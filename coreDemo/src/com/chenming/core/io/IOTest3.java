package com.chenming.core.io;
//读取文件中的内容
import java.io.File;
import java.io.FileInputStream;

public class IOTest3
{
	public static void main(String[] args)
	{
		File file = new File("f:\\tempDirectory\\IOTest\\MyIODemo2.txt");
		try
		{
			//打开file文件的输入流
			FileInputStream fis = new FileInputStream(file);
			byte[] byte1 = new byte[1024];
			int len = fis.read(byte1);
			System.out.println("文件中的信息是："+"\n"+new String(byte1,0,len));
			fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
