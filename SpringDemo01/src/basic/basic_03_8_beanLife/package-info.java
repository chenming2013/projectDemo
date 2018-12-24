/**
 * 
 * 这个包是测试Bean的生命周期
 * 
 * 生命周期:
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
package basic.basic_03_8_beanLife;