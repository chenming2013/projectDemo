package com.chenming.hibernate.test;

import java.beans.Expression;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.chenming.hibernate.domain.Student;
import com.chenming.hibernate.domain.Teacher;

import junit.framework.TestCase;

public class HbernateTest1 extends TestCase{

	@Test
	public void testOneToMany() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true,true);
	}
	
	@Test
	public void testInser() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student s1 = new Student();
		Student s2 = new Student();
		Set<Student> stuSet = new HashSet<Student>();
		stuSet.add(s1);
		stuSet.add(s2);
		Teacher teacher = new Teacher();
		teacher.setStuSet(stuSet);
		
		session.save(s1);
		session.save(s2);
		session.save(teacher);
		session.getTransaction().commit();
	}
	
	@Test
	public void testQuery() {
		
	}
}
