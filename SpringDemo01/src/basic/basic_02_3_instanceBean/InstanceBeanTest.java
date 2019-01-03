package basic.basic_02_3_instanceBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_02_3_instanceBean.bean.Hello;


/**
 * 测试实例化Bean的几种方式
 * 	1.使用构造器方式实例化Bean
 * 	2.使用静态工厂方式实例化Bean
 * 	3.使用实例工厂方法实例化Bean
 * @author 陈明
 * @date   2018年9月17日
 */
public class InstanceBeanTest
{

	/**
	 * 测试：使用构造器方式实例化Bean
	 * 		使用无参构造器
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInstanceBeanByConstructor_1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_3_instanceBean/hello.xml");
		Hello bean = context.getBean("bean1", Hello.class);
		System.out.println(bean.toString());   //{id:0,name:null,age:0}
	}
	
	/**
	 * 测试：使用构造器方式实例化Bean
	 * 		使用一个参数的构造器
	 */
	@Test
	public void testInstanceBeanByConstructor_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_3_instanceBean/hello.xml");
		Hello bean = context.getBean("bean2", Hello.class);
		System.out.println(bean.toString());   //{id:2013,name:null,age:0}
	}
	
	/**
	 * 测试：使用构造器方式实例化Bean
	 * 		使用三个参数的构造器
	 */
	@Test
	public void testInstanceBeanByConstructor_3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_3_instanceBean/hello.xml");
		Hello bean = context.getBean("bean3", Hello.class);
		System.out.println(bean.toString());   //{id:2013,name:chenming,age:24}
	}
	
	/**
	 * 测试：使用静态工厂实例化Bean
	 */
	@Test
	public void testInstanceBeanByStaticFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_3_instanceBean/hello.xml");
		Hello bean = context.getBean("bean4", Hello.class);
		System.out.println(bean.toString());   //{id:2013,name:chenming,age:24}
	}
	
	/**
	 * 测试：使用实例工厂实例化Bean
	 */
	@Test
	public void testInstanceBeanByInstanceFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_3_instanceBean/hello.xml");
		Hello bean = context.getBean("bean5", Hello.class);
		System.out.println(bean.toString());   //{id:2013,name:chenming,age:24}
	}
}
