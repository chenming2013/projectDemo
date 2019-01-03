package com.chenming.test5.multipleOnetoOneFK.service;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test5.multipleOnetoOneFK.domain.IdCard4;
import com.chenming.test5.multipleOnetoOneFK.domain.Person4;
import com.chenming.test5.multipleOnetoOneFK.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	
	@Test
	public void testMultipleOnetoOneFK() 
	{
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	/**
	 * 测试增加数据
	 */
	@Test
	public void testInsert() {
		
		//打开数据库连接
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		IdCard4 idCard = new IdCard4();
		idCard.setCardNo("22");
		
		
		Person4 person = new Person4();
		person.setName("bb");
		person.setIdCard4(idCard);

		try {
			session.save(idCard);
			session.save(person);
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}
}
