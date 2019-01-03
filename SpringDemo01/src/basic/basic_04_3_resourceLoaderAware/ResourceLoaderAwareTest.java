package basic.basic_04_3_resourceLoaderAware;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

import basic.basic_04_3_resourceLoaderAware.bean.ResourceBean;
import junit.framework.Assert;


/**
 * 测试ResourceLoaderAware接口
 * @author 陈明
 * @date   2018年8月28日
 */
public class ResourceLoaderAwareTest
{
	@Test
	public void testResourceLoaderAware() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_04_3_resourceLoaderAware/resourceLoaderAware.xml");
		ResourceBean bean = context.getBean(ResourceBean.class);
		ResourceLoader resourceLoader = bean.getResourceLoader();
		Assert.assertTrue(resourceLoader instanceof ApplicationContext);
	}
	
}
