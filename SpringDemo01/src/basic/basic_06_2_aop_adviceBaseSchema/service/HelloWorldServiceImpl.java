package basic.basic_06_2_aop_adviceBaseSchema.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public void sayHello() {
		System.out.println("HelloWorldServiceImpl...sayHello()...,no params...");
	}

	@Override
	public void sayHello2(Integer num) {
		System.out.println("HelloWorldServiceImpl...sayHello2(Integer num)...,num:"+num);
	}

	@Override
	public void sayHello3(Integer num, String str) {
		System.out.println("HelloWorldServiceImpl...sayHello2(Integer num,String str)...,num:"+num+",str:"+str);
	}

	@Override
	public void sayHello4(Integer... num) {
		System.out.println("HelloWorldServiceImpl...sayHello2(Integer... num)...,num:"+num);
	}

	@Override
	public Integer sayHello5(Integer num) {
		System.out.println("HelloWorldServiceImpl...sayHello5(Integer... num)...,num:"+num);
		return (int)Math.pow(num, 2);
	}

	@Override
	public Object sayHello6(Integer num, String str) {
		System.out.println("HelloWorldServiceImpl...sayHello6(Integer num, String str)...,num:"+num+",str:"+str);
		return "{num:"+num+",str:\""+str+"\"}";
	}

	@Override
	public void sayHello7() {
		System.out.println("HelloWorldServiceImpl...sayHello7()...");
	}

	@Override
	public void sayHello8() {
		System.out.println("HelloWorldServiceImpl...sayHello8()...");
		int result = 10 / 0;
	}
	
}
