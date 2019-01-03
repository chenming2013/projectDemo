package com.chenming.test2.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.chenming.test2.domain.TUser2;

/**
 * Hibernate的工具类,创建SessionFactory以及Session
 * 
 * 
 * @author Lenovo
 *
 */
public class HibernateUtil
{
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static 
	{
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * 获取Configuration 
	 */
	public static Configuration getConfiguration() 
	{
		return configuration;
	} 
	
	
	/**
	 * 获取SessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	
	/**
	 * 获取Session
	 */
	public static Session openSession() 
	{
		return sessionFactory.openSession();
	}
}
