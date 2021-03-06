package basic.basic_06_0_aop_proxy.bean;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 代理类
 * @author 陈明
 * @date 2018年12月13日
 */
public class HelloProxy implements Hello{

	private static final Logger logger = Logger.getLogger(HelloProxy.class.getName());
	
	private HelloImpl hello;
	
	public HelloImpl getHello() {
		return hello;
	}
	public void setHello(HelloImpl hello) {
		this.hello = hello;
	}


	@Override
	public void sayHello(String name) {
		
		//开始日志记录
		logger.log(Level.INFO, "sayHello method start...");
		
		//调用业务流程
		hello.sayHello(name);
		
		//结束日志记录
		logger.log(Level.INFO, "sayHello method end...");
	}

}
