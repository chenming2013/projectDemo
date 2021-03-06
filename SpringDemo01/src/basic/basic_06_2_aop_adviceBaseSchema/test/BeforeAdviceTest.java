package basic.basic_06_2_aop_adviceBaseSchema.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_2_aop_adviceBaseSchema.service.HelloWorldService;

public class BeforeAdviceTest {

	private static HelloWorldService bean;
	
	@BeforeClass
	public static void beforeClass() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_2_aop_adviceBaseSchema/beforeAdvice.xml");
		bean = context.getBean(HelloWorldService.class);
	}
	
	
	/**
	 * 测试无参前置通知
	 */
	@Test
	public void testMethod1() {
		bean.sayHello();
		/**
		 * 输出:
		 *  1. HelloWorldBeforeAspect...beforeAdvice1()...,no params...
		 *	HelloWorldServiceImpl...sayHello()...,no params...
		 */
	}

	/**
	 * 测试一个参数前置通知
	 */
	@Test
	public void testMethod2() {
		bean.sayHello2(2);
		/**
		 * 输出:
		 *  1. HelloWorldBeforeAspect...beforeAdvice1()...,no params...
		 *	2. HelloWorldBeforeAspect...beforeAdvice2(Integer num),num:2
		 *	HelloWorldServiceImpl...sayHello2(Integer num)...,num:2
		 */
	}
	
	/**
	 * 测试两个参数前置通知
	 */
	@Test
	public void testMethod3() {
		bean.sayHello3(2, "cm");
		/**
		 * 输出
		 *  1. HelloWorldBeforeAspect...beforeAdvice1()...,no params...
		 *	3. HelloWorldBeforeAspect...beforeAdvice3(Integer num,String str),num:2,str:cm
		 *	HelloWorldServiceImpl...sayHello2(Integer num,String str)...,num:2,str:cm
		 */
	}
	
	/**
	 * 测试不定参数前置通知
	 */
	@Test
	public void testMethod4() {
		bean.sayHello4(2,3,4);
		/**
		 * 输出:
		 *  1. HelloWorldBeforeAspect...beforeAdvice1()...,no params...
		 *	4. HelloWorldBeforeAspect...beforeAdvice4(Integer...num),num:[Ljava.lang.Integer;@2ceb80a1
		 *	6. HelloWorldBeforeAspect...beforeAdvice6(Object num),num:[Ljava.lang.Integer;@2ceb80a1
		 *	HelloWorldServiceImpl...sayHello2(Integer... num)...,num:[Ljava.lang.Integer;@2ceb80a1
		 */
	}
	
}
