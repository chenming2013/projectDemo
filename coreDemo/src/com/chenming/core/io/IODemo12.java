package com.chenming.core.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//测试InputStreamReader、OutputStreamWriter
public class IODemo12
{
	public static void main(String[] args) throws IOException
	{
//		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("e:\\codeTest\\StreamWriter.txt"),"UTF-8");
//		BufferedWriter bw = new BufferedWriter(osw);
//		bw.write("你好！");
//		bw.close();
//		osw.close();
		
//		BufferedReader br = new BufferedReader(new FileReader("e:\\codeTest\\StreamWriter.txt"));
//		String line = null;
//		while((line=br.readLine())!=null)
//		{
//			System.out.println(line);
//		}
//		br.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("e:\\codeTest\\StreamWriter.txt"),"utf-8"));
		String line = null;
		while((line=br.readLine())!=null)
		{
			System.out.println(line);
		}
		br.close();
	}
	
}
