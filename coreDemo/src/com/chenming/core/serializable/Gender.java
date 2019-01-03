package com.chenming.core.serializable;
/**
* 这是一个枚举类,表示性别
*/
public enum Gender
{
	/**
	* 枚举变量实际上是一个个的Gender类型的变量,实际上就相当于下面的代码,但是下面的代码不能显式的写出
		private static final Gender = new Gender();
	*/
	MALE,
	FEMALE;
}