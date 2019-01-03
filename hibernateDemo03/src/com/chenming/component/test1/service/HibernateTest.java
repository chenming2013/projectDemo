package com.chenming.component.test1.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.component.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试继承映射第一种方案：每个子类都对应一张表
	 */
	@Test
	public void testComponent() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	
	/**
	 * 测试插入数据
	 */
	@Test
	public void testInsert() {
		
		//打开数据库连接
		Session session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		
		try {
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	/**
	 * 测试查询
	 */
	@Test
	public void testQuery() {
	}
}
