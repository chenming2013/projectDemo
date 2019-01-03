package com.chenming.test3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 这个是Hibernate的工具类,用来读取hibernate.cfg.xml文件生成Configuration对象,
 * 然后根据Configuration对象生成SessionFactory对象
 * @author 陈明
 * @date   2018年7月13日
 */
public class HibernateUtil
{
	private static Configuration configuration;
	
	private static SessionFactory sessionFactory;
	
	static 
	{
		
		configuration = new Configuration().configure("/com/chenming/test3/hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	public static Configuration getConfiguration() 
	{
		return configuration;
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
