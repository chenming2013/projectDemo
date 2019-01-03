package com.chenming.testMapping.oneToManyOfOneway;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenming.testMapping.manyToOneOfOneway.Customer;
import com.chenming.testMapping.manyToOneOfOneway.Order;

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
	public void testOneToManyOfOneway()
	{
		Customer2 customer = new Customer2();
		customer.setName("lisi");
		customer.setBirthday(new Date());
		customer.setEmail("lisi@qq.com");
		customer.setAge(10);
		
		Order2 order1 = new Order2();
		order1.setOrderName("O-FF-1");
		
		Order2 order2 = new Order2();
		order2.setOrderName("O-FF-2");
		
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		
		//执行保存操作
		entityManager.persist(order1);
		entityManager.persist(order2);
		entityManager.persist(customer);
	}
}
