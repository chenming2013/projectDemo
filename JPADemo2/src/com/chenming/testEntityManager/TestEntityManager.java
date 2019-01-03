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
 * 这个类主要是用来测试 EntityManager类常用的几个方法：
 * 	
 * @author Lenovo
 *
 */
public class TestEntityManager
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
	 * 测试find()方法：
	 * 	find()方法类似于 Hibernate 中的 get()方法
	 */
	@Test
	public void TestFind()
	{
		Person person = entityManager.find(Person.class, 1);
		
		System.out.println("===================这是一个标记==============");
		
		System.out.println(person);
	
		/**
		 * 测试结果输出顺序:
		 * 先: 输出 SQL
		 * 然后: 输出 "===================这是一个标记=============="
		 * 最后: 输出 Person [id=1, name=zhangsan, birthday=2017-09-24, age=23]
		 * 
		 * 从结果上可以看出
		 * 即便我们不执行 System.out.println(person); 不使用 person 相关的属性,程序任然会发出SQL语句到数据库
		 * 也就是说是没有 "懒加载" 的效果
		 */
	}
	
	
	/**
	 * 测试getReference()方法：
	 * 	geReference()方法类似于 Hibernate 的 load()方法
	 * 
	 */
	@Test
	public void testGetReference()
	{
		Person person = entityManager.getReference(Person.class,1);
		
		System.out.println("===================这是一个标记==============");
		
		//为了测试出效果,将下面这一句代码 注释与不注释 分别执行一次 
		System.out.println(person);
		
		/**
		 * 有两种情况(将):
		 * 	1. 执行了 System.out.println(person) 语句,即使用了person相关的属性
		 * 	2. 没有执行 System.out.println(person) 语句,即没有使用person相关的属性
		 * 
		 * 我们可以看到:
		 * 	1. 当执行了 System.out.println(person),也就是使用了person的相关属性,那么控制台会输出SQL语句,并输出 System.out.println(person) 执行的结果
		 *  2. 当没有执行 System.out.println(person),也就是没有使用person的相关属性,那么控制台就不会输出SQL语句
		 *  3. System.out.println("===================这是一个标记==============")这一句会最先执行
		 *  
		 * 总结: 这其实就是 "懒加载" 
		 * 
		 */
	}
	
	
	/**
	 * 测试 persist()方法：使对象由临时状态变为持久化状态
	 * 	persist()方法类似于 Hibernate 的 save()方法,但还是有所区别
	 * 	区别: 若对象有id,则不能执行 insert 操作,而会抛出异常
	 * 	在下面的代码中,如果我们手动的为 主键id 赋值,那么执行persist()就会报错
	 * 	而在Hibernate中,我们可以手动的为 主键id 赋值,执行save()方法并不会报错
	 */
	@Test
	public void testPersistence()
	{
		Person person = new Person();
		person.setName("AA");
		person.setBirthday(new Date());
		person.setAge(20);
		
		//JPA中不能为 主键 赋值
		//person.setId(100);
		
		entityManager.persist(person);
	}
	
	
	/**
	 * 测试remove()方法：
	 * 	remove()方法类似 Hibernate 的 delete()方法,
	 * 但注意: 该方法只能移除持久化对象,而Hibernate的delete()方法还可以移除游离对象
	 */
	@Test
	public void testRemove()
	{
		//remove()方法只能删除持久化对象(已经映射到数据库中的对象)
		Person person = entityManager.find(Person.class, 3);
		entityManager.remove(person);
		
		//hibernate的delete()方法还可以移除游离态对象
		//游离态对象: 存在这个对象,但是还没有映射到数据库中
	/*
	 	这个person2是创建出来的一个对象,而数据表中也的确存在 id为4 的person数据
	 	JPA执行remove()方法就会报错
	 	Hibernate执行delete()方法能成功的将 id为4 的person数据删除
	 	
		Person person2 = new Person();
		person.setId(4);   //此时的数据中有 id为4 的person数据
		
		entityManager.remove(person2);
	*/	
		
	}
	
	/**
	 * 测试 contains()方法：
	 * 	contains()方法判断一个实体是否属于当前持久上下文环境管理的实体
	 */
	@Test
	public void testContains()
	{
		Person person = new Person();
		boolean flag = entityManager.contains(person);
		System.out.println(flag);   //false
		
		Person person2 = entityManager.find(Person.class, 7);
		boolean flag2 = entityManager.contains(person2);
		System.out.println(flag2);   //true
	}
}
