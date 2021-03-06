package basic.basic_06_2_aop_adviceBaseSchema.aop;

import org.springframework.stereotype.Component;

/**
 * 后置最终通知 实现方法定义的类
 * @author 陈明
 * @date 2018年12月18日
 */
@Component
public class HelloWorldAfterFinallyAspect {

	public void afterFinallyAdvice1(Integer num){
		System.out.println("1.HelloWorldAfterFinallyAspect...afterFinallyAdvice1(Integer num)...,num:"+num);
	}
	
	public void adterFinallyAdvice2(Integer num,ArithmeticException arithException) {
		System.out.println("2.HelloWorldAfterFinallyAspect...adterFinallyAdvice1(Integer num,ArithmeticException arithException)...,num:"+num+",arithException:"+arithException);
	}
	
}
