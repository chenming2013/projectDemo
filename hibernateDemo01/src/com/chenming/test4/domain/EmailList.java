package com.chenming.test4.domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * 这是一个实现了 UserType接口的类
 * @author 陈明
 * @date   2018年7月11日
 */
public class EmailList implements UserType
{
	private List<String> emails;
	
	private static final char SPLITTER = ';';
	
	private static final int[] TYPES = new int[] {Types.VARCHAR};
	
	/**
	 * 
	 */
	@Override
	public int[] sqlTypes()
	{
		// TODO Auto-generated method stub
		return TYPES;
	}

	@Override
	public Class returnedClass()
	{
		// TODO Auto-generated method stub
		return List.class;
	}

	/**
	 * 判断 email List是否发生改变
	 */
	@Override
	public boolean equals(Object x, Object y) throws HibernateException
	{
		if(x==y) {
			return true;
		}
		if(x!=null && y!=null) {
			List xList = (List)x;
			List yList = (List)y;
			if(xList.size()!=yList.size()) {
				return false;
			}
			for(int i=0;i<xList.size();i++) {
				String str1 = (String)xList.get(i);
				String str2 = (String)yList.get(i);
				if(!str1.equals(str2)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode(Object x) throws HibernateException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 从ResultSet中取出email字段,并将其解析为List类型后返回
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException
	{
		//Hibernate
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
