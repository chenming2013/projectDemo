package basic.basic_06_1_aop_helloworld.aop;

/**
 * 切面通知实现类
 * @author 陈明
 * @date 2018年11月28日
 */
public class HelloWorldAspect {
	
	/**
	 * 前置通知
	 */
	public void beforeAdvice() {
		System.out.println(">>>>>>>>>>>前置通知");
	}
	
	/**
	 * 后置返回通知
	 */
	public void afterReturningAdvice() {
		System.out.println(">>>>>>>>>后置返回通知");
	}
	
	/**
	 * 后置异常通知
	 */
	public void afterThrowingAdvice() {
		System.out.println(">>>>>>>>>后置异常通知");
	}
	
	/**
	 * 后置最终通知
	 */
	public void afterFinallyAdvice() {
		System.out.println(">>>>>>>>>后置最终通知");
	}
	
}
