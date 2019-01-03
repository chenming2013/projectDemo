package basic.basic_03_8_beanLife.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 测试Bean的生命周期
 * @author 陈明
 * @date 2018年12月12日
 * 
 * 	生命周期:
 * 	1.Spring对Bean进行实例化;
 * 	2.Spring将值和Bean的引用注入到Bean中
 * 	3.如果Bean实现了BeanNameAware接口,Spring将Bean的ID传递给setBeanName()方法
 * 	4.如果Bean实现了BeanFactoryAware接口,Spring将调用setBeanFactory()方法,将BeanFactory容器实例传入
 * 	5.如果Bean实现了ApplicationContextAware接口,Spring将调用setApplicationContext()方法,将Bean的应用上下文传入进来
 * 	6.如果Bean实现了BeanPostProcessor接口,Spring将调用它们的postProcessorBeforeInitialization()方法
 * 	7.如果Bean实现了InitializingBean接口,Spring接口将调用它们的afterPropertiesSet()方法
 * 	8.如果Bean实现了BeanPostProcessor接口,Spring将调用它们的postProcessorAfterInitialization()方法
 * 	9.此时Bean已经准备就绪了,可以被程序使用了,它们将一直驻留在应用上下文中,直到该应用上下文被销毁
 * 	10.如果Bean实现了DisposableBean接口,Spring将调用它的destory()方法。同样,如果Bean使用destroy-method声明了销毁方法,该方法也会被调用
 */
public class HelloImpl implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor,InitializingBean,DisposableBean {

	private String name;
	
	private String gender;
	
	private Integer age;
	
	
	public String getName() {
		System.out.println("HelloImpl...getName()...");
		return name;
	}

	public void setName(String name) {
		System.out.println("HelloImpl...setName()...,name: "+name);
		this.name = name;
	}

	public String getGender() {
		System.out.println("HelloImpl...getGender()...");
		return gender;
	}

	public void setGender(String gender) {
		System.out.println("HelloImpl...setGender()...,gender: "+gender);
		this.gender = gender;
	}

	public Integer getAge() {
		System.out.println("HelloImpl...getAge()...");
		return age;
	}

	public void setAge(Integer age) {
		System.out.println("HelloImpl...setAge()...,age: "+age);
		this.age = age;
	}

	public void myDestroy() {
		System.out.println("HelloImpl...myDestroy()...");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("HelloImpl...setBeanName()...,name: "+name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("HelloImpl...setBeanFactory()...,beanFactory: "+beanFactory.getClass());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("HelloImpl...setApplicationContext()...,applicationContext: "+applicationContext.getBeanDefinitionCount());
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("HelloImpl...setApplicationContext()...,bean: "+beanName.toString()+"beanName: "+beanName);
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("HelloImpl...setApplicationContext()...,bean: "+beanName.toString()+"beanName: "+beanName);
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("HelloImpl...afterPropertiesSet()...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("HelloImpl...destroy()...");
	}

}
