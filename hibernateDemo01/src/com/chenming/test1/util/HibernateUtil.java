package com.chenming.test1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 这是Hibernate的工具类,用来初始化SessionFactory,以及创建Session对象
 * @author Lenovo
 *
 */
public class HibernateUtil
{
	private static SessionFactory sessionFactory = null;
	
	static 
	{
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration.getProperties().toString());
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public static Session openSession() 
	{
		return sessionFactory.openSession();
	}
}
