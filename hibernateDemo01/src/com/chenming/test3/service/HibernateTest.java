package com.chenming.test3.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test1.util.HibernateUtil;
import com.chenming.test3.domain.TUser3;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	
	/**
	 * 测试Hibernate的addResources()方法
	 * 	addResurces()方法能够手动的将映射文件添加到Configuration中
	 */
/*	@Test
	public void testAddResources() 
	{
		Configuration configuration = new Configuration().addResource("com/chenming/test3/domain/TUser3.hbm.xml");
		InputStream in = HibernateTest.class.getClassLoader()
									  .getResourceAsStream("com/chenming/test3/hibernate.properties");
		Properties properties = new Properties();
		try
		{
			properties.load(in);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configuration.setProperties(properties);
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);
	}*/
	
	/**
	 * 测试Hibernate的addClass()方法
	 * 	addClass()方法能够手动的将实体类添加到Configuration中
	 */
	@Test
	public void testAddClass() 
	{
		Configuration configuration = new Configuration().addClass(TUser3.class);
		InputStream in = HibernateUtil.class.getClassLoader()
									  .getResourceAsStream("com/chenming/test3/hibernate.properties");
		Properties properties = new Properties();
		try
		{
			properties.load(in);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configuration.setProperties(properties);
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);
	}
	
}
