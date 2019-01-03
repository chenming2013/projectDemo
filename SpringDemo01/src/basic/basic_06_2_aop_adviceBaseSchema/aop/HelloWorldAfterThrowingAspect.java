package basic.basic_06_2_aop_adviceBaseSchema.aop;

import org.springframework.stereotype.Component;

/**
 * 后置异常通知实现定义类
 * @author 陈明
 * @date 2018年12月18日
 */
@Component
public class HelloWorldAfterThrowingAspect {

	public void afterThrowingAdvice1() {
		System.out.println("1.HelloWorldAfterThrowingAspect...afterThrowingAdvice1()...");
	}
	
	public void afterThrowingAdvice2(ArithmeticException arithException) {
		System.out.println("2.HelloWorldAfterThrowingAspect...afterThrowingAdvice2()...,arithException:"+arithException);
	}
	
}
