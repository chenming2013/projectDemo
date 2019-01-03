package com.chenming.core.serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 测试java序列化对象：
 * 	这里测试java默认序列化机制：
 * 		1.如果仅仅是让某个类实现Serializable接口,而没有其他任何处理的话,则就是使用默认序列化机制。
 * 		2.使用默认机制,在序列化对象时,不仅会序列化当前对象本身,还会对该对象引用的其他序列化对象也进行序列化,
 * 		    同样的,这些其他对象引用的另外对象也将被序列化,以此类推。
 * 		3.所以,如果一个对象包含的成员变量是容器类对象,而这些容器所含有的元素也是容器类对象,那么这个序列化的过程将会较复杂,开销也较大。
 * @author Lenovo
 *
 */
public class SerializableTest01
{
	public static void main(String[] args)
	{
		try
		{
			/**
			 * 将对象序列化到文件中
			 */
			File file = new File("person.out");
			OutputStream os = new FileOutputStream(file);
			
			//ObjectOutputStream类是专门用来将对象序列化的
			ObjectOutputStream oos = new ObjectOutputStream(os);
	
			//创建要序列化的对象
			Person person = new Person("chenming",23,Gender.MALE);
			//将要序列化的对象写入到字节流中
			oos.writeObject(person);
			oos.close();
			
			
			/**
			 * 从文件中反序列化出对象
			 */
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			Object obj = ois.readObject();
			Person entity = (Person)obj;
			System.out.println(entity);
			/**
			 * 此时必须注意的是：
			 * 	1.当重新读取被保存的Person对象的时候,并没有调用Person的构造方法,看起来就好像是直接使用字节将对象还原出来的。
			 * 	2.当Person对象被保存到person.out文件中后,我们可以在其它地方去读取该文件以还原对象,
			 *    但必须确保读取程序的classpath包含有Person.class文件(哪怕在读取Person对象时并没有显示的使用Person类),否则会报ClassNotFoundException
			 */
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}	