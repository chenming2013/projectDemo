package com.chenming.test4.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.test4.domain.Course3;
import com.chenming.test4.domain.Student3;
import com.chenming.test4.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{
	/**
	 * 测试单向多对一
	 */
	@Test
	public void testManyToMany() 
	{
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
		
		Course3 course = new Course3();
		course.setName("课程1");
		
		Student3 student = new Student3();
		student.setName("学生1");
		Student3 student2 = new Student3();
		student2.setName("学生2");
		

		Set<Student3> studentSet = new HashSet<Student3>();
		studentSet.add(student);
		studentSet.add(student2);
		course.setStudents(studentSet);
		
		try {
			session.save(student);
			session.save(student2);
			session.save(course);
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}
}
