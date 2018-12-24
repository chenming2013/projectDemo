package basic.basic_06_1_aop_helloworld.service;

/**
 * 业务逻辑 实现类,也是我们AOP的目标对象
 * @author 陈明
 * @date 2018年11月28日
 */
public class HelloWorldServiceImpl implements HelloWorldService{

	/**
	 * 目标方法
	 */
	@Override
	public void sayHello() {
		System.out.println("HelloWorldServiceImpl...sayHello()...");
	}

}
