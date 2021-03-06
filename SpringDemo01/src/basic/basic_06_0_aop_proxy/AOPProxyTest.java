package basic.basic_06_0_aop_proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_0_aop_proxy.bean.Hello;


public class AOPProxyTest {

	@Test
	public void testProxy() {
		
		//获取应用上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_0_aop_proxy/hello.xml");
		
		Hello bean = context.getBean("helloProxy",Hello.class);
		
		bean.sayHello("cm");
		
	}
	
}
