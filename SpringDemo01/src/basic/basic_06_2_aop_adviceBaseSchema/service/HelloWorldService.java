package basic.basic_06_2_aop_adviceBaseSchema.service;

public interface HelloWorldService {

	public void sayHello();
	public void sayHello2(Integer num);
	public void sayHello3(Integer num,String str);
	public void sayHello4(Integer...num);
	
	
	
	public Integer sayHello5(Integer num);
	public Object sayHello6(Integer num,String str);
	

	
	
	public void sayHello7();
	public void sayHello8();
	
	
}