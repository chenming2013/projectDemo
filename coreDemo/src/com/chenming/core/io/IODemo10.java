package com.chenming.core.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//测试BufferedReader、BufferedWriter
public class IODemo10
{
	public static void main(String[] args)
	{
		File file = new File("e:\\bb.txt");
		try
		{
			FileReader fr = new FileReader(file);
			BufferedReader bd = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("e:\\codeTest\\诗句1.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line = null;
			while((line=bd.readLine())!=null)  //readLine()是读入 一行数据
			{
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
			bd.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
