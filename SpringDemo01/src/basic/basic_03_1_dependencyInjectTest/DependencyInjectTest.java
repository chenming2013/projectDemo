package basic.basic_03_1_dependencyInjectTest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jms.MessageNotWriteableException;

import basic.basic_02_1_getIOCContainer.bean.HelloImpl;
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

	@Test
	public void testMethod() {
		//1.定位资源
		ClassPathResource resource = new ClassPathResource("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
		//2.读取并解析资源
		//2.1 定义资源解析器： DefaultListableBeanFactory实现了BeanDefinitionRegistry接口
		//该带参的构造方法表明将解析后的BeanDefinition注册到哪个Bean工厂中
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
		//2.2 装载并解析资源
		beanDefinitionReader.loadBeanDefinitions(new EncodedResource(resource));
		
		/**
		 * 流程解释:
		 * 	1. Resource接口定位到外部资源文件: dependencyInject.xml
		 *  2. BeanDefinitionReader接口读取、解析Resource资源定位到的外部资源文件,并将 dependencyInject.xml 配置文件中的<bean></bean>节点解析成一个个的BeanDefinition对象
		 *  3. 将这些BeanDefinition对象注册到DefaultListableBeanFactory对象中的Map中,注册之后的Bean能够被以后使用
		 */
	}
	
	@Test
	public void testMethod2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_1_dependencyInjectTest/dependencyInject.xml");
		
		basic.basic_03_1_dependencyInjectTest.bean.HelloImpl bean1 = context.getBean("byIndex",basic.basic_03_1_dependencyInjectTest.bean.HelloImpl.class);

		basic.basic_03_1_dependencyInjectTest.bean.HelloImpl bean2 = context.getBean("byIndex",basic.basic_03_1_dependencyInjectTest.bean.HelloImpl.class);
		
		System.out.println(bean1==bean2);	//true
		
	}
	
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
