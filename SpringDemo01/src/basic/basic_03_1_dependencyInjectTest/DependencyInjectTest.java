package basic.basic_03_1_dependencyInjectTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_1_dependencyInjectTest.bean.Hello;

/**
 * 测试注入Bean所需要的依赖的几种方式
 * 	1.构造器注入,也就是在实例化Bean的同时注入Bean所需要的依赖资源
 * 	2.setter注入
 * 	3.方法注入
 * @author 陈明
 * @date   2018年9月18日
 */
public class DependencyInjectTest
{

	/**
	 * 测试通过构造器注入Bean依赖
	 */
	@Test
	public void testDependencyInjectByConstructor() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
        
        //获取根据参数索引依赖注入的Bean
        Hello byIndexBean = context.getBean("byIndex", Hello.class);
        System.out.println(byIndexBean.toString());  //{id:2013,name:chenming,age:24}

        //获取根据参数类型依赖注入的Bean
        Hello byTypeBean = context.getBean("byType", Hello.class);
        System.out.println(byTypeBean.toString());  //{id:2013,name:chenming,age:24}

        //获取根据参数名字依赖注入的Bean
        Hello byNameBean = context.getBean("byName", Hello.class);
        System.out.println(byNameBean.toString());  //{id:2013,name:chenming,age:24}
	}
	
	
	/**
	 * 测试通过静态工厂注入
	 */
	@Test
	public void testDependencyInjectByStaticFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
        Hello bean = context.getBean("dependencyInjectByStatic", Hello.class);
        System.out.println(bean.toString());  //{id:2013,name:chenming,age:24}
	}
	
	
	/**
	 * 测试通过实例工厂注入
	 */
	@Test
	public void testDependencyInjectByInstanceFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
        Hello bean = context.getBean("dependencyInjectByInstance", Hello.class);
        System.out.println(bean.toString());  //{id:2013,name:chenming,age:24}
	}
	
	
	/**
	 * 测试通过Setter注入
	 */
	@Test
	public void testDependencyBySetter() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
		Hello bean = context.getBean("dependencyInjectBySetter", Hello.class);
		System.out.println(bean.toString());  //{id:2013,name:chenming,age:24}
	}
	
}
