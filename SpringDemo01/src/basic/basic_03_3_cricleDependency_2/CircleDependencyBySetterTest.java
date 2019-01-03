package basic.basic_03_3_cricleDependency_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_3_cricleDependency_2.bean.CircleA;

/**
 * 测试Setter循环依赖(设置scope="singleton")
 * @author 陈明
 * @date   2018年8月20日
 */
public class CircleDependencyBySetterTest
{
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_3_cricleDependency_2/circleDependencyBySetter.xml");
			CircleA beanA = context.getBean("circleA", CircleA.class);
			beanA.a();   //a...
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
