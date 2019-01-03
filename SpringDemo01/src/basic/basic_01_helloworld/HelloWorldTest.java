package basic.basic_01_helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_01_helloworld.bean.HelloApi;
import junit.framework.TestCase;

/**
 * 这个类是helloworld测试
 * @author 陈明
 * @date   2018年8月8日
 */
public class HelloWorldTest extends TestCase
{

	@Test
	public void testHelloWorld() {
		//读取配置文件,实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("/basic/basic_01_helloworld/helloApi.xml");
		
		//从容器中获取Bean,注意:此处完全"面向接口编程,而不是面向实现"
		HelloApi bean = context.getBean("hello",HelloApi.class);
		
		bean.syaHello();
	}
	
}
