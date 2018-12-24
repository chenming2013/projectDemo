package basic.basic_06_0_aop_proxyOfSpring.bean;

public class HelloImpl implements Hello{

	
	@Override
	public void sayHello(String name) {
		System.out.println("hello "+name);
	}

	@Override
	public void sayGoodbye(String name) {
		System.out.println(name+" GoodBye!");
	}
}
