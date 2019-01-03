package com.chenming.test1.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.chenming.test1.entity.TUser;
import com.chenming.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	Session session = null;
	
	
	/**
	 * 对象持久化(Insert)方法
	 */
	public void testInsert()
	{
		Transaction transaction = null;
		try
		{
			//开启事务
			transaction = session.beginTransaction();
			
			TUser user = new TUser();
			user.setName("chenming");
			//保存(持久化)
			session.save(user);
			//刷新session中的缓存
			session.flush();
			//提交事务
			transaction.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(transaction!=null) 
			{
				try 
				{
					transaction.rollback();
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		}
	}
	

	
	/**
	 * JUnit中setUp()方法在TestCase初始化的时候会自动调用,一般用于初始化公共资源。
	 */
	@Override
	protected void setUp() throws Exception
	{
		session = HibernateUtil.openSession();
	}
	
	/**
	 * 与setUp()方法对应,JUnit TestCase执行完毕时,会自动调用tearDown方法,一般用于资源释放。 
	 */
	@Override
	protected void tearDown() 
	{
		if(session!=null) 
		{
			try 
			{
				session.close();
			}catch(Exception e) 
			{
				e.printStackTrace();
			}finally
			{
				session = null;
			}
		}
	}
}
