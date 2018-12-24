package basic.basic_04_1_buildInResource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import junit.framework.Assert;

/**
 * 测试Resource内置实现
 * @author 陈明
 * @date   2018年8月28日
 */
public class BuildInResourceTest
{

	/**
	 * 测试ByteArrayResource
	 */
	@Test
	public void testByteArrayResource() {
		ByteArrayResource byteArrayResource = new ByteArrayResource("hello world".getBytes());
		if(byteArrayResource.exists()) {
			dumpStream(byteArrayResource);
		}
	}
	
	
	/**
	 * 测试InPutStreamResource
	 * 	因为InPutStream调用getInputStream()直接返回一个InputStream字节流,
	 *  所以没有关闭输入流之前只能读取一次该字节流
	 * @throws IOException 
	 */
	@Test
	public void testInputStreamResource() throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream("hello world".getBytes());
		InputStreamResource inputStreamResource = new InputStreamResource(bis);
		if(inputStreamResource.exists()) {
			dumpStream(inputStreamResource);
		}
		/**
		 * 如果再一次访问会报错,因为没有关闭输入流
		 */
		//dumpStream(inputStreamResource);
	}
	
	
	/**
	 * 测试FileSystemResource
	 * 因为isOpen永远返回false,说明每次Spring每次访问资源字后都会自动关闭资源,
	 * 所以我们不必显示的关闭资源
	 */
	@Test
	public void testFileSystemResource() {
		File file = new File("F:\\tempDirectory\\SpringTest\\basic_11_resource_FileSystemResourceTest.txt");
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		if(fileSystemResource.exists()) {
			dumpStream(fileSystemResource);
		}
		dumpStream(fileSystemResource);
		dumpStream(fileSystemResource);
	}
	
	

	/**
	 * 使用默认的加载器加载资源
	 * 	将加载当前ClassLoader类路径上相对于根路径的资源
	 * @throws IOException
	 */
	@Test
    public void testClasspathResourceByDefaultClassLoader() throws IOException {
        Resource resource = new ClassPathResource("basic/basic_04_1_buildInResource/testClassPathResource_1.properties");
        if(resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }
	
	
	/**
	 * 使用指定的ClassLoader进行加载资源
	 * 	将加载指定的ClassLoader类路径上相对于根路径的资源
	 * @throws IOException
	 */
	@Test
    public void testClasspathResourceByClassLoader() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        Resource resource = new ClassPathResource("basic/basic_04_1_buildInResource/testClassPathResource_1.properties" , cl);
        if(resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }
	
	
	/**
	 * 使用指定的类进行加载资源
	 * 	将尝试加载相对于当前类的路径的资源
	 * @throws IOException
	 */
	@Test
    public void testClasspathResourceByClass() throws IOException {
        Class clazz = this.getClass();
        //注意:如果com前面没有加"/"则是相对于与当前路径,如果加了,则是相对于根路径
        Resource resource1 = new ClassPathResource("com/chenming/spring/basic/basic_11_resource_1/testClassPathResource_1.properties" , clazz);
        if(resource1.exists()) {
            dumpStream(resource1);
        }
        System.out.println("path:" + resource1.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource1.isOpen());
        
        Resource resource2 = new ClassPathResource("testClassPathResource_1.properties" , this.getClass());
        if(resource2.exists()) {
            dumpStream(resource2);
        }
        System.out.println("path:" + resource2.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource2.isOpen());
    }
	
	
	/**
	 * 加载jar包里的资源
	 * @throws IOException
	 */
	@Test
    public void testClasspathResourceFromJar() throws IOException {
        Resource resource = new ClassPathResource("overview.html");
        if(resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getURL().getPath());
        Assert.assertEquals(false, resource.isOpen());
    }
	
	
	/**
	 * 加载URL资源
	 * @throws IOException
	 */
	@Test
    public void testUrlResource() throws IOException {
        Resource resource = new UrlResource("file:d:/test.txt");
        if(resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getURL().getPath());
        Assert.assertEquals(false, resource.isOpen());

        Resource resource2 = new UrlResource("http://www.springsource.org");
        if(resource2.exists()) {
            dumpStream(resource2);
        }
        System.out.println("path:" + resource2.getURL().getPath());
        Assert.assertEquals(false, resource2.isOpen());
    }
	
	
	
	
	private void dumpStream(Resource resource) {
		InputStream is = null;
		try {
			//1.获取文件资源
			is = resource.getInputStream();
			//2.读取资源
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try{
					is.close();
				} catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					is = null;
				}
			}
		}
	}
}
