package basic.basic_03_8_beanLife;



import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifeTest {
    
	@SuppressWarnings("resource")
	@Test
	public void testMethod1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_8_beanLife/beanLife.xml");
		context.close();
	}
}

