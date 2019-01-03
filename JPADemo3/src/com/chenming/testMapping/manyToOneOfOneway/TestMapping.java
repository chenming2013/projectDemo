package com.chenming.testMapping.manyToOneOfOneway;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 这是测试单向多对一的映射关联关系
 * @author Lenovo
 *
 */
public class TestMapping
{
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	@Before
	public void init()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo3");
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
	public void testManyToOneOfOneway()
	{
		Customer customer = new Customer();
		customer.setName("lisi");
		customer.setBirthday(new Date());
		customer.setEmail("lisi@qq.com");
		customer.setAge(10);
		
		Order order1 = new Order();
		order1.setOrderName("O-FF-1");
		
		Order order2 = new Order();
		order2.setOrderName("O-FF-2");
		
		//设置关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		//执行保存操作
		entityManager.persist(customer);
		entityManager.persist(order1);
		entityManager.persist(order2);
	}
}
