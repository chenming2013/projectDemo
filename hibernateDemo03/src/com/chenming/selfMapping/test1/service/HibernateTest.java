package com.chenming.selfMapping.test1.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.selfMapping.test1.domain.Region;
import com.chenming.selfMapping.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试自身一对多关联映射
	 */
	@Test
	public void testselfMapping() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	/**
	 * 测试增加数据
	 */
	@Test
	public void testInsert() {
		//打开数据库连接
		Session session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//创建一个国家地区
		Region countryRegion = new Region(); 
		countryRegion.setName("中国");
		
		//为国家创建一些省份
		Region provinceRegion1 = new Region();
		provinceRegion1.setName("湖北省");
		provinceRegion1.setParentRegion(countryRegion);
		Region provinceRegion2 = new Region();
		provinceRegion2.setName("浙江省");
		provinceRegion2.setParentRegion(countryRegion);
		
		try {
			session.save(countryRegion);
			session.save(provinceRegion1);
			session.save(provinceRegion2);
			
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}finally {
			session.close();
		}
	}
	
}
