package com.chenming.utils;

/**
 * 编码工具
 * @author 陈明
 * @date 2018年12月10日
 */
public class EncodeUtil {

	/**
	 * UTF-8相关
	 */
	/* 当字符的码点在  (0000 0000-0000 007F) 之间时,UTF-8将字符编码成一个字节 */
	private static final Integer UTF8_ONE_BYTE_MAX = Integer.parseInt("0000007F", 16);   	//最大值: 127 = 2^7 - 1;
	/* 当字符的码点在  (0000 0080-0000 07FF) 之间时,UTF-8将字符编码成两个字节 */
	private static final Integer UTF8_TWO_BYTE_MAX = Integer.parseInt("000007FF", 16);		//最大值: 2047 = 2^11 - 1;
	/* 当字符的码点在  (0000 0800-0000 FFFF) 之间时,UTF-8将字符编码成三个字节 */
	private static final Integer UTF8_THREE_BYTE_MAX = Integer.parseInt("0000FFFF", 16);	//最大值: 65535 = 2^16 - 1;
	/* 当字符的码点在  (0001 0000-0010 FFFF) 之间时,UTF-8将字符编码成四个字节 */
	private static final Integer UTF8_FOUR_BYTE_MAX = Integer.parseInt("0010FFFF", 16);		//最大值: 1114111 = 2^10 + (2^16 -1);
	
	
	
	
	/**
	 * 使用UTF-8对字符进行编码(对字符进行UTF-8编码)
	 * 	模拟UTF-8编码
	 * 
	 * 	UTF-8编码流程:
	 * 		1. 我们指定使用什么编码格式对字符(如中文字符'一')进行编码,如：UTF-8编码
	 * 		2. 程序首先查找该字符在Unicode码表中的十六进制、十进制、二进制(中文字符'一'在Unicode码表中十六进制为"\u4E00",十进制为"19968",二进制为"100111000000000")
	 * 		3. 得到十六进制(或十进制),就可以根据Unicode编码规范知道该字符应该用几个字节表示,中文字符'一'应该用3个字节表示
	 * 		4. 按照UTF-8规范拼接二进制
	 * 	中文字符'一'在Unicode码表中是"\uE400",转换成二进制是"100111000000000"
	 * 	UTF-8编码之后的二进制是"11100100 10111000 10000000",对应的十六进制是"E4 B8 80"
	 * 
	 * 	总结: 中文字符'一'的Unicode十六进制码为"4E00",经过UTF-8编码之后的十六进制为"E4B880"
	 */
	public static String encodeCharacterWithUTF8(String str) {
		//将字符串拆分成字符序列
		char[] charArray = str.toCharArray();
		
		//如果按照UTF-8编码要占用几个字节
		int byteNum = 1;
		//UTF-8编码之后的二进制形式
		String binaryStringOfUTF8 = "";
		
		//编码之前的二进制形式
		String binaryStringOfOrigin  = null;
		for(int i=0;i<charArray.length;i++) {
			binaryStringOfOrigin = Integer.toBinaryString(charArray[i]);
			//计算按照UTF-8编码之后的二进制占几个字节(按照UTF-8编码规范)
			byteNum = calculateByteNumForUTF8(binaryStringOfOrigin);
			//将编码之前的二进制数据按照格式拆分成UTF-8编码之后的形式
			binaryStringOfUTF8 += combine(binaryStringOfOrigin, byteNum);
		}
		
		return binaryStringOfUTF8;
	}
	
