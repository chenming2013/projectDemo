package com.chenming.test2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * hibernate工具类,加载hibernate.cfg.xml配置文件生成Configuration对象,
 * 通过Configuration对象生成SessionFactory对象
 * @author 陈明
 * @date   2018年7月12日
 */
public class HibernateUtil
{
	/**
	 * Configuraiton和SessionFactory都是重量级的对象,创建这两个对象比较消耗资源(因为这两个对象要加载Hibernate框架所需要的配置)
	 * 所有这设置成static,加载HibernateUtil的时候就创建创建,并且只创建一次
	 */
	private static Configuration configuration;
	
	private static SessionFactory sessionFactory;
	
	static
	{
		//指定加载hibernate.cfg.xml文件的位置
		configuration = new Configuration().configure("/com/chenming/test2/hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Configuration getConfiguration() {
		return configuration;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
