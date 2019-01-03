package com.chenming.encrypt;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Test;

/**
 * 测试Base64加密
 * 	严格来说,Base64不算是一种加密方式,它是一种编码方式
 * @author 陈明
 * @date 2019年1月2日
 */
public class Base64Test {

	/**
	 * Base64加密
	 */
	@Test
	public void testBase64Encode() {
		Encoder encoder = Base64.getEncoder();
		
		String str = encoder.encodeToString("hello world".getBytes());
		System.out.println(str);		//aGVsbG8gd29ybGQ=
	}
	
	/**
	 * Base64解密
	 */
	@Test
	public void testBase64Decode() {
		Decoder decoder = Base64.getDecoder();

		String str = new String(decoder.decode("aGVsbG8gd29ybGQ="));
		System.out.println(str);	//hello world
	}
	
}
