package basic.basic_06_2_aop_adviceBaseSchema.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_2_aop_adviceBaseSchema.service.HelloWorldService;

public class AfterThrowingTest {

	private static HelloWorldService bean;
	
	@BeforeClass
	public static void beforeClass() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:basic/basic_06_2_aop_adviceBaseSchema/afterThrowingAdvice.xml");
		bean = context.getBean("helloWorldServiceImpl",HelloWorldService.class);
	}
	
	@Test
	public void testMethod1() {
		bean.sayHello7();
	}
	
	@Test
	public void testMethod2() {
		bean.sayHello8();
	}
}
