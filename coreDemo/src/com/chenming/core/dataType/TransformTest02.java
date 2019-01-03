package com.chenming.core.dataType;

/**
 * 测试基础数据类型转换
 * @author Lenovo
 *
 */
public class TransformTest02
{
	public static void main(String[] args)
	{
		byte b = 10;
		
		//将变量b的值赋值给变量d,变量b和变量d的类型一样,所以不存在类型转换
		byte d = b;
		
		//此时需要强制类型转换了,因为变量b为byte类型,2为int类型,两个变量进行操作,会发生类型向上提升,
		//也就是说变量b会先提升为int类型,再与2相加,所以最后的类型是int,
		//而int类型转换成byte是向下转型,是需要强制转换的
		byte e = (byte)(b + 2);
	}
}
