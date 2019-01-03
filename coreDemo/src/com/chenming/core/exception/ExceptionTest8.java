package com.chenming.core.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest8
{
	public static void main(String[] args)
	{
		FileInputStream in = null;
		try
		{
			in = new FileInputStream("myfile.txt");
			int b;
			b = in.read();
			while(b!=-1)
			{
				System.out.println( (char)b );
				b = in.read();
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

