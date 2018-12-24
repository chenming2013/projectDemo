package basic.basic_04_4_injectResource;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import basic.basic_04_4_injectResource.bean.ResourceBean;


/**
 * 测试注入资源
 * @author 陈明
 * @date   2018年8月28日
 */
public class InjectResourceTest
{
	@SuppressWarnings("resource")
	@Test
	public void testInjectResource() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_04_4_injectResource/injectResource.xml");
		
		ResourceBean bean1 = context.getBean("bean1", ResourceBean.class);
		Resource resource1 = bean1.getResource();
		Assert.assertTrue(resource1 instanceof ClassPathResource);
		
		ResourceBean bean2 = context.getBean("bean2", ResourceBean.class);
		Resource resource2 = bean2.getResource();
		Assert.assertTrue(resource2 instanceof ClassPathResource);
		
		ResourceBean bean3 = context.getBean("bean3", ResourceBean.class);
		Resource resource3 = bean3.getResource();
		System.out.println(resource3.getFile().length());
	}
	
}
