package basic.basic_03_2_injectionTest;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.basic_03_2_injectionTest.bean.Hello;
import basic.basic_03_2_injectionTest.bean.HelloDecorator;
import basic.basic_03_2_injectionTest.bean.HelloImpl;
import basic.basic_03_2_injectionTest.bean.InjectionTestBean;

public class InjectionTest
{

	/**
	 * 测试注入八种基本数据类型之：注入byte常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionByte() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("btBean",InjectionTestBean.class);
		System.out.println(bean.getBt());		//100
	}

	/**
	 * 测试注入八种基本数据类型之：注入short常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionShort() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("stBean",InjectionTestBean.class);
		System.out.println(bean.getSt());		//256
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入int常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionInt() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("itBean",InjectionTestBean.class);
		System.out.println(bean.getIt());		//5
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入long常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionLong() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("lgBean",InjectionTestBean.class);
		System.out.println(bean.getLg());    //432
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入float常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionFloat() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("ftBean",InjectionTestBean.class);
		System.out.println(bean.getFt());		//432.34
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入double常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionDouble() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("deBean",InjectionTestBean.class);
		System.out.println(bean.getDe());    	//124.45
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入char常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionChar() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("crBean",InjectionTestBean.class);
		System.out.println(bean.getCr());    	//a
	}
	
	/**
	 * 测试注入八种基本数据类型之：注入boolean常量
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionBoolean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean1 = context.getBean("bnBean_1",InjectionTestBean.class);
		System.out.println(bean1.isBn());    	//true
		
		InjectionTestBean bean2 = context.getBean("bnBean_2",InjectionTestBean.class);
		System.out.println(bean2.isBn());    	//true
		
		InjectionTestBean bean3 = context.getBean("bnBean_3",InjectionTestBean.class);
		System.out.println(bean3.isBn());    	//true

		InjectionTestBean bean4 = context.getBean("bnBean_4",InjectionTestBean.class);
		System.out.println(bean4.isBn());    	//true
	}
	

	
	
	/**
	 * 测试注入Bean ID
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionBeanID() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("idrefBean1",InjectionTestBean.class);
		System.out.println(bean.getId());		//beanID_1
	}
	
	
	
	/**
	 * 注入引用数据类型之：注入List集合(简单List)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionList() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("listBean",InjectionTestBean.class);
		List<String> list = bean.getList();
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				if(i==list.size()-1) {
					System.out.print(list.get(i));
				}else {
					System.out.print(list.get(i)+",");
				}
			}
		}
		/**
		 * 输出结果: zhangsan,lisi,wangwu
		 */
	}
	
	/**
	 * 注入引用数据类型之：注入List集合(复杂List)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionList_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("listBean2",InjectionTestBean.class);
		List<List<String>> list2 = bean.getList2();
		if(list2!=null) {
			for(List<String> temp:list2) {
				for(String str:temp) {
					System.out.print(str+",");
				}
				System.out.println();
			}
		}
		/**
		 * 输出结果：
		 * 	1,2,3,
		 *	4,5,6,
		 */
	}
	
	
	/**
	 * 注入引用数据类型之：注入Set集合(简单Set)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionSet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("setBean",InjectionTestBean.class);
		Set<String> set = bean.getSet();
		if(set!=null) {
			Iterator<String> iterator = set.iterator();
			while(iterator.hasNext()) {
				String value = iterator.next();
				System.out.print(value+",");
			}
		}
		/**
		 * 输出结果: zhaoliu,qianqi,
		 */
	}
	
	
	/**
	 * 注入引用数据类型之：注入Set集合(复杂Set)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionSet_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("setBean2",InjectionTestBean.class);
		Set<Set<String>> set2 = bean.getSet2();
		if(set2!=null) {
			Iterator<Set<String>> iterator = set2.iterator();
			while(iterator.hasNext()) {
				Set<String> nextSet = iterator.next();
				Iterator<String> nextIterator = nextSet.iterator();
				while(nextIterator.hasNext()) {
					System.out.print(nextIterator.next()+",");
				}
				System.out.println();
			}
		}
		/**
		 * 输出结果:
		 *	1,2,
		 *	3,4,
		 */
	}
	
	
	/**
	 * 注入引用数据类型之：注入Collection集合
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionCollection() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("collectionBean",InjectionTestBean.class);
		Collection<String> collection = bean.getCollection();
		if(collection!=null) {
			Iterator<String> iterator = collection.iterator();
			while(iterator.hasNext()) {
				String value = iterator.next();
				System.out.print(value+",");
			}
		}
		
		/**
		 * 输出结果: zhaoliu,qianqi,
		 */
	}
	
	/**
	 * 注入引用数据类型之：注入数组(一维数组)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionArray() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("arrayBean",InjectionTestBean.class);
		String[] array = bean.getArray();
		if(array!=null) {
			for(int i=0;i<array.length;i++) {
				if(i==array.length-1) {
					System.out.print(array[1]);
				}else {
					System.out.print(array[1]+",");
				}
			}
		}
		/**
		 * 输出结果: qianqi,qianqi
		 */
	}
	
	/**
	 * 注入引用数据类型之：注入数组(二维数组)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionArray_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("arrayBean2",InjectionTestBean.class);
		String[][] array2 = bean.getArray2();
		System.out.println(array2.length);	//2
	}
	
	/**
	 * 注入引用数据类型之：注入Map(简单Map)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionMap() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("mapBean",InjectionTestBean.class);
		Map<Integer, String> map = bean.getMap();
		if(map!=null) {
			Set<Integer> keySet = map.keySet();
			Iterator<Integer> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				Integer key = iterator.next();
				String value = map.get(key);
				System.out.print("name:"+key+",value:"+value+",");
			}
		}
		/**
		 * 输出结果: name:2,value:xiaoer,name:3,value:zhangsan,
		 */
	}

	/**
	 * 注入引用数据类型之：注入Map(复杂Map)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionMap_2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("mapBean2",InjectionTestBean.class);
		Map<String, List<String>> map2 = bean.getMap2();
		
	}
	
	
	/**
	 * 注入引用数据类型之：注入Properties
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionProperties() {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/injection.xml");
		
		InjectionTestBean bean = context.getBean("propertiesBean",InjectionTestBean.class);
		Properties properties = bean.getProperties();
		System.out.println(properties.get("prop1"));		//1
	}
	
	
	/**
	 * 注入引用数据类型之：注入Properties
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionLocalAndParent() {
		
		//初始化父容器
		ApplicationContext parentContext = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/parentBeanInject.xml");
		
		//初始化当前容器
		ApplicationContext localContext = new ClassPathXmlApplicationContext(new String[] {"basic/basic_03_2_injectionTest/localBeanInject.xml"},parentContext);
		
		HelloDecorator bean = (HelloDecorator) localContext.getBean("bean1",Hello.class);
		HelloImpl helloImpl = (HelloImpl)bean.getHello();
		System.out.println(helloImpl.getIndex()+","+helloImpl.getMessage());
		bean.sayHello();
		
		HelloDecorator bean2 = (HelloDecorator) localContext.getBean("bean2",Hello.class);
		HelloImpl helloImpl2 = (HelloImpl)bean2.getHello();
		System.out.println(helloImpl2.getIndex()+","+helloImpl2.getMessage());
		bean2.sayHello();
	}
	
	
	/**
	 * 测试注入内部Bean
	 */
	@SuppressWarnings("resource")
	@Test
	public void testInjectionInnerBean() {
		//初始化IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("basic/basic_03_2_injectionTest/Injection.xml");
		
		HelloDecorator bean = context.getBean("innerBean",HelloDecorator.class);
		HelloImpl helloImpl = (HelloImpl)bean.getHello();
		System.out.println(helloImpl.getIndex()+","+helloImpl.getMessage());	//1,hello inner
	}
	
	
}
