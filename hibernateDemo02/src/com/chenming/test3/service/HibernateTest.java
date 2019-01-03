package com.chenming.test3.service;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test3.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	
	/**
	 * 测试双向一对多
	 */
	@Test
	public void testBothOneToMany() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
}
