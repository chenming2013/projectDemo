package com.chenming.component.test1.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 测试组件映射
 * @author 陈明
 * @date   2018年7月17日
 */
public class Contact implements Serializable
{
	private String address;
	
	private String contacTel;
	
	private String email;
	
	private String zipCode;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getContacTel()
	{
		return contacTel;
	}

	public void setContacTel(String contacTel)
	{
		this.contacTel = contacTel;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	
}
