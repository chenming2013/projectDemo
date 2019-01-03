package com.chenming.test3.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate的工具类,帮助获取SessionFactory和Session
 * 
 * 	这里测试加载hibernate.properties文件,而不是默认的hibernate.cfg.xml文件
 * @author Lenovo
 *
 */
public class HibernateUtil
{
	private static Configuration configuration;
	
	/**
	 * SessionFactory是重量级的资源,每创建一个SessionFactory实例都比较消耗资源,所以这里定义成static,只加载一次
	 */
	private static SessionFactory sessionFactory;
	
	
	static
	{
		//
		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	
	/**
	 * Session代表的是与数据库的一次连接,相当于JDBC的Connection,
	 * 为了保证访问安全,每一次与数据库的连接都应该是全新的Session,所以Session没有定义成static
	 * @return
	 */
	public static Session getSession() 
	{
		return sessionFactory.openSession();
	}
}
