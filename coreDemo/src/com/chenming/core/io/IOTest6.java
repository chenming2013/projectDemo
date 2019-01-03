package com.chenming.core.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class IOTest6
{
	public static void main(String[] args) throws Exception
	{
		PrintStream ps = new PrintStream(new FileOutputStream("e:\\codeTest\\printStream.txt"));
		ps.print("hello");
		ps.println("world");
		ps.println(true);
		ps.println(22);
		ps.println(2016.08); 
		ps.println('男');
		ps.close();
	}
}