	/**
	 * 计算字节的数量
	 * 	即计算一个二进制形式的数对应UTF-8编码应该编码成几个字节
	 * 
	 * 		  Unicode符号范围			    UTF-8编码方式(二进制)	
	 * 	0000 0000 - 0000 007F   >>>		0*******
	 *  0000 0080 - 0000 07FF	>>>		110***** 10******
	 *  0000 0800 - 0000 FFFF	>>>		1110**** 10****** 10******
	 *  0001 0000 - 0010 FFFF	>>>		11110*** 10****** 10****** 10******
	 * 
	 * @param binaryString : 二进制形式的字符串
	 * @return
	 */
	private static int calculateByteNumForUTF8(String binaryString) {
		//将二进制字符串转换成十进制数字
		int code = Integer.parseInt(binaryString, 2);
		int byteNum = 1;
		if(code>=0 && code<=UTF8_ONE_BYTE_MAX) {
			byteNum = 1;
		}else if(code<UTF8_TWO_BYTE_MAX) {
			byteNum = 2;
		}else if(code<UTF8_THREE_BYTE_MAX) {
			byteNum = 3;
		}else if(code<UTF8_FOUR_BYTE_MAX) {
			byteNum = 4;
		}
		return byteNum;
	}
	
	
	/**
	 * 补足8位二进制,不够的补0
	 * 	如 中文字符'一',在Unicode码表中是 "\u4E00" , 二进制形式是 "100111000000000",十进制是19968,
	 * 	按照UTF-8编码规范,中文字符'一'使用UTF-8编码后要用三个字节,所以 "100111000000000" 拆分为 "100 111000 000000"这样的,
	 * 	然后按照UTF-8规范补上相应的bit,最后就是: "11100100" "10111000" "10000000"
	 * @return
	 */
	private static String combine(String binaryStringOfOrigin,int byteNum) {
		if(byteNum==1) {
			return "0" + binaryStringOfOrigin;
		}
		if(byteNum==2) {
			return full8Bit(binaryStringOfOrigin.substring(0,binaryStringOfOrigin.length()-6),"110",byteNum) + "10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-6, binaryStringOfOrigin.length());
		}
		if(byteNum==3) {
			return full8Bit(binaryStringOfOrigin.substring(0,binaryStringOfOrigin.length()-12), "1110", byteNum) + "10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-12,binaryStringOfOrigin.length()-6)+"10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-6, binaryStringOfOrigin.length());
		}
		if(byteNum==4) {
			return full8Bit(binaryStringOfOrigin.substring(0,binaryStringOfOrigin.length()-18), "11110", byteNum) + "10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-18,binaryStringOfOrigin.length()-12) + "10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-12,binaryStringOfOrigin.length()-8)+"10" + binaryStringOfOrigin.substring(binaryStringOfOrigin.length()-6, binaryStringOfOrigin.length());
		}
		return "";
	}
	
	
	private static String full8Bit(String binarystr,String prefix,int byteNum) {
		int length = binarystr.length();
		if(byteNum==1) {
			return prefix + binarystr;
		}
		if(byteNum==2) {
			switch (length) {
				case 5:
					return prefix + binarystr;
				case 4:
					return prefix + "0" + binarystr;
				case 3:
					return prefix + "00" + binarystr;
				case 2:
					return prefix + "000" + binarystr;
				case 1:
					return prefix + "0000" + binarystr;
				case 0:
					return prefix + "00000";
				default:
					break;
			}
		}
		if(byteNum==3) {
			switch (length) {
				case 4:
					return prefix + binarystr;
				case 3:
					return prefix + "0" + binarystr;
				case 2:
					return prefix + "00" + binarystr;
				case 1:
					return prefix + "000" + binarystr;
				case 0:
					return prefix + "0000";
				default:
					break;
			}
		}
		if(byteNum==4) {
			switch (length) {
				case 3:
					return prefix + binarystr;
				case 2:
					return prefix + "00" + binarystr;
				case 1:
					return prefix + "000" + binarystr;
				case 0:
					return prefix + "0000";
				default:
					break;
			}
		}
		return binarystr;
	}
	
	
	public static void main(String[] args) {
		String encodeCharacterWithUTF8 = encodeCharacterWithUTF8("一");
		System.out.println(encodeCharacterWithUTF8);		//111001001011100010000000
		
		String encodeCharacterWithUTF82 = encodeCharacterWithUTF8("我");
		System.out.println(encodeCharacterWithUTF82);		//11100110 10001000 10010001	E6 88 91
															//00011001 01110111 01101110
															//00011010 01111000 01101111
															//-26	   -120	    -111
		
	}
}
