package basic.basic_06_0_aop_proxy.bean;

public class HelloImpl implements Hello{

	/**
	 * 假设这是一个业务方法
	 * 	现在我想在这个业务方法执行的前后加上日志记录的业务,那么应该怎么做呢?
	 * 	1. 修改源码：
	 * 		这是一种方法,但却是非常不好的方法,因为一个系统中业务繁多,你不可能每一个方法里面都去加日志记录,而且如果以后不要日志记录,那岂不是每一个方法又要删除?
	 * 		又有相同的代码在许多方法中重复等等的问题,使得这个方法非常不好。
	 * 	2. 代理模式：
	 * 		我们生成类的代理类,在代理类中调用被代理类的方法
	 */
	@Override
	public void sayHello(String name) {
		System.out.println("hello "+name);
	}
}
