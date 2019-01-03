package com.chenming.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 测试发出SQL语句的时间
 * @author 陈明
 * @date   2018年8月2日
 */
public class SendSQLTest extends TestCase
{

	
	@Test
	public void testSendSQL_1() {
		Configuration configuration = new Configuration().configure("/com/chenming/test/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		A a = new A();
		a.setId(1001);
		a.setName("zhangsan");
		
		Session session = sessionFactory.openSession();
		//开启事务
		session.getTransaction().begin();
		
		session.save(a);
		
		//提交事务
		session.getTransaction().commit();
		
		session.close();
	}
}
