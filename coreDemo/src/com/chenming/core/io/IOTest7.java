package com.chenming.core.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//测试BufferedReader
public class IOTest7
{
	public static void main(String[] args) throws Exception
	{
		//1.System.in是InPutStream类对象
		//2.BufferedReader的构造方法里面需要接收Reader类对象
		//3.利用InputStreamReader将字节流转化成字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数据：");
		String str = br.readLine(); //以回车作为换行
		System.out.println("输入的数据为："+str);
		
	}
}
