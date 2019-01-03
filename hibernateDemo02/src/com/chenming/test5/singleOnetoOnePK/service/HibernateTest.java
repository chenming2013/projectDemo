package com.chenming.test5.singleOnetoOnePK.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test5.singleOnetoOnePK.domain.IdCard;
import com.chenming.test5.singleOnetoOnePK.domain.Person;
import com.chenming.test5.singleOnetoOnePK.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	/**
	 * 测试单向一对一
	 */
	@Test
	public void testSingleOnetoOnePK() 
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
		
		IdCard idCard = new IdCard();
		idCard.setId(13);
        idCard.setCardNo("13");
        
        Person person = new Person();
        person.setName("这是13对应的Person");
        person.setId(15);
        person.setIdCard(idCard);
        try {
	        try {
	        	session.save(idCard);
	        }catch(Exception e) {
	        	System.out.println("异常一");
	        	e.printStackTrace();
	        }
	        try {
	        	session.save(person);
	        }catch(Exception e) {
	        	System.out.println("异常二");
	        	e.printStackTrace();
	        	
	        }
	        System.out.println("异常之后");
	        transaction.commit();
        }catch(Exception e1) {
        	System.out.println("hello");
        	e1.printStackTrace();
        	transaction.rollback();
        }finally {
        	
        }
	}
	
	/**
	 * 测试查询数据
	 */
	@Test
	public void testQuery() {
		//打开数据库连接
		Session session = HibernateUtil.getSessionFactory().openSession();
		IdCard idCard = (IdCard)session.get(IdCard.class, 13);
		System.out.println(idCard.toString());
		idCard.setId(23);
		
		Transaction transaction = null;
		try {
			//开启事务
			transaction = session.beginTransaction();

			//保存
			session.save(idCard);
			
			//提交事务
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
}
