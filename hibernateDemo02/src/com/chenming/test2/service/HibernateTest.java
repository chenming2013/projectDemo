package com.chenming.test2.service;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test2.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	/**
	 * 测试一对多关联关系
	 */
	@Test
	public void testOneToMany()
	{
		Configuration configuration = HibernateUtil.getConfiguration();
		
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	} 
	
}
