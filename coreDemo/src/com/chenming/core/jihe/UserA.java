package com.chenming.core.jihe;

import java.util.Comparator;

public class UserA
{
	private String uname;  //用户名 
	private String passWord; //密码
	//构造方法
	public UserA()
	{
		
	}
	public UserA(String uname,String passWord)
	{
		this.uname = uname;
		this.passWord = passWord;
	}
	//getter、setter方法
	public void setUName(String uname)
	{
		this.uname = uname;
	}
	public String getUName()
	{
		return this.uname;
	}
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	public String getPassWord()
	{
		return this.passWord;
	}
	//重写toString()方法
	public String toString()
	{
		return "["+this.uname + "," + this.passWord + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserA other = (UserA) obj;
		if (passWord == null)
		{
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (uname == null)
		{
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	
}

