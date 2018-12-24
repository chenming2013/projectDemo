package basic.basic_06_1_aop_helloworld.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_1_aop_helloworld.service.HelloWorldService;

/**
 * 测试Spring表达式
 * @author 陈明
 * @date   2018年11月12日
 */
public class HelloWorldTest
{

	@SuppressWarnings("resource")
	@Test
	public void testHelloworld() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_1_aop_helloworld/helloworld.xml");
		HelloWorldService bean = context.getBean("helloWorldService", HelloWorldService.class);
		bean.sayHello();
	}
	
	
	
	
}
