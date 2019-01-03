package com.chenming.compositeMapping.test1.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.compositeMapping.test1.domain.People4;
import com.chenming.compositeMapping.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试继承映射第一种方案：每个子类都对应一张表
	 */
	@Test
	public void testCompositeMapping() {
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
		
		People4 people = new People4();
		people.setId("123456");
		people.setName("cm");
		people.setAge("24");
		
		People4 people2 = new People4();
		people2.setId("123456");
		people2.setName("cm");
		people2.setAge("42");
		
		try {
			session.save(people);
			session.save(people2);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}
}
