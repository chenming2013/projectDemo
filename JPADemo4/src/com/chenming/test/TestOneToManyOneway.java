package com.chenming.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试单向一对多
 * @author Lenovo
 *
 */
public class TestOneToManyOneway
{
	private EntityManagerFactory entityManagerFactory; 
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	@Before
	public void init()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo4");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}
	
	@After
	public void destory()
	{
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void testOneToMany()
	{
		
	}
}
