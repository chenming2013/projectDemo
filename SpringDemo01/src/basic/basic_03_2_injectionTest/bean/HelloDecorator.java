package basic.basic_03_2_injectionTest.bean;


public class HelloDecorator implements Hello {
    
    private Hello hello;
    
    private String message;
    
    public HelloDecorator() {
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public HelloDecorator(Hello hello) {
        this.hello = hello;
    }
    
    public Hello getHello()
	{
		return hello;
	}

	public void setHello(Hello hello)
	{
		this.hello = hello;
	}

	public String getMessage()
	{
		return message;
	}

	@Override
    public void sayHello() {
        System.out.println("HelloDecorator");
        hello.sayHello();
    }
    
}
