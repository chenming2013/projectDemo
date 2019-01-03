package com.chenming.extendsMapping.test3.domain;

public class Teacher3 extends People3
{

	//Teacher类独有的属性
	private int salary;

	// ========== Setter And Getter(Start) ===========
	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	// =========== Setter And Getter(End) ===========
	
}
