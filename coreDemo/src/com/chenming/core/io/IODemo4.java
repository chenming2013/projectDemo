package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//在IODemo3.java中，我们已经知道一个一个字节的读写，效率很慢，而我们用缓存的话就会快很多。
//测试缓存读写数据
public class IODemo4
{
	public static void main(String[] args)
	{
		FileCopyUtil2.FileCopy(new File("d:\\KuGou\\Groove Coverage - God is a Girl.mp3"), new File("e:\\codeTest\\God is a girl.mp3"));
		System.out.println("拷贝成功！");
	}
}
class FileCopyUtil2
{
	public static void FileCopy(File file,File target)
	{
		try
		{
			FileInputStream fis = new FileInputStream(file);
			System.out.println(file.length());
			FileOutputStream fos = new FileOutputStream(target);
			long time1 = System.currentTimeMillis();
			byte[] buf = new byte[(int) file.length()];  //声明一个固定大小的字节数组 ,用于存放输入流读取到的字节，这就相当于是一个缓存区了，我这里声明的byte数组大小正好是file文件的长度
			//public int read(byte[] b) throws IOException 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。以整数形式返回实际读取的字节数
	/*		int len = -1;
			
			while((len=fis.read(buf))!=-1)   
			{
				fos.write(buf,0,len);
			}*/
			int len = fis.read(buf);
			System.out.println(len);
			fos.write(buf, 0, len);
			fis.close();
			fos.close();
			long time2 = System.currentTimeMillis();
			System.out.println("使用缓存需要的时间是："+(time2-time1)+"毫秒");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
