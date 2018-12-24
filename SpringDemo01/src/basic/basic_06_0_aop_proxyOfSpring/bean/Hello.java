package basic.basic_06_0_aop_proxyOfSpring.bean;

public interface Hello {

	/**
	 * 业务方法A
	 * @param name
	 */
	void sayHello(String name);
	
	/**
	 * 业务方法B
	 * @param name
	 */
	void sayGoodbye(String name);
}
