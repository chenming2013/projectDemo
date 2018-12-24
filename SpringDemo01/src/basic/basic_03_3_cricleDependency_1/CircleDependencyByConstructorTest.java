package basic.basic_03_3_cricleDependency_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试构造器循环依赖
 * @author 陈明
 * @date   2018年8月20日
 */
public class CircleDependencyByConstructorTest
{
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_3_cricleDependency_1/circleDependencyByConstructor.xml");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
