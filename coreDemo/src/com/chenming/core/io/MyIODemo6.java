package com.chenming.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
//测试打印流
public class MyIODemo6
{
	public static void main(String[] args)
	{
		//创建字节打印输出流，设置为自动刷新模式(写入换行符或字节‘\n’时都会刷新输出缓冲区)
		PrintStream ps = null;
		try
		{
			File file = new File("e:\\codeTest\\test\\MyIODemo6.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ps = new PrintStream(fos,true);
			if(ps!=null)
			{
				System.setOut(ps);  //把标准输出流(控制台输出)改成向指定文件(MyIODemo6.txt)中输出
			}
			for(int i=0;i<=255;i++)
			{
				System.out.print((char)i);
				if(i%50==0)
				{
					System.out.println();
				}
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ps.close();			
		}
		
	}
}
