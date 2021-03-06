package basic.basic_06_3_aop_adviceBaseAspectJ.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 通知调用类
 * @author 陈明
 * @date 2018年11月29日
 */
@Component
@Aspect
public class BusinessAspect {

	/**
	 * 定义切入点
	 */
	/* 定义切入点一 */
	@Pointcut(value="execution(* basic.basic_06_3_aop_adviceBaseAspectJ..*.*(..))")
	public void pointcut1() {}
	/* 定义切入点二:  匹配basic.basic_06_3_aop_adviceBaseAspectJ下的带有一个参数,并且参数类型是java.lang.String的方法 */
	@Pointcut(value="execution(* basic.basic_06_3_aop_adviceBaseAspectJ..*.*(..)) && args(param)")
	public void pointcut2(String param) {}
	@Pointcut(value="execution(* basic.basic_06_3_aop_adviceBaseAspectJ..*.*(..)) && args(param)")
	public void pointcut3(Integer param) {}
	
	/**
	 *前置通知
	 */
	/* 前置通知一  */
	@Before(value="pointcut1()")
	public void beforeAdvice1() {
		System.out.println("1.BusinessAspect...beforeAdvice1()...");
	}
	/* 前置通知二  */
	@Before(value="pointcut2(param)",argNames="param")
	public void beforeAdvice2(String param) {
		System.out.println("2.BusinessAspect...beforeAdvice2(String str)...,param:"+param);
	}
	
	
}
