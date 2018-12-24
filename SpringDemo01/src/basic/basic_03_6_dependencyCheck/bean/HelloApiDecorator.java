package basic.basic_03_6_dependencyCheck.bean;

public class HelloApiDecorator implements HelloApi {
    
    private HelloApi helloApi;
    
    private String message;
    
    public HelloApiDecorator() {
    	System.out.println("empty Constructor...");
    }
    public HelloApiDecorator(HelloApi helloApi) {
        System.out.println("One param Constructor...");
    	this.helloApi = helloApi;
    }
    
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setHelloApi(HelloApi helloApi) {
        this.helloApi = helloApi;
    }
    
    @Override
    public void sayHello() {
        System.out.println("==========装饰开始===========");
        if(helloApi!=null) {
        	helloApi.sayHello();
        }else {
        	System.out.println("helloApi is null...");
        }
        System.out.println("==========装饰完毕===========");
    }
    
}
