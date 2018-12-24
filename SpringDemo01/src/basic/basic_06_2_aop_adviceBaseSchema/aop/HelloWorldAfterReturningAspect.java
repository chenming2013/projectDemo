package basic.basic_06_2_aop_adviceBaseSchema.aop;

import java.util.Arrays;

import org.springframework.stereotype.Component;

/**
 * 后置返回通知实现定义类
 * @author 陈明
 * @date 2018年12月18日
 */
@Component
public class HelloWorldAfterReturningAspect {

	public void afterReturningAdvice1() {
		System.out.println("1. HelloWorldAfterReturningAspect...afterReturningAdvice1()...");
	}
	
	public void afterReturningAdvice2(Integer num) {
		System.out.println("2. HelloWorldAfterReturningAspect...afterReturningAdvice2(Integer num)...,num:"+num);
	}
	
	public void afterReturningAdvice3(Integer num,String str) {
		System.out.println("3. HelloWorldAfterReturningAspect...afterReturningAdvice3(Integer num,String str)...,num:"+num+",str:"+str);
	}
	
	public void afterReturingAdvice4(Integer... num) {
		System.out.println("4. HelloWorldAfterReturningAspect...afterReturingAdvice4(Integer... num)...,num:"+Arrays.toString(num));
	}
	
	
	public void afterReturningAdvice5(Object obj) {
		System.out.println("5. HelloWorldAfterReturningAspect...afterReturningAdvice5(Object obj)...,obj:"+obj);
	}
	
	public String afterReturningAdvice6(Object obj) {
		System.out.println("6. HelloWorldAfterReturningAspect...adterReturningAdvice6(Object obj)...,obj:"+obj);
		return "";
	}
	
}
