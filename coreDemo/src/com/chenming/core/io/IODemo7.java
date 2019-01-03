package com.chenming.core.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//测试DataInputStream、DataOutputStream
//DataInputStream、DataOutputStream是专门对基本数据类型以及String类型的数据来进行操作的
//也就是说，当读取一个数据的时候，不必再关心这个数值应当是哪种字节。
public class IODemo7
{
	public static void main(String[] args)
	{
		File file;
		try
		{
			file = new File("f:\\tempDirectory\\IOTest\\codeTest\\God is a girl 2.mp3");
			if(!file.exists())
			{
				file.getParentFile().mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(file);
			
			//将基本数据类型以及String类型数据写入指定文件中
			String str = "chenming";
			int age = 22;
			char sex = '男';
			boolean flag = true;
			long id = 20130530819L;
			
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF(str);
			dos.writeInt(age);
			dos.writeChar(sex);
			dos.writeBoolean(flag);
			dos.writeLong(id);
			fos.close();
			dos.close();
			System.out.println("数据已写入磁盘文件！");
			
			
			//上面已经将数据写入磁盘文件了，下面就是将文件读出
			FileInputStream fis = new FileInputStream("e:\\codeTest\\DataIOTest.txt");
			DataInputStream dis = new DataInputStream(fis);
			//注意：读取的顺序必须和存入的顺序一致
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readLong());
			fis.close();
			dos.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
