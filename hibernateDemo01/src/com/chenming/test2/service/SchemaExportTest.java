package com.chenming.test2.service;
/**
 * 测试利用SchemaExport工具自动创建数据表
 * @author Lenovo
 *
 */

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test2.util.HibernateUtil;

public class SchemaExportTest
{

	@Test
	public void create() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true,false);
	}
	
}
