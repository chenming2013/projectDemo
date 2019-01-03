package com.chenming.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 测试JPA的注解
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
		 * 4. 进行持久化操作
		 * 5. 事务提交
		 * 6. 关闭EntityManager
		 * 7. 关闭EntityManagerFactory
		 */
		//1. 获取EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo1");
		
		//2. 由EntityManagerFactory创建EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3. 开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4. 进行持久化操作
		Person person = new Person();
		person.setName("chenming");
		person.setBirthday(new Date());
		person.setRegisterTime(new Date());
		person.setAge(23);
		
		entityManager.persist(person);
		
		//5. 关闭事务
		transaction.commit();
		
		//6. 关闭EntityManager
		entityManager.close();
		
		//7. 关闭EntityManagerFactory
		entityManagerFactory.close();
		
		
	}

}
