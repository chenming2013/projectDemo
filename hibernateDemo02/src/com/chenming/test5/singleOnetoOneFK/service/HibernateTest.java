package com.chenming.test5.singleOnetoOneFK.service;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test5.singleOnetoOneFK.domain.IdCard3;
import com.chenming.test5.singleOnetoOneFK.domain.Person3;
import com.chenming.test5.singleOnetoOneFK.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	
	@Test
	public void testSingleOnetoOneFK() 
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
		
		IdCard3 idCard = new IdCard3();
		idCard.setCardNo("22");
		
		
		Person3 person = new Person3();
		person.setName("bb");
		person.setIdCard3(idCard);

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
