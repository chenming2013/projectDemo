package com.chenming.testEntityManager;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 这个类是专门用来测试 EntityManager的mergy()方法
 * @author Lenovo
 *
 */
public class TestMergeOfEntityManager
{
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@Before
	public void init()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo2");
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
	 * 测试merge()方法：
	 * 	merge()方法相当于 Hibernate的 saveOrUpdate()方法
	 * 
	 * 	测试merge()方法需要分为几种状态:
	 * 
	 * 	实体的状态:
	 * 		1. 新建状态: 新创建的对象,尚未拥有持久性主键
	 * 		2. 持久化状态: 已经拥有持久性主键并和持久化建立了上下文环境
	 * 		3. 游离状态: 拥有持久性主键,但是没有与持久化建立上下文环境
	 * 		4. 删除状态: 拥有持久性主键,已经和持久化建立上下文环境,但是从数据库中删除
	 */
	//1. 若传入的是一个临时对象(新建状态)(person)
	//会创建一个新的对象,把临时对象的属性复制到新的对象中，然后对新的对象执行持久化操作,并返回新的对象【之前都是匿名对象,这时对象才叫person2】。
	//所以,新的对象中有id,但以前的临时对象(person)中没有id
	@Test
	public void testMerge1()
	{
		Person person = new Person();
		person.setName("BB");
		person.setBirthday(new Date());
		person.setAge(18);
		//person对象尚未拥有持久性主键,所以是新建状态
		
		Person person2 = entityManager.merge(person);
		
		System.out.println("person#id: "+person.getId());   //person#id: null
		System.out.println("person2#id: "+person2.getId());  //person2#id: 5
		
	}
	
	//2. 若传入的是一个游离对象,即传入的对象有OID
	// 2.1) 若在EntityManager缓存中没有该对象,在数据库中也没有对应的记录,JPA会创建一个新的对象,然后把当前游离对象的属性复制到新创建的对象中,最后对新创建的对象执行insert操作,并返回新创建的对象
	@Test
	public void testMerge2_1()
	{
		Person person = new Person();
		person.setName("BB");
		person.setBirthday(new Date());
		person.setAge(18);
		person.setId(100);  //数据表中没有id为100的person记录 
		//此时person拥有持久性主键,但是没有与持久化建立上下文环境,所以是游离态
		
		Person person2 = entityManager.merge(person);
		
		System.out.println("person#id: "+person.getId());   //person#id: 100
		System.out.println("person2#id: "+person2.getId());  //person2#id: 6
	}
	//2.2) 若在EntityManager缓存中没有该对象,但在数据库中有对应的记录,JPA会查询对应的记录,然后返回该记录对应的对象,再然后会把游离对象的属性复制到查询到的对象中,最后对查询到的对象执行update操作
	@Test
	public void testMerge2_2()
	{
		Person person = new Person();
		person.setName("XX");
		person.setBirthday(new Date());
		person.setAge(38);
		person.setId(8);   //数据表中有id为8的person记录
		
		Person person2 = entityManager.merge(person);
	}
	//2.3) 若在EntityManager缓存中有对应的对象,JPA会把游离对象的属性复制到查询到的EntityManager缓存的对象中,然后EntityManager缓存中的对象执行update
	@Test
	public void testMerge2_3()
	{
		
		//这里从数据库获取一个对象,模拟的是EntityManager缓存对象
		Person person2 = entityManager.find(Person.class,7);
		
		//这是游离对象
		Person person = new Person();
		person.setName("QQ");
		person.setBirthday(new Date());
		person.setAge(28);
		person.setId(7);   //数据表中有id为8的person记录
		
		person2 = entityManager.merge(person);
	}
}
