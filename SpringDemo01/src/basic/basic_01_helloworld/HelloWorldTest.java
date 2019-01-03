package basic.basic_01_helloworld;

<<<<<<< HEAD
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_01_helloworld.bean.HelloApi;
=======
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import basic.basic_01_helloworld.bean.HelloApi;
import basic.basic_02_1_getIOCContainer.bean.Hello;
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
import junit.framework.TestCase;

/**
 * 这个类是helloworld测试
 * @author 陈明
 * @date   2018年8月8日
 */
public class HelloWorldTest extends TestCase
{

	@Test
<<<<<<< HEAD
	public void testHelloWorld() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("/basic/basic_01_helloworld/helloApi.xml");
=======
	public void testMethod() {
		//1.定位资源
		ClassPathResource resource = new ClassPathResource("basic/basic_02_3_instanceBean/hello.xml");
		//2.读取并解析资源
		//2.1 定义资源解析器： DefaultListableBeanFactory实现了BeanDefinitionRegistry接口
		//该带参的构造方法表明将解析后的BeanDefinition注册到哪个Bean工厂中
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
		//2.2 装载并解析资源
		beanDefinitionReader.loadBeanDefinitions(new EncodedResource(resource));
		/**
		 * 流程解释:
		 * 	1. Resource接口定位到外部资源文件: hello.xml
		 *  2. BeanDefinitionReader接口读取、解析Resource资源定位到的外部资源文件,并将 hello.xml 配置文件中的<bean></bean>节点解析成一个个的BeanDefinition对象
		 *  3. 将这些BeanDefinition对象注册到DefaultListableBeanFactory对象中的Map中,注册之后的Bean能够被以后使用
		 */
	}
	
	@Test
	public void testHelloWorld() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_01_helloworld/helloApi.xml");
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
		
		//从容器中获取Bean,注意:此处完全"面向接口编程,而不是面向实现"
		HelloApi bean = context.getBean("hello",HelloApi.class);
		
		bean.syaHello();
	}
<<<<<<< HEAD
	
=======

>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
}
