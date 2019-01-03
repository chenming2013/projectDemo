package com.chenming.extendsMapping.test2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 这是HIbernate的工具类,通过加载hibernte.cfg.xml文件生成Configuration对象
 * 然后通过Configuration对象生成SessionFactory
 * @author 陈明
 * @date   2018年7月13日
 */
public class HibernateUtil
{

	/**
	 * 由于Configuration对象是hibernate.cfg.xml加载生成的对象,SessionFactory负责管理数据库,
	 * 都是很消耗资源的,所有这里设置成static,当类加载的时候只创建一次对象
	 */
	private static Configuration configuration;
	
	private static SessionFactory sessionFactory;
	
	static
	{
		configuration = new Configuration().configure("/com/chenming/extendsMapping/test2/hibernate.cfg.xml");
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
