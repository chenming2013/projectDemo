package com.chenming.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Test;

/**
 * 测试DES加密解密
 * 	DES是对称加密,所谓对称加密算法,即: 加密和解密使用相同的密钥
 * 
 * 	注意: 密钥必须是8字节,如"cm123456";如果指定的密钥长度大于8字节,那么只取前8位;如果指定的密钥长度小于8字节,会报错。
 * 
 * @author 陈明
 * @date 2019年1月2日
 */
public class DESTest {
	
	private static final String DES_KEY = "cm123456";
	
	/**
	 * DES加密
	 */
	@Test
	public void encrypt() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		//要加密的数据
		String data = "helloworld";
		//秘钥
		String key = DES_KEY;
		
		//DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		
		//创建一个DESKeySpec对象
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
		
		//创建一个密钥工厂,然后用它把DESKeySpec转换成Securekey
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		
		//Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance("DES");
		//用秘钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, secretKey,random);
		
		//加密
		byte[] bytes = cipher.doFinal(data.getBytes());
		
		//将byte数组转换成十六进制字符串
		System.out.println(new HexBinaryAdapter().marshal(bytes));	//A293E0BE5BA23D394EB3460786E85BBA

	}

	/**
	 * DES解密
	 */
	@Test
	public void decrpt() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		//要解密的数据
		String data = "A293E0BE5BA23D394EB3460786E85BBA";
		
		//密钥
		String key = DES_KEY;
		
		//DES算法要求一个可信任的随机算法
		SecureRandom random = new SecureRandom();
		
		//创建一个DESKeySpec对象
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
		
		//创建一个秘钥工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		
		//将DESKeySpec对象转换成SecretKey对象
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		
		//Cipher对象实际完成加密/解密工作
		Cipher cipher = Cipher.getInstance("DES");
		
		//用秘钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
				
		//解密
		//注意: new HexBinaryAdapter().unmarshal(data) 这里首先需要将十六进制转换成byte数组
		byte[] bytes = cipher.doFinal(new HexBinaryAdapter().unmarshal(data));
		
		System.out.println(new String(bytes));	//helloworld
	}
	
	/**
	 * DES加密的另一种方式
	 */
	@Test
	public void encrpt2() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//要加密的明文
		String data = "helloworld";
		
		//1.构造密钥生成器
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		
		//2.初始化密钥生成器,生成56位的随机源
		//注意: 这里一定要写56
		keyGenerator.init(56, new SecureRandom(DES_KEY.getBytes()));
		
		//3.生成密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.根据指定DES算法生成密码器
		Cipher cipher = Cipher.getInstance("DES");
		
		//5.初始化密码器
		cipher.init(Cipher.ENCRYPT_MODE, secretKey,new SecureRandom());
		
		//6.加密
		byte[] bytes = cipher.doFinal(data.getBytes());
		
		//7.byte数组转换成十六进制字符串
		System.out.println(DatatypeConverter.printHexBinary(bytes));
		//03471FF65FEEF8EDA97B16721D110BBE
	}
	
	/**
	 * DES加密的另一种方式
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	@Test
	public void decrpt2() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//要解密的密文
		String data = "03471FF65FEEF8EDA97B16721D110BBE";
		
		//1.构造密钥生成器
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		
		//2.初始化密钥生成器,生成56位的随机源
		keyGenerator.init(56, new SecureRandom(DES_KEY.getBytes()));
		
		//3.生成密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//4.根据指定DES算法生成密码器
		Cipher cipher = Cipher.getInstance("DES");
		
		//5.初始化密码器
		cipher.init(Cipher.DECRYPT_MODE, secretKey,new SecureRandom());
		
		//6.加密
		byte[] bytes = cipher.doFinal(DatatypeConverter.parseHexBinary(data));
		
		//7.byte数组转换成十六进制字符串
		System.out.println(new String(bytes));
		//helloworld
	}
	
}
