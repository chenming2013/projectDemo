package com.chenming.mapFieldMapping.test1.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.mapFieldMapping.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试Map属性映射
	 */
	@Test
	public void testMapFieldMapping() {
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
//			session.save(people);
//			session.save(people2);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}
}
