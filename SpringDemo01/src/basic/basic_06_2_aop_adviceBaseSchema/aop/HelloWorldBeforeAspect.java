package basic.basic_06_2_aop_adviceBaseSchema.aop;

import java.util.Arrays;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;

/**
 * 前置通知 实现定义类
 * @author 陈明
 * @date 2018年12月17日
 */
@Component
public class HelloWorldBeforeAspect {

	/**
	 * 前置通知一,无参数
	 */
	public void beforeAdvice1() {
		System.out.println("1. HelloWorldBeforeAspect...beforeAdvice1()...,no params...");
	}
	
	/**
	 * 前置通知二,带有一个参数
	 * @param num
	 */
	public void beforeAdvice2(Integer num) {
		System.out.println("2. HelloWorldBeforeAspect...beforeAdvice2(Integer num),num:"+num);
	}
	
	/**
	 * 前置通知三,带有两个参数
	 * @param num
	 * @param str
	 */
	public void beforeAdvice3(Integer num,String str) {
		System.out.println("3. HelloWorldBeforeAspect...beforeAdvice3(Integer num,String str),num:"+num+",str:"+str);
	}
	
	/**
	 * 前置通知四,带有不定参数
	 * @param num
	 */
	public void beforeAdvice4(Integer...num) {
		System.out.println("4. HelloWorldBeforeAspect...beforeAdvice4(Integer...num),num:"+num);
	}
	
	
	/**
	 * 前置通知五
	 * @param num
	 */
	public void beforeAdvice5(Object num) {
		System.out.println("5. HelloWorldBeforeAspect...beforeAdvice5(Object num),num:"+num);
	}
	
	/**
	 * 前置通知六
	 * @param num
	 * @return
	 */
	public int beforeAdvice6(Object ...num) {
		System.out.println("6. HelloWorldBeforeAspect...beforeAdvice6(Object num),num:"+num);
		return 1;
	}
	
}
