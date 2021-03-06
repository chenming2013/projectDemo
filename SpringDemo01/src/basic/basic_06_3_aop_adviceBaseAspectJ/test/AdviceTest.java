package basic.basic_06_3_aop_adviceBaseAspectJ.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import basic.basic_06_3_aop_adviceBaseAspectJ.service.BusinessService;


/**
 * 测试几种通知
 * @author 陈明
 * @date 2018年11月29日
 */

public class AdviceTest {

	private static BusinessService bean;
	
	@BeforeClass
	public static void beforeClass() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:basic/basic_06_3_aop_adviceBaseAspectJ/advice*.xml");
		bean = context.getBean("businessServiceImpl",BusinessService.class);
	}
	
	@Test
	public void testMethod1() {
		bean.doBusiness_1();
	}
	
	@Test
	public void testMethod2() {
		bean.doBusiness_2("cm");
	}
	
	@Ignore
	@Test
	public void testMethod3() {
		bean.doBusiness_5(1001);
	}
}
