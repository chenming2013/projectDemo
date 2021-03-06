package basic.basic_06_0_aop_proxyOfSpring.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DynamicProxyHello implements InvocationHandler{

	private static final Logger logger = Logger.getLogger(DynamicProxyHello.class.getName());
	
	/**
	 * 要处理的对象,也就是我们要在方法的前后加上业务逻辑的对象,如例子中的HelloImpl
	 */
	private Object delegate;
	
	/**
	 * 动态方法生成被处理过后的对象(写法固定)
	 * @param delegate
	 * @return
	 */
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.getClass().getInterfaces(), this);
	}
	
	/**
	 * 要处理的对象中的每个方法都会被此方法送去JVM调用,也就是说,要处理的对象方法只能通过此方法调用
	 * 方法是动态的,不是手动调用的.
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			//执行原来的方法之前记录日志
			logger.log(Level.INFO, method.getName()+" method start...");
			
			//JVM通过这条语句来执行原来的方法(反射机制)
			result = method.invoke(this.delegate, args);
			
			//执行原来的方法之后记录日志
			logger.log(Level.INFO, method.getName()+" method end...");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Object getDelegate() {
		return delegate;
	}

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}
}
