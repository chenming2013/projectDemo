package basic.basic_06_2_aop_adviceBaseSchema.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_2_aop_adviceBaseSchema.service.HelloWorldService;

public class AfterReturningTest {

	private static HelloWorldService bean;
	
	@BeforeClass
	public static void beforeClass() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:basic/basic_06_2_aop_adviceBaseSchema/afterReturningAdvice.xml");
		
		bean = context.getBean("helloWorldServiceImpl",HelloWorldService.class);
	}
	
	@Test
	public void testMethod1() {
		bean.sayHello();
	}
	
	@Test
	public void testMethod2() {
		bean.sayHello2(2);
	}
	
	@Test
	public void testMethod3() {
		bean.sayHello3(2, "cm");
	}
	
	@Test
	public void testMethod4() {
		bean.sayHello5(5);
	}
	
}
