package basic.basic_02_2_nameOfBean;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import basic.basic_02_2_nameOfBean.bean.Hello;
import junit.framework.TestCase;

/**
 * 这个是测试Bean的命名,根据不同的命名方式获取同一个Bean
 * @author 陈明
 * @date   2018年8月9日
 */
public class NameOfBeanTest extends TestCase
{

	/**
	 * 不指定ID,只配置全限定类名
	 */
	@Test
	public void testNameOfBean_1() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_1.xml");
		
		//从容器中获取Bean
		Hello hello = context.getBean(Hello.class);
		
		hello.sayHello();
	}
	
	
	/**
	 * 指定Id,通过Id获取Bean(Id必须在IOC容器中唯一)
	 */
	@Test
	public void testNameOfBean_2() {
		FileSystemResource resource = new FileSystemResource("resources/basic/basic_02_2_nameOfBean/hello_2.xml");
		
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		
		Hello hello = (Hello)beanFactory.getBean("hello2");
		
		hello.sayHello();
	}
	
	
	/**
	 * 指定name,这样name就是"标识符",必须在IOC容器中唯一
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testNameOfBean_3() {
		ClassPathResource resource = new ClassPathResource("/basic/basic_02_2_nameOfBean/hello_3.xml");
		
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		
		Hello hello = beanFactory.getBean("hello3", Hello.class);
		
		hello.sayHello();
	}
	
	/**
	 * 指定Id和name,Id就是标识符,name就是别名,id和name都必须在IOC容器中唯一
	 */
	@Test
	public void testNameOfBean_4_1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_4.xml");
		
		//根据Id获取Bean
		Hello hello = context.getBean("hello4_1",Hello.class);
		hello.sayHello();
		
		//获取hello4_1这个Bean的所有别名
		String[] aliases = context.getAliases("hello4_1");
		for(String aliase:aliases) {
			System.out.println("hello4_1这个Bean的别名："+aliase);
		}
		//hello4_1这个Bean的别名：alias1
		
		
		/**
		 * 根据name获取Bean
		 * 	没有Id的情况下,name就是唯一标识符;
		 * 	有Id的情况下,那么就是别名,也是唯一的。
		 */
		Hello hello2 = context.getBean("alias1",Hello.class);
		hello2.sayHello();
	}
	
	/**
	 * 指定Id和name,Id就是标识符,name就是别名,id和name都必须在IOC容器中唯一
	 * 如果Id和name一样,IOC容器能检测到,并消除冲突
	 */
	@Test
	public void testNameOfBean_4_2() {
		//初始化IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_4.xml");
		//获取Bean
		Hello hello = context.getBean("hello4_2", Hello.class);
		//执行业务逻辑
		hello.sayHello();
		
		/**
		 * 因为现在hello4_2的bean的Id和name一样,那么此时的别名就为0
		 * 
		 */
		String[] aliases = context.getAliases("hello4_2");
		System.out.println(aliases.length);  //0
	}
	
	/**
	 * 指定多个name,并且没有ID
	 */
	@Test
	public void testNameOfBean_5_1() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_5.xml");
		
		String[] aliases = context.getAliases("hello5_1");
		System.out.println(aliases.length); //4
		/**
		 * 输入结果为4:说明有4个别名
		 */
	}
	
	/**
	 * 指定多个name,但是有Id,并且Id与name不一样
	 */
	@Test
	public void testNameOfBean_5_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_5.xml");
		String[] aliases = context.getAliases("hello5_2");
		System.out.println(aliases.length);
		/**
		 * 输出结果为3：说明 alias5;alias6 alias7 都是别名
		 */
	}
	
	
	/**
	 * 指定多个name,但是有Id,并且Id与name一样
	 */
	@Test
	public void testNameOfBean_5_3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_5.xml");
		String[] aliases = context.getAliases("hello5_3");
		System.out.println(aliases.length);
		/**
		 * 输出结果为2,说明alias8 alias9当成了别名,而hello5_3当成了唯一标识符
		 */
	}
	
	
	
	/**
	 * 使用<alias>标签自定别名,别名也必须在IOC容器中唯一
	 */
	@Test
	public void testNameOfBean_6() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_02_2_nameOfBean/hello_6.xml");
				
		//获取别名
		String[] aliases = context.getAliases("hello6");
		System.out.println(aliases.length);   //2
	}
}
