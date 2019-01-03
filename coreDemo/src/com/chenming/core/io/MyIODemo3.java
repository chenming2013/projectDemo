package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
//测试转换流
public class MyIODemo3
{
	public static void main(String[] args)
	{
		/*
		 * 转换流：InPutStreamReader、OutPutStreamWriter
		 * 编码：字符串---->字节数组
		 * 解码：字节数组--->字符串
		 */
		InputStreamReader isr = null;
		try
		{
			File file = new File("e:\\codeTest\\test\\IOTest3.txt");
			FileInputStream fis = new FileInputStream(file);
			isr = new InputStreamReader(fis,"GBK"); //注意：这里最好指定中文的编码格式GBK
			int len = 0;
			char[] ch = new char[2];   //注意：这里是char[]数组了，不是byte[]数组了。
			while((len=isr.read(ch))!=-1)
			{
				System.out.print(new String(ch,0,len));
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
				if(isr!=null)
				{
					isr.close();
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
