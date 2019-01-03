package com.chenming.core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest4
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("f:"+File.separator+"tempDirectory"+File.separator+"IOTest"+File.separator+"demo3"+File.separator+"hello"+File.separator+"cc.txt");
		//由于以上的路径可能不存在，所以需要先创建路径
		if(!file.getParentFile().exists())
		{
			file.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(file);
		byte[] buf = "入我相思门，知我相思苦".getBytes();
		fos.write(buf);
		fos.close();
		
//		fos.write(buf,6,6);
//		fos.close();
	}
}
