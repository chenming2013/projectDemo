package com.chenming.core.dataType;

/**
 * 对于基本数据类型的取值范围,我们不用记住准确值,记得一个大概就好了,当然我们也可以使用程序直接取出最值
 * @author Lenovo
 *
 */
public class DataType
{
	public static void main(String[] args)
	{
		/**
		 * byte
		 */
		//byte类型的二进制的个数
		System.out.println("基本类型：byte 二进制位数："+Byte.SIZE);  //8
		//byte类型所占的字节数
		System.out.println("基本类型：byte 所占字节数："+Byte.BYTES);  //1
		//byte类型数据的最大值
		System.out.println("基本类型：byte 最大值："+Byte.MAX_VALUE);  //127
		//byte类型数据的最小值
		System.out.println("基本类型：byte 最小值："+Byte.MIN_VALUE);  //-128
		System.out.println();
		
		/**
		 * short
		 */
		System.out.println("基本类型：short 二进制位数："+Short.SIZE);  //16
		System.out.println("基本类型：short 所占字节数："+Short.BYTES);  //2
		System.out.println("基本类型：short 最大值："+Short.MAX_VALUE);  //32767
		System.out.println("基本类型：short 最小值："+Short.MIN_VALUE);  //-32768
		System.out.println();
		
		/**
		 * int 
		 */
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  //32
    	System.out.println("基本类型：int 所占字节数："+Integer.BYTES);  //4
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  //-2147483648
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  //2147483647
        System.out.println();  
  
        /**
         *  long  
         */
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  //64
        System.out.println("基本类型：long 所占字节数："+Long.BYTES);  //8
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        /**
         *  float  
         */
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  //32
        System.out.println("基本类型：float 所占字节数："+Float.BYTES);  //4
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        /**
         *  double  
         */
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  //64
        System.out.println("基本类型：double 所占字节数："+Double.BYTES);  //8
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        /**
         *  char  
         */
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  //16
        System.out.println("基本类型：short 所占字节数："+Short.BYTES);  //2
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);  
		
	}
}
