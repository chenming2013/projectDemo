package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//创建一个新文件，向文件中写入数据，并且读出其内容
public class IODemo2
{
	public static void main(String[] args)
	{
		File file = new File("f:\\tempDirectory\\IOTest\\codeTest\\word.txt");
		try
		{
			//打开内存与文件之间的文件输出流，并向文件之中写入数据
			FileOutputStream fos = new FileOutputStream(file);
			//向文件中写入数据
			String str = "长相思兮长相忆，短相思兮无穷极！";
			byte[]  byte1= str.getBytes();   
			//因为这个文件保存类型是gbk,所以会将一个中文字符按照两个字节来解析，所以最后的length就是32
			System.out.println("按照gbk解析的length: "+byte1.length);
			//如果我们指定解析的字符编码,就会获得不一样的结果
			System.out.println("按照utf-8解析的length: "+str.getBytes("utf-8").length);   //48
			System.out.println("按照iso-8859-1解析的length: "+str.getBytes("iso-8859-1").length);  //16
			for(byte b:byte1)
			{
				System.out.println(b);
			}
			System.out.println(byte1.length);  //32
			fos.write(byte1);
			fos.close();
			
			//打开内存与文件之间的文件输入流，读取文件中的内容
			FileInputStream fis = new FileInputStream(file);
			//创建byte[]，接受从文件中读出的字节流数据
			byte[] byte2 = new byte[1024];
			int len = fis.read(byte2);      //public int read(byte[] b) throws IOException 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。以整数形式返回实际读取的字节数
			//将字节转化为字符串输出
			System.out.println(len);
			System.out.println("文件中的信息是："+new String(byte2,0,len));
			
//			int len = 0;
//			while((len=fis.read(byte2))!=-1)
//			{
//				System.out.println(new String(byte2,0,len));
//			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
