package com.chenming.core.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//测试字符输入输出流拷贝文件
public class IODemo9
{
	public static void main(String[] args)
	{
		File src = new File("e:\\word.txt");
		File  target= new File("e:\\codeTest\\关山月.txt");
		try
		{
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(target);
			char[] buf = new char[1024];
			int len = 0;
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
				fw.flush();  //强制清空缓冲区，将缓冲区的数据写入到输入流中。	
			}
			fr.close();
			fw.close();
			System.out.println("文件拷贝成功！");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
