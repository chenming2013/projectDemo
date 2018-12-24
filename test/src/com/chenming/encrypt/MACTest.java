package com.chenming.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Test;

/**
 * 测试MAC加密算法
 * 	MAC加密算法是单向的,是基于散列函数
 * 	1. 对于相同的秘钥,相同的数据,加密后得到的摘要是相同的
 * 	2. 对于不同的秘钥或者不同的数据,加密后得到的摘要是不同的
 * @author 陈明
 * @date 2018年12月24日
 */
public class MACTest {

	/**
	 * HmacMD5摘要算法(手动指定秘钥)
	 * 对于相同的秘钥,相同的数据,加密后得到的摘要是相同的
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@Test
	public void testHmacMD5() throws NoSuchAlgorithmException, InvalidKeyException {
		
		//要加密的消息
		String str = "这是要加密的消息";
		//秘钥
		byte[] key = "cm".getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacMD5");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));		//04CCEA27E8F571E3AF478E8F8B3CCA71
	}
	
	
	/**
	 * HmacMD5摘要算法(自动生成秘钥)
	 * 自动生成的秘钥每次都是不相同的,因此每次加密后得到的摘要都是不同的
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@Test
	public void testHmacMD5_2() throws NoSuchAlgorithmException, InvalidKeyException {
		
		//自动生成秘钥
		KeyGenerator keygen = KeyGenerator.getInstance("HmacMD5");
		SecretKey generateKey = keygen.generateKey();
		byte[] key = generateKey.getEncoded();
		System.out.println(Arrays.toString(key));
		
		//要加密的消息
		String str = "这是要加密的消息";
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacMD5");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));		//04CCEA27E8F571E3AF478E8F8B3CCA71
	}
	
	
	/**
	 * HmacSHA1加密算法
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	@Test
	public void testHmacSHA() throws NoSuchAlgorithmException, InvalidKeyException {
	
		//要加密的消息
		String str = "这是要加密的消息";
		//指定key
		byte[] key = "cm".getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA1");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));	//3B6895737F47113B8966C0B69580AF10047D177D
	}
	
	/**
	 * HmacSHA256加密算法
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	@Test
	public void testHmacSHA256() throws NoSuchAlgorithmException, InvalidKeyException {
	
		//要加密的消息
		String str = "这是要加密的消息";
		//指定key
		byte[] key = "cm".getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));	
		//0164A160EE07A7C62B542A722423F9C6A7385E916049AF2C82FE05D881006C25
	}
	
	/**
	 * HmacSHA256加密算法
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	@Test
	public void testHmacSHA384() throws NoSuchAlgorithmException, InvalidKeyException {
	
		//要加密的消息
		String str = "这是要加密的消息";
		//指定key
		byte[] key = "cm".getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA384");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));	
		//C2FA4EE2DDA707F637F7978B6BCBF9D70433573F78B6DB5BE7D93EA155FDC821C649DCACDA2DC75469255857B4DCD415
	}
	
	/**
	 * HmacSHA256加密算法
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	@Test
	public void testHmacSHA512() throws NoSuchAlgorithmException, InvalidKeyException {
	
		//要加密的消息
		String str = "这是要加密的消息";
		//指定key
		byte[] key = "cm".getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA512");
		
		//实例化Mac
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		//初始化Mac
		mac.init(secretKeySpec);
		
		//执行消息摘要
		byte[] digest = mac.doFinal(str.getBytes());
		
		System.out.println(new HexBinaryAdapter().marshal(digest));	
		//8EC0FCECFDC79BAAC5FA1A918E461E66AB03D00499C2FEE0A9B85B830F3D09CD284C0254F7160C58BFF8FBA1B9375DE23BEF7358A69EEBEDCE22C830D5745A2C
	}
	
	
	
}
