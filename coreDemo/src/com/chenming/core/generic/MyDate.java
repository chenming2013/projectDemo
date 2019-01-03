package com.chenming.core.generic;

/*
定义一个MyDate类包含:
private成员变量month,day,year；并为每一个属性定义 getter, setter 方法； 
 * 
 */
public class MyDate
{
	private String year;
	private String month;
	private String day;
	//构造方法
	public MyDate(String year, String month, String day)
	{
		super();  //调用Object()
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//setter、getter方法
	public String getYear()
	{
		return year;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	public String getMonth()
	{
		return month;
	}
	public void setMonth(String month)
	{
		this.month = month;
	}
	public String getDay()
	{
		return day;
	}
	public void setDay(String day)
	{
		this.day = day;
	}
	@Override
	public String toString()
	{
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}
	
	
}
