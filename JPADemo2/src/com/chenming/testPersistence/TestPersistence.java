package com.chenming.testPersistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 这是测试使用 Persistence 类创建EntityManagerFactory
 * 
 * @author Lenovo
 *
 */
public class TestPersistence
{
	public static void main(String[] args)
	{
		/**
		 * 创建EntityManagerFactory接口要通过Persistence的静态方法 createEntityManagerFactory
		 * 而这个方法有两种实现方式：
		 * 	1. static EntityManagerFactory createEntityManagerFactory(String persistenceUnitName)
		 * 	2. static EntityManagerFactory createEntityManagerFactory(String persistenceUnitName, Map properties)
		 * 第一个参数 persistenceUnitName 就是persistence.xml文件中配置的持久化单元的名字,本项目配置的是 JPADemo2
		 * 第二个参数 properties 是设置的JPA的相关属性
		 * 
		 * 之前的JPA项目中都是使用第一种方式,本案例是测试第二种方法
		 */
		
		//通过Persistence类的静态方法创建EntityManagerFactory
		Map<String,Object> properties = new HashMap<String,Object>();
		/**
		 * 我们在 persistence.xml文件中配置了  <property name="hibernate.format_sql" value="true"/>
		 * 这个节点是将 控制台输出的SQL格式化
		 * 现在我们将这个 <property> 节点配进 Map中,
		 */
		properties.put("hibernate.format_sql", false);  //配置之后,控制台会输出SQL,但是不会格式化SQL
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo2", properties);
		
		//后面的操作就不继续了
	}
}
