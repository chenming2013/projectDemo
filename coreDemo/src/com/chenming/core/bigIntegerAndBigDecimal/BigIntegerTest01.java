package com.chenming.core.bigIntegerAndBigDecimal;

import java.math.BigInteger;

/**
 * 测试BigInteger
 * @author Lenovo
 *
 */
public class BigIntegerTest01
{
	public static void main(String[] args)
	{
		
		show("abcdefg");
		
		byte[] b = new byte[] {1,2,3,4,5,6,7,8,9,0};
		
		BigInteger bi = new BigInteger(b);
		
		System.out.println(bi);
	}
	
	
	public static void show(String value) 
	{
		value = value.substring(0, value.length()-2);
		
		int a = 30;
		
		System.out.println("haha");
	}
}
