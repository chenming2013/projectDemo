package com.chenming.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//使用字节流来赋值文件夹中的所有内容
public class Example2
{
	public static void main(String[] args)
	{
		copyDirUtil.copyDir(new File("d:\\KuGou"), new File("e:\\codeTest\\KuGou"));
		System.out.println("拷贝成功！");
	}
}
class copyDirUtil
{
	public static void copyDir(File src,File target)
	{
		target.mkdirs();  //创建目标文件夹
		
		if(src!=null)
		{
			File[] files = src.listFiles();  //遍历源文件夹中所有的问价或目录
			if(files!=null)
			{
				for(File f:files)
				{
					if(f.isFile())
					{
						//复制文件
						try
						{
							FileInputStream fis = new FileInputStream(f);
							FileOutputStream fos = new FileOutputStream(target.getAbsolutePath()+"\\"+f.getName());
							byte[] buf = new byte[1024*1024];
							int len = 0;//保存的是读到的字节数
							while((len=fis.read(buf))!=-1)
							{
								fos.write(buf,0,len);
							}
							
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						copyDir(f,new File(target.getAbsolutePath()+"\\"+f.getName()));
					}
				}
			}
		}
	}
}