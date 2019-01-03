package basic.basic_03_4_dependsOn;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_4_dependsOn.bean.DependentBean;

public class DependsOnTest
{

	/**
	 * 测试denpends-on
	 * @throws IOException 
	 */
	@Test
	public void testDependsOn() throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_4_dependsOn/depends_on.xml");
		
		//一定要注册销毁回调,否则我们定义的销毁方法不执行
		context.registerShutdownHook();
		
		DependentBean bean = context.getBean("dependentBean",DependentBean.class);
		bean.write("aa");
	}
	
}
