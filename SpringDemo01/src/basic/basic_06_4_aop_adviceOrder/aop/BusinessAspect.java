package basic.basic_06_4_aop_adviceOrder.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知调用类
 * @author 陈明
 * @date 2018年11月29日
 */
public class BusinessAspect {

	/**
	 * 前置通知1
	 */
	public void beforeAdvice() {
		System.out.println("============前置通知1");
	}
	/**
	 * 前置通知2
	 * @param str
	 */
	public void beforeAdvice_2(String str) {
		System.out.println("============前置通知2,str: "+str);
	}
	
	
	
	/**
	 * 后置通知1
	 */
	public void afterAdvice() {
		System.out.println("============后置通知1");
	}
	/**
	 * 后置通知2
	 */
	public void afterAdvice_2(String str) {
		System.out.println("============后置通知2,str: "+str);
	}
	
	

	/**
	 * 后置返回通知1
	 */
	public void afterReturningAdvice() {
		System.out.println("============后置返回通知1");
	}
	/**
	 * 后置返回通知2
	 */
	public void afterReturningAdvice_2(String str) {
		System.out.println("============后置返回通知2,str: "+str);
	}

	
	
	/**
	 * 后置异常通知
	 */
	public void afterThrowingAdvice(Exception e) {
		System.out.println("============后置异常通知");
	}
	
	
	
	/**
	 * 环绕通知
	 * @throws Throwable 
	 */
	public Object roundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("============环绕通知开始");
		Object returnValue = pjp.proceed(new Object[] {10});
		System.out.println("============环绕通知结束");
		return returnValue;
	}
	
}
