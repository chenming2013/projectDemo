<<<<<<< HEAD
package basic.basic_03_5_autowireBean.bean;

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
=======
package basic.basic_03_5_autowireBean.bean;

public class HelloApiDecorator implements HelloApi {
    
    private HelloApi helloApi;
    
    private String message;
    
    public HelloApiDecorator(HelloApi helloApi) {
        System.out.println("One param Constructor...");
    	this.helloApi = helloApi;
    }
    
    
    public void setMessage(String message) {
        System.out.println("HelloApiDecorator...setMessage()...");
    	this.message = message;
    }
    
    public void setHelloApi(HelloApi helloApi) {
    	System.out.println("HelloApiDecorator...setHelloApi()...");
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
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
