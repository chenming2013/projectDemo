package com.chenming.base64;

import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * 测试Base64编码
 * @author 陈明
 * @date 2018年12月22日
 */
public class Base64EncodeTest {

	public static void main(String[] args) {
		Encoder encoder = Base64.getEncoder();
		
		encoder.encodeToString("一".getBytes());		
		//5LiA(Base64编码之后)	=> 	57-11-34-0(Base64编码之前)
									
		/**
		* 原理解释:
		* 	1. 	"一".getBytes(); 是以UTF-8编码方式对中文字符"一"进行编码
		* 	2.	"一"的Unicode码十六进制是 "\u4E00",二进制码是 "01001110-00000000"
		* 	3.	"一"经过UTF-8编码之后的二进制码是 "11100100	-10111000-10000000"
		* 	4.	以上的只是 "一".getBytes(); 的解析步骤,下面来解析 Base64.encode();
		* 	5.	对UTF-8编码之后的二进制码按照Base64的规则进行编码
		* 	6. 	"11100100-10111000-10000000" ===(Base64编码规则)===>"111001-001011-100010-000000"
		* 	7.	"111001-001011-100010-000000" 对应的十进制分别是 "57"、"11"、"34"、"0"
		* 	8.	按照Base64码表,57对应"5",11对应"L",34对应"i",0对应A
		* 	9. 	所以,中文字符"一"Base64编码之后的字符为"5LiA"
		*/
	}
	
}
