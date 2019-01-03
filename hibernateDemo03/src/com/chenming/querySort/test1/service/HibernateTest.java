package com.chenming.querySort.test1.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.querySort.test1.domain.Student4;
import com.chenming.querySort.test1.domain.Team4;
import com.chenming.querySort.test1.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	/**
	 * 测试继承映射第一种方案：每个子类都对应一张表
	 */
	@Test
	public void testQuerySort() {
		Configuration configuration = HibernateUtil.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	
	/**
	 * 测试插入数据
	 */
	@Test
	public void testInsert() {
		
		//打开数据库连接
		Session session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		Student4 s1 = new Student4();
		s1.setId("1001");
		s1.setName("zhangsan");
		s1.setDescription("我是张三");

		Student4 s2 = new Student4();
		s2.setId("1002");
		s2.setName("lisi");
		s2.setDescription("我是李四");

		Student4 s3 = new Student4();
		s3.setId("1003");
		s3.setName("wangwu");
		s3.setDescription("我是王五");
		
		Team4 t = new Team4();
		t.setId("1");
		t.setTeamName("团队一");
		Set<Student4> set = new HashSet<Student4>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		t.setStudent4s(set);
		
		s1.setTeam4(t);
		s2.setTeam4(t);
		s3.setTeam4(t);
		
		
		try {
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(t);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	/**
	 * 测试查询
	 */
	@Test
	public void testQuery() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Team4 t = (Team4) session.get(Team4.class, "1");
		Set<Student4> set = t.getStudent4s();
		Iterator<Student4> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
	}
}
