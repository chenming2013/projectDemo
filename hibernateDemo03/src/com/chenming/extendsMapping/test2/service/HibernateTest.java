package com.chenming.extendsMapping.test2.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.extendsMapping.test2.domain.Student2;
import com.chenming.extendsMapping.test2.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试继承映射第二种方案：使用一张表表示继承体系下的所有属性的并集
	 */
	@Test
	public void testExtends() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	@Test
	public void testInsert() throws ParseException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//获取数据库连接
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//新增数据
		Student2 stu = new Student2();
		stu.setAge("24");
		DateFormat df = new SimpleDateFormat("yyyy-MM-HH");
		Date date = df.parse("1994-02-25");
		stu.setBirthday(date);
		stu.setCardId("20130520819");
		stu.setName("陈明");
		stu.setSex("男");
		session.save(stu);
		try {
			transaction.commit();
			session.close();
		}catch(Exception e) {
			transaction.rollback();
		}finally {
			if(session!=null) {
				session = null;
			}
		}
	}
	
}
