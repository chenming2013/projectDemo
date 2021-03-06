package basic.basic_06_0_aop_proxyOfSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_06_0_aop_proxyOfSpring.bean.DynamicProxyHello;
import basic.basic_06_0_aop_proxyOfSpring.bean.Hello;



public class DynamicProxyTest {

	@Test
	public void testProxy() {
		
		//获取应用上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_06_0_aop_proxyOfSpring/hello.xml");
		
		DynamicProxyHello bean = context.getBean("helloProxy",DynamicProxyHello.class);
		Hello hello = context.getBean("hello",Hello.class);
		
		bean.bind(hello);
	}
	
}
