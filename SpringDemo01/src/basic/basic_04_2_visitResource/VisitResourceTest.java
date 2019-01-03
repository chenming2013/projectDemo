package basic.basic_04_2_visitResource;

import java.io.IOException;

<<<<<<< HEAD
=======
import javax.swing.plaf.synth.SynthStyle;

>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import junit.framework.Assert;

/**
 * 测试访问资源
 * @author 陈明
 * @date   2018年8月28日
 */
public class VisitResourceTest
{
	
	/**
	 * 测试使用默认的ResourceLoader加载资源
<<<<<<< HEAD
	 */
	@Test
    public void testResourceLoad() {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("classpath:basic/basic_04_2_visitResource/test1.txt");
=======
	 * @throws IOException 
	 */
	@Test
    public void testResourceLoad() throws IOException {
		ResourceLoader loader = new DefaultResourceLoader();
 
		Resource resource = loader.getResource("classpath:basic/basic_04_2_visitResource/test1.txt");
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
        //验证返回的是ClassPathResource
        System.out.println(resource.getClass());  //class org.springframework.core.io.ClassPathResource
        Assert.assertEquals(ClassPathResource.class, resource.getClass());
        System.out.println(resource.getFilename());  //test1.txt
        
        Resource resource2 = loader.getResource("file:basic/basic_04_2_visitResource/test1.txt");
        //验证返回的是ClassPathResource
        Assert.assertEquals(UrlResource.class, resource2.getClass());
        
        Resource resource3 = loader.getResource("basic/basic_04_2_visitResource/test1.txt");
        //验证返默认可以加载ClasspathResource
        Assert.assertTrue(resource3 instanceof ClassPathResource);
        
<<<<<<< HEAD
=======
        
        Resource resource4 = loader.getResource("F:\\chenming\\APP\\WorkSpace\\SpringDemo01\\src\\basic\\basic_04_2_visitResource\\test1.txt");
        Assert.assertTrue(resource4 instanceof ClassPathResource);
        
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
    }
	
	/**
	 * 测试使用ClassPathXmlApplicationContext加载资源
<<<<<<< HEAD
=======
	 * 	ClassPathXmlApplicationContext实现了ResourceLoader接口
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	@Test
	public void testResourceLoader_2() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		Resource resource = context.getResource("basic/basic_04_2_visitResource/test1.txt");
		System.out.println(resource.getFile().length());   //17个字节
	}
	
	/**
	 * 测试使用FileSystemXmlApplicationContext加载资源
<<<<<<< HEAD
=======
	 * 	FileSystemXmlApplicationContext实现了ResourceLoader接口
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
	 * 	注意: 文件系统必须使用绝对路径
	 * @throws IOException 
	 */
	@Test
	public void testResourceLoader_3() throws IOException {
		FileSystemXmlApplicationContext loader = new FileSystemXmlApplicationContext();
<<<<<<< HEAD
		Resource resource = loader.getResource("F:\\Eclipse\\WorkSpace\\SpringDemo01\\src\\basic\\basic_04_2_visitResource\\test1.txt");
=======
		Resource resource = loader.getResource("F:\\chenming\\APP\\WorkSpace\\SpringDemo01\\src\\basic\\basic_04_2_visitResource\\test1.txt");
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
		System.out.println(resource.getFile().length());  //17
		Assert.assertEquals(FileSystemResource.class, resource.getClass());
		loader.close();
	}
	
}
