package com.chenming.core.jihe;

public class User implements Comparable<User> //User类实现Comparable接口，定义比较规则。这是比较的第一种规则
{
	private String uname;  //用户名 
	private String passWord; //密码
	//构造方法
	public User()
	{
		
	}
	public User(String uname,String passWord)
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
		User other = (User) obj;
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
	
	@Override
	public int compareTo(User o) //定义比较规则。
	{
		// TODO Auto-generated method stub
		//User otheruser = (User)o; 注意：如果Comparable没有使用泛型，那么此处就要强制转换。因为这里的Comparable使用了泛型，所以不用强制转换。
		if(!this.uname.equals(o.uname)) //按uname的字符串进行比较，因为String类重写了equals()方法，所以这里比较的是字符串的具体内容。
			return this.uname.compareTo(o.uname); //String类的compareTo()方法是按字母的升序进行比较。
		return 0;
	}
	
}
