package basic.basic_06_4_aop_adviceOrder.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_4_aop_adviceOrder.service.BusinessService;

/**
 * 测试几种通知
 * @author 陈明
 * @date 2018年11月29日
 */
public class AdviceTest {

	/**
	 * 测试前置通知
	 */
	@Test
	public void testMethod_1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_2_aop_advice/advice.xml");
		BusinessService bean = context.getBean("businessService", BusinessService.class);
		//处理业务1
		bean.doBusiness_1();
		//处理业务2
		bean.doBusiness_2("cm");
	}
	
	
	/**
	 * 测试后置通知
	 */
	@SuppressWarnings("resource")
	@Test
	public void testMethod_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_2_aop_advice/advice.xml");
		BusinessService bean = context.getBean("businessService", BusinessService.class);
		//处理业务3
		String returnValue = bean.doBusiness_3("cm");
	}
	
	
	/**
	 * 测试后置异常通知
	 */
	@Test
	public void testMehod_3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_2_aop_advice/advice.xml");
		BusinessService bean = context.getBean("businessService", BusinessService.class);
		//处理业务4
		bean.doBusiness_4("cm");
		System.out.println("上面的代码不会触发后置异常通知,下面的代码触发后置异常通知");
		bean.doBusiness_4(null);
	}
	
	/**
	 * 测试环绕通知
	 */
	@Test
	public void testMethod_4() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_2_aop_advice/advice.xml");
		BusinessService bean = context.getBean("businessService", BusinessService.class);
		//处理业务5
		bean.doBusiness_5(55);
	}
	
}
