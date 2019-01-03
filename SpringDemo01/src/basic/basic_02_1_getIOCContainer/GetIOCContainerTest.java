package basic.basic_02_1_getIOCContainer;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import basic.basic_02_1_getIOCContainer.bean.Hello;

/**
 * 测试获取BeanFactory和ApplicationContext实例的方法
 * @author 陈明
 * @date   2018年9月11日
 */
public class GetIOCContainerTest
{
	/**
	 * 测试获取BeanFactory实例的方式一: 从classpath类路径下读取资源文件
	 */
	@Test
	public void testGetBeanFactoryBaseOnClasspath() {
		//1.准备配置文件，从当前类加载路径中获取配置文件
        Resource resource = new ClassPathResource("basic/basic_02_getIOCContainer/hello.xml");
        //2.初始化容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //2、从容器中获取Bean
        Hello hello = beanFactory.getBean("hello", Hello.class);
        //3、执行业务逻辑
        hello.sayHello();
	}

	/**
	 * 测试获取BeanFactory实例的方式二: 从文件系统中加载资源文件
	 */
	@Test
	public void testGetBeanFactoryBaseOnFileSystem() {
		//1.准备资源文件  F:\tempDirectory\SpringTest\SpringDemo01\basic_02_getIOCContainer.xml
		Resource resource = new FileSystemResource("F:\\tempDirectory\\SpringTest\\SpringDemo01\\basic_02_getIOCContainer.xml");
		//2.初始化容器
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		//3.从容器中获取Bean
		Hello hello = beanFactory.getBean("hello", Hello.class);
		//执行业务逻辑
		hello.sayHello();
	}
	
	/**
	 * 测试获取ApplicationContext实例的方式一：从当前类路径中获取配置文件
	 */
	@Test
	public void testGetApplicationContextBaseOnClasspath() {
		//1.准备配置文件，从当前类加载路径中获取配置文件
        //2.初始化容器
        ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_getIOCContainer/hello.xml");
        //3、从容器中获取Bean
        Hello hello = context.getBean("hello", Hello.class);
        //4、执行业务逻辑
        hello.sayHello();
	}
	
	/**
	 * 测试获取ApplicationContext实例的方式二: 从文件系统中获取配置文件
	 */
	@Test
	public void testGetApplicationContextBaseOnFileSystem() {
		//1.准备资源文件  F:\tempDirectory\SpringTest\SpringDemo01\basic_02_getIOCContainer.xml
		//2.初始化容器
		ApplicationContext context = new FileSystemXmlApplicationContext("F:\\tempDirectory\\SpringTest\\SpringDemo01\\basic_02_getIOCContainer.xml");
		//3、从容器中获取Bean
        Hello hello = context.getBean("hello", Hello.class);
        //4、执行业务逻辑
        hello.sayHello();
	}
}
