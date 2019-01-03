package com.chenming.test1.service;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	/**
	 * 测试单向多对一
	 */
	@Test
	public void testManyToOne() 
	{
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
}
