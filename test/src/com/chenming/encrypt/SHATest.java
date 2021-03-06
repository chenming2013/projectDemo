package com.chenming.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Test;

/**
 * 测试SHA加密算法
 * 	SHA加密算法是单向的,是基于散列函数的
 * @author 陈明
 * @date 2018年12月24日
 */
public class SHATest {
	
	/**
	 * 测试Java自带的SHA(SHA-1)算法,默认是160位
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testSHA() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		
		byte[] digest = messageDigest.digest("abc".getBytes());
		System.out.println(new String(digest));
		System.out.println(Arrays.toString(digest));	//[-87, -103, 62, 54, 71, 6, -127, 106, -70, 62, 37, 113, 120, 80, -62, 108, -100, -48, -40, -99]
		System.out.println(new HexBinaryAdapter().marshal(digest));	//A9993E364706816ABA3E25717850C26C9CD0D89D
	}
	
	
	/**
	 * 测试Java自带的SHA-256算法,即生成256位
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testSHA256() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		
		//256位bit,64byte
		byte[] digest = messageDigest.digest("abc".getBytes());
		
		System.out.println(Arrays.toString(digest));
		System.out.println(new HexBinaryAdapter().marshal(digest));	
		//BA7816BF8F01CFEA414140DE5DAE2223B00361A396177A9CB410FF61F20015AD
	}
	
	
	/**
	 * 测试Java自带的SHA-384算法,即生成384位
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testSHA384() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
		
		byte[] digest = messageDigest.digest("abc".getBytes());
		
		System.out.println(Arrays.toString(digest));
		System.out.println(new HexBinaryAdapter().marshal(digest));
		//CB00753F45A35E8BB5A03D699AC65007272C32AB0EDED1631A8B605A43FF5BED8086072BA1E7CC2358BAECA134C825A7
	}
	
	
	/**
	 * 测试Java自带的SHA-512算法,即生成512位
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testSHA512() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		
		byte[] digest = messageDigest.digest("abc".getBytes());
		
		System.out.println(Arrays.toString(digest));
		System.out.println(new HexBinaryAdapter().marshal(digest));
		//DDAF35A193617ABACC417349AE20413112E6FA4E89A97EA20A9EEEE64B55D39A2192992A274FC1A836BA3C23A3FEEBBD454D4423643CE80E2A9AC94FA54CA49F
	}
}
