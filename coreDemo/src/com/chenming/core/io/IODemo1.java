package com.chenming.core.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

//测试File类常用方法
public class IODemo1
{
	public static void main(String[] args)
	{
		//根据指定路径名来创建一个File对象
		File file = new File("f:\\MyEclipse\\MyEclipse 10\\WorkSpace");   //注意：这里是用两个“\”或者一个“/”   “\\”表示的是绝对路径
		//判断这个文件或目录是否存在
		System.out.println(file.exists());  //true，说明这个文件或者目录存在
		//判断这个已经存在的file到底是文件还是目录
		System.out.println(file.isFile());   //false，说明这个file对象不是一个文件
		//验证这个已经存在的不是文件的file对象是目录
		System.out.println(file.isDirectory());  //true,说明这个file对象是一个目录
		//获取这个目录的完整路径
		System.out.println(file.getAbsolutePath());   //f:\MyEclipse\MyEclipse 10\WorkSpace  要说明一点，我们在创建file对象的时候的路径是要用两个“\”
		//获取file对象的父目录,也就是上一级目录，并不是根目录  
		System.out.println(file.getParent());   //f:\MyEclipse\MyEclipse 10
		//获取file对象的长度大小
		System.out.println(file.length());   //4096   length()方法：返回路径名表示的文件的长度。如果此路径名表示一个目录，则返回值是不确定的

/*		
		File file2 = new File("d:\\BugReport.txt");   //注意：如果路径是一个文件的话，那么是要包括后缀名的。
		System.out.println(file2.exists());
		System.out.println(file2.length());   //18 字节
*/
		
		System.out.println("=======================分割符====================");
		
	//	delete():删除文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除
		File file2 = new File("f:\\tempDirectory\\IOTest");
		//判断 F:\tempDirectory\IOTest 盘下是否有zhangsan这个文件或目录
		System.out.println(file2.exists());  //false，说明这个文件或者目录不存在，那么我们就可以创建一个目录了
		//创建路径名指定的目录，即 F:\tempDirectory\IOTest
		System.out.println(file2.mkdir());  //true，注意：因为目录、文件名不能相同，所以如果是第一次创建zhangsan这个目录，那么返回值就是true，如果已经存在zhangsan这个目录，那么返回值就是false。
		//在IOTest这个文件下创建一个文件
		File file3 = new File("f:\\tempDirectory\\IOTest\\IODemo2_1.txt");
		try
		{
			System.out.println(file3.createNewFile());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//list():查询目录下所有的目录以及文件名,
		String[] files = file.list();
		for(String str:files)
		{
			System.out.println(str);
		}
		
		System.out.println("-----------------------------------分割啦啦啦啦啦啦。。。。。。");
		
		//listFiles():返回一个路径名数组，这些路径名表示 此路径名表示的目录中的文件。即：得到的就是路径下的文件以及目录，那么就可以调用它的各种方法了。
		File[] files2 = file.listFiles();
		for(File s:files2)
		{
			System.out.println(s);
			System.out.println(s.getName()+"--"+s.length());
		}
		
		System.out.println("******************************分割********************************");
		
		//获取指定路径目录下的指定文件或文件夹
		File file4 = new File("F:\\MyEclipse\\MyEclipse 10\\WorkSpace\\study\\src\\io");
		String[] files3 = file4.list(new FilenameFilter()
		{
			//筛选所有以.java结尾的文件
			@Override
			public boolean accept(File dir, String name)
			{
				// TODO Auto-generated method stub
				return name.endsWith(".java");
			}
		});
		for(String s:files3)
		{
			System.out.println(s);
		}
		
		
	}
}
