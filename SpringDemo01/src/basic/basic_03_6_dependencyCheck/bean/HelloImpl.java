package basic.basic_03_6_dependencyCheck.bean;

public class HelloImpl implements HelloApi {

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
    
    public void destroy() {
        System.out.println("de");
    }
}
