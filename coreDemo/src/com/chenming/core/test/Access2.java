package com.chenming.core.test;

class Access2
{
	private String name = "chenmin";
	
	int age = 22;
	
	protected String address = "湖北省鄂州市";
	
	public String school = "湖北汽车工业学院";
	
	private void method1() 
	{
		System.out.println("Test...method1");
	}
	void method2()
	{
		System.out.println("Test...method2");
	}
	protected void method3()
	{
		System.out.println("Test...method3");
	}
	public void method4()
	{
		System.out.println("Test...method4");
	}
}
