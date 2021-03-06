package com.chenming.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Test;

/**
 * 测试AES加密
 * 	1. AES加密是对称加密,AES密钥可以是128位bit(16字节)或者256位bit(32字节)
 * 	2. AES加密要指定加密模式和填充模式,加密模式包括ECB、CBC等。
 * 		ECB模式是分组模式; CBC是分块加密后,每块与前一块的加密结果异或后再加密,第一块加密的明文是与IV变量进行异或。
 * 		IV(Initialization value)是一个初始值,对于CBC模式来说,它必须是随机选取并且是保密的,而且它的长度和密码分组相同
 * @author 陈明
 * @date 2019年1月2日
 */
public class AESTest {
	
	private static final String AES_KEY = "cm123456";
	
	/**
	 * 使用ECB模式进行加密
	 * 	1.传入算法,实例化一个加解密器
	 * 	2.传入加密模式和密钥,初始化一个加密器
	 * 	3.调用doFinal()方法加密
	 */
	@Test
	public void encrptByECB() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		String data = "helloworld";
		
		//1.构造密钥生成器,指定为AES算法(不区分大小写)
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		
		//2.根据encodeRules规则初始化密钥生成器
		//生成一个128位的随机源
		keyGenerator.init(128, new SecureRandom(AES_KEY.getBytes()));
		
		//3.产生原始对称密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.获取原始对称密钥的字节数组
		byte[] encoded = secretKey.getEncoded();
		
		//5.根据字节数组生成AES密钥
		SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
		
		//6.根据指定算法AES生成密码器
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		//7.初始化密码器
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		
		//8.加密
		byte[] bytes = cipher.doFinal(data.getBytes());
		
		//byte数组转换为十六进制字符串
		System.out.println(DatatypeConverter.printHexBinary(bytes));
		//9C5B9F32C28EA00E53AC6F65C00EB7F9
		
		System.out.println(new HexBinaryAdapter().marshal(bytes));
		//9C5B9F32C28EA00E53AC6F65C00EB7F9
	}
	
	/**
	 * 使用ECB模式进行解密
	 */
	@Test
	public void decrptByECB() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//加密后的密文
		String data = "9C5B9F32C28EA00E53AC6F65C00EB7F9";
		
		//1.构造密钥生成器,指定为AES算法
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		
		//2.初始化密钥生成器,生成128位的随机源
		keyGenerator.init(128, new SecureRandom(AES_KEY.getBytes()));
		
		//3.产生原始对称密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.获取原始对称密钥的字节数组
		byte[] encoded = secretKey.getEncoded();
		
		//5.根据字节数组生成AES密钥
		SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
		
		//6.根据指定算法AES生成密码器
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		//7.初始化密码器
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		
		//8.解密
		byte[] bytes = cipher.doFinal(DatatypeConverter.parseHexBinary(data));
		
		System.out.println(new String(bytes));
		//helloworld
	}
	
	
	/**
	 * 使用CBC模式进行加密
	 */
	@Test
	public void encrptByCBC() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//要加密的明文
		String data = "helloworld";
		
		//1.构造密钥生成器,指定为AES算法
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		
		//2.初始化密钥生成器,生成128位随机源
		keyGenerator.init(128,new SecureRandom(AES_KEY.getBytes()));
		
		//3.产生原始对称密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.获取原始密钥的字节数组
		byte[] encoded = secretKey.getEncoded();
		
		//5.根据字节数组生成AES密钥
		SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
		
		//6.根据指定算法AES生成密码器
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		//7.初始化密码器
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		
		//8.加密
		byte[] bytes = cipher.doFinal(data.getBytes());
		
		System.out.println(DatatypeConverter.printHexBinary(bytes));
		//CC3656FAE338872368D61C75195C62D3
	}
	
	/**
	 * 使用CBC模式进行解密
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void decrptByCBC() throws NoSuchAlgorithmException {
		//要解密的密文
		String data = "CC3656FAE338872368D61C75195C62D3";
		
		//1.构造密钥生成器,指定为AES算法
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		
		//2.初始化密钥生成器,生成128位随机源
		keyGenerator.init(128, new SecureRandom(AES_KEY.getBytes()));
		
		//3.产生原始对称密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.
	}
	
}
