package com.chenming.core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyIODemo2
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File("f:\\tempDirectory\\IOTest\\MyIODemo2.txt");
	//		System.out.println(file.getParentFile().mkdirs());   //true  说明IOTest目录已经存在，
			if(!file.getParentFile().exists())
			{
				file.getParentFile().mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(file);
//			byte[] data = "戍鼓断人行，边秋一雁声。露从今夜白，月是故乡明。有弟皆分散，无家问死生。寄书长不达，况乃未休兵。\n"
//					.getBytes();
//			byte[] data = "从前幽怨应无数，铁马金戈，青冢黄昏路。一往情深深几许，深山夕照深秋雨。".getBytes();
			byte[] data = new byte[10];
			data = "凤凰台上凤凰游，凤去台空江自流。".getBytes();
			fos.write(data);
			fos.close();
			System.out.println(file.length());
			/*
			 * 注意：
			 * 	1.构造方法 public OutputStream(File file)与public OutputStream(File file,boolean false)的功能是一样的，
			 *    它们都是从文件开始出处写入，也就是说，是将原文件覆盖了。 
			 *    即便第二次写入的数据字节数比第一次写入少，保存的也是第二次写入的数据，不会有第一次写入数据的残留
			 *  2.构造方法 public OutputStream(File file,boolean true)是在文件的末尾处开始写入数据，也就是说是追加数据。
			 *  
			 */
			
			
			
			
			File file2 = new File("f:\\tempDirectory\\IOTest\\MyIODemo2.txt");
			FileOutputStream fos2 = new FileOutputStream(file2);
			byte[] data2 = new byte[1024];
			data2 = "从前幽怨应无数，铁马金戈，青冢黄昏路。一往情深深几许，深山夕照深秋雨。".getBytes();
			fos2.write(97);
//			fos2.write(data2);
//			fos2.write(data2,2,10);
			fos2.close();
			System.out.println(file2.length());
			/*
			 * 注意：
			 * 	1.write(int b):将指定字节写入输入流。
			 *  2.write(byte[] b):将 b.length 个字节从指定 byte 数组写入此文件输出流中。
			 *  3.write(byte[] b,int off,int len):将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流
			 */
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
