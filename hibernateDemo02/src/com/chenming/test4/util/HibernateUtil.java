package com.chenming.test4.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate工具类,用来读取hibernate.cfg.xml配置文件生成Configuration对象,
 * 并且由Configuration对象SessionFactory对象
 * @author 陈明
 * @date   2018年7月12日
 */
public class HibernateUtil
{

	private static Configuration configuration;
	/**
	 * SessionFactory是重量级资源,因此设置成static的,记载HibernateUtil的时候只让他创建一次
	 */
	private static SessionFactory sessionFactory;
	
	static 
	{
		configuration = new Configuration();
		configuration = configuration.configure("/com/chenming/test4/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Configuration getConfiguration() {
		return configuration;
	}
}
