package com.chenming.test5.multipleOnetoOnePK.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test5.multipleOnetoOnePK.domain.IdCard2;
import com.chenming.test5.multipleOnetoOnePK.domain.Person2;
import com.chenming.test5.multipleOnetoOnePK.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	/**
	 * 测试单向多对一
	 */
	@Test
	public void testMultipleOnetoOnePK() 
	{
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
		
		IdCard2 idCard = new IdCard2();
        idCard.setCardNo("11111");
        
        Person2 person = new Person2();
        person.setName("aaaaa");
        
        person.setIdCard2(idCard);
        
        session.save(idCard);
        session.save(person);
        
        transaction.commit();
	}
}
