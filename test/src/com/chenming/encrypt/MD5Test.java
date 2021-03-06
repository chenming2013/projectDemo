package com.chenming.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Test;

/**
 * 测试MD加密算法
 * 	MD加密算法是单向加密算法,是基于散列函数的
 * @author 陈明
 * @date 2018年12月24日
 */
public class MD5Test {
	/**
	 * 测试Java自带的MD2算法
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testMD2() throws NoSuchAlgorithmException {
		//获取MD2算符对象
		MessageDigest messageDigest = MessageDigest.getInstance("MD2");
		
		//对"abc"字符进行MD2加密,得到byte数组,128位,16字节
		byte[] digest1 = messageDigest.digest("abc".getBytes());
		
		System.out.println(Arrays.toString(digest1));		//[-38, -123, 59, 13, 63, -120, -39, -101, 48, 40, 58, 105, -26, -34, -42, -69]
		System.out.println(new HexBinaryAdapter().marshal(digest1));	//DA853B0D3F88D99B30283A69E6DED6BB
		
	}
	
	/**
	 * 测试Java自带的MD5算法
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testMD5() throws NoSuchAlgorithmException {
		//获取MD5算符对象
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		
		//对"abc"字符进行MD5加密,得到byte数组,128位,16字节
		byte[] digest = messageDigest.digest("abc".getBytes());
		
		System.out.println(Arrays.toString(digest));		//[-112, 1, 80, -104, 60, -46, 79, -80, -42, -106, 63, 125, 40, -31, 127, 114]
		System.out.println(new HexBinaryAdapter().marshal(digest));		//900150983CD24FB0D6963F7D28E17F72
		
		/**
		 * 注意:	
		 * 	byte为-112 转换为 16进制 就是 90
		 */
	}
	
	
}
