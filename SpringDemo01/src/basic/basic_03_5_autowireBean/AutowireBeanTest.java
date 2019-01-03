package basic.basic_03_5_autowireBean;


import java.io.IOException;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_5_autowireBean.bean.HelloApi;
import basic.basic_03_5_autowireBean.bean.ListBean;


public class AutowireBeanTest {
    
	/**
	 * 测试"byName"的方式自动装配
	 * @throws IOException
	 */
    @Test
    public void testAutowireByName() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byName.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    /**
     * 测试 "byType"的方式自动装配
     * @throws IOException
     */
    @Test
    public void testAutowireByType1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byType1.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    /**
     * 测试"byType"的方式自动装配Bean
     * 	如果找到多个Bean,如果不另做处理的话,会报错,
     * 	所以,这里设置autowire-candidate="false"来将匹配的Bean从候选者中移除
     * @throws IOException
     */
    @Test
    public void testAutowireByType2_1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byType2-1.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }
    
    /**
     * 测试"byType"的方式自动装配Bean
     * 	如果找到多个Bean,如果不另做处理的话,会报错,
     * 	所以,这里设置primary="true"来使该Bean称为候选者中的首选Bean
     * @throws IOException
     */
    @Test
    public void testAutowireByType2_2() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byType2-2.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }
    
    /**
     * 
     * @throws IOException
     */
    @Test
    public void testAutowireByType2_3() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byType2-2.xml");
        ListBean listBean = context.getBean("listBean", ListBean.class);
        //对于集合接口根据类型注入将自动查找所有匹配的注入
        Assert.assertTrue(listBean.getList1().size() > 0);
        //对于集合具体类型将根据具体类型进行注入，而不是选择所有泛型类型信息匹配的Bean
        Assert.assertTrue(listBean.getList2() == null);
    }

    /**
     * 构造器装配
     * @throws IOException
     */
    @Test
    public void testAutowireByConstructor() throws IOException {
<<<<<<< HEAD
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byConstructor.xml");
=======
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-byConstructor.xml");
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    
<<<<<<< HEAD
=======
    /**
     * 自动检测装配
     * @throws IOException
     */
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
    @Test
    public void testAutowireByAutoDetect() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_5_autowireBean/autowire-autodetect.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }
    
   
}

