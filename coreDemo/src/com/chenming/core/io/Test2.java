package com.chenming.core.io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test2
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("e:\\codeTest\\Test2.txt");
		FileReader fr = new FileReader(file);
		int len = fr.read();
		System.out.println((char) len);
		fr.close();
		
		
		File file2 = new File("e:\\codeTest\\hello\\nihao");
		if(!file2.exists())
		{
			file2.mkdirs();
		}
		file2.delete();    //nihao这个目录被删除了
		
		byte[] data = new byte[1];
		String str = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
		data = str.getBytes();
		System.out.println(data.length);   //52
		
		
		long start = System.currentTimeMillis();
		File file3 = new File("e:\\codeTest\\Test2_2.txt");
		FileOutputStream fos3 = new FileOutputStream(file3);
		byte[] data3 = new byte[5];
		String str3 = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
		data3 = str3.getBytes();
		fos3.write(data3);
		fos3.close();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
	}
}
