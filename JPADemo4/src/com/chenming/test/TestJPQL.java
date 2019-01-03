package com.chenming.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试使用 JPQL 查询
 * @author Lenovo
 *
 */

public class TestJPQL
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
	
	/**
	 * 入门HelloWorld测试
	 */
	@Test
	public void testHelloWorldJPQL()
	{
		String jpql = "from Person p where p.age>? ";
		
		Query query = entityManager.createQuery(jpql);
		
		//占位符的索引是从 1 开始
		query.setParameter(1, 12);
		List resultList = query.getResultList();
		System.out.println(resultList);
		/**
		 * 结果：
		 * 	[Person [id=1, name=zhangsan, birthday=2017-09-25, age=23], Person [id=3, name=wangwu, birthday=2017-08-01, age=45], Person [id=4, name=zhaoliu, birthday=2017-09-12, age=43], Person [id=5, name=qianqi, birthday=2017-09-04, age=65]]
		 */
	}
	
	/**
	 * 上面的测试是获取全部字段
	 * 下面我们获取部分字段
	 * 结论:
	 * 	默认情况下,若值查询部分属性,则将返回Object[]类型的结果,或者Object[]类型的List(数组中存放的是一个个的List)
	 */
	@Test
	public void testPartProperties()
	{
		String jpql = "select p.name , p.age from Person p where p.id>?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);
		List resultList = query.getResultList();
		System.out.println(resultList);
		/**
		 * 结果：[[Ljava.lang.Object;@697537aa, [Ljava.lang.Object;@e99affd, [Ljava.lang.Object;@bf11288, [Ljava.lang.Object;@7ff7a4d7]
		 */
	}
	
	/**
	 * 上面的一个 测试方法中,如果我们向将查询的字段封装到对象中,则可以这样做
	 */
	@Test
	public void testPartProperties2()
	{
		String jpql = "select new Person(p.name , p.age) from Person p where p.id>?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);
		List resultList = query.getResultList();
		System.out.println(resultList);
		/**
		 * 结果：
		 * [Person [id=null, name=lisi, birthday=null, age=12], Person [id=null, name=wangwu, birthday=null, age=45], Person [id=null, name=zhaoliu, birthday=null, age=43], Person [id=null, name=qianqi, birthday=null, age=65]]
		 * 注意：这种做法是前提是在 Person类中有 Person(String name,int age)这样一个构造方法
		 */
	}
	
	
	
}
