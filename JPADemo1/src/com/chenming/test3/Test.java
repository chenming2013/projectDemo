package com.chenming.test3;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 测试主键的生成策略是 "TABLE"
 * @author Lenovo
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		/**
		 * 1. 获取EntityManagerFactory(相当于Hibernate的SessionFactory)
		 * 2. 由EntityManagerFactory创建EntityManager(相当于Hibernate的Session)
		 * 3. 开启事务
		 * 4. 持久化操作
		 * 5. 事务提交
		 * 6. 关闭EntityManager
		 * 7. 关闭EntityManagerFactory
		 */
		
		//1. 获取EntityManagerFactory(相当于Hibernate的SessionFactory)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo1");
		
		//2. 由EntityManagerFactory创建EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3. 开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4. 持久化操作
		Order order = new Order();
		order.setName("衣服");
		order.setOrderTime(new Date());
		order.setPrice(88.8);
		
		entityManager.persist(order);
		
		//5. 事务提交
		transaction.commit();
		
		//6. 关闭EntityManager
		entityManager.close();
		
		//7. 关闭EntityManageFactory
		entityManagerFactory.close();
		
	}
}
