package com.chenming.test1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 测试
 * @author Lenovo
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		/**
		 * 1.创建EntityManagerFactory(EntityManaferFactory类似SessionFactory)
		 * 2.由EntityManagerFactory创建EntityManager(EntityManager类似Session)
		 * 3.开启事务
		 * 4.进行持久化操作
		 * 5.提交事务
		 * 6.关闭EntityManager
		 * 7.关闭EntityManagerFactory
		 */
		
		//1.创建EntityManagerFactory(EntityManaferFactory类似SessionFactory)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo1");
		//2.由EntityManagerFactory创建EntityManager(EntityManager类似Session)
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4.进行持久化操作
		Customer customer = new Customer();
		customer.setLastName("chenming");
		customer.setEmail("2040820766@qq.com");
		customer.setAge(23);
		
		System.out.println(customer.getInfo());
		
		entityManager.persist(customer);
		
		//5.提交事务
		transaction.commit();
		
		//6.关闭EntityManager
		entityManager.close();
		
		//7.关闭EntityManagerFactory
		entityManagerFactory.close();
		
	}
}
