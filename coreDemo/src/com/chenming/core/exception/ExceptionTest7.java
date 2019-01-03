package com.chenming.core.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest7
{
	public static void main(String[] args)
	{
//		FileInputStream in = null;
//		in = new FileInputStream("myfile.txt");  //因为没有myfile.txt这个文件，所以会长生异常
//		int b;
//		b = in.read();
//		while (b != -1)
//		{
//			System.out.println((char) b);
//			b = in.read();
//		}
		/*
		 *因为上面的代码有IOException，但是IOException并不是RunTimeEXception，所以JVM并不能自动处理，所以不进行异常处理的话，就编译不过去。
		 *正确的代码如：ExceptionTest8.java 
		 */
	}
}

