package basic.basic_03_6_dependencyCheck;


import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_5_autowireBean.bean.HelloApi;

public class DependencyCheckTest {
    
	/**
	 * 只检查引用类型数据是否注入了
	 * @throws IOException
	 */
    @SuppressWarnings("resource")
	@Test()
    public void testDependencyCheckByObject() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("basic/basic_03_6_dependencyCheck/dependency-check-object.xml");
    }

    /**
     * 只检查基本数据类型是否注入,包括数组
     * @throws IOException
     */
    @SuppressWarnings("resource")
	@Test()
    public void testDependencyCheckBySimple() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("basic/basic_03_6_dependencyCheck/dependency-check-simple.xml");
    }
   
    /**
     * 检查所有的属性是否注入了数据,如果没有将抛出异常
     * @throws IOException
     */
    @SuppressWarnings("resource")
	@Test()
    public void testDependencyCheckByAll() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("basic/basic_03_6_dependencyCheck/dependency-check-all.xml");
    }

    /**
     * Spring装配的时候指明不检查,所以Spring容器创建Bean的时候不会检查,只有在使用依赖数据的时候才会报空指针
     * @throws IOException
     */
    @SuppressWarnings("resource")
	public void testDependencyCheckByNone() throws IOException {
        //将抛出异常
        try {
        	ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_6_dependencyCheck/dependency-check-none.xml");
        	HelloApi bean = context.getBean("bean",HelloApi.class);
        	bean.sayHello();
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}

