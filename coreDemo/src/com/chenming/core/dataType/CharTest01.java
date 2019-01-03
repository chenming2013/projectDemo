package com.chenming.core.dataType;

/**
 * 测试char类型
 * @author Lenovo
 *
 *	char是取值范围是0~65534,包含了全部的ASCII码以及部分的Unicode码
 */
public class CharTest01
{
	public static void main(String[] args)
	{
		char ch = 65;
		System.out.println("ch="+ch);  //ch=A,在Unicode码中65代表的就是字符'A'
		
		char ch2 = 'a';
		System.out.println("ch2="+(int)ch2);  //字符'a'在Unicode码中是97
		
		char ch3 = '尚';
		System.out.println("ch3="+(int)ch3);  //字符'尚'在Unicode码中是23578
		
		char ch4 = '\u1234';  //十六进制 ：\u1234
		System.out.println("ch4="+(int)ch4); //十进制：4660
		System.out.println("ch4="+ch4);  //在unicode表中代表的字符：ch4=ሴ
		
		
		
	}
}
