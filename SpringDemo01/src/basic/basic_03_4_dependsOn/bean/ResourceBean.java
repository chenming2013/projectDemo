package basic.basic_03_4_dependsOn.bean;

import java.io.File;
import java.io.FileOutputStream;

public class ResourceBean
{
	private FileOutputStream fos;
	
	private File file;
	
	//初始化方法
	public void init() {
		System.out.println("ResourceBean:======初始化");
		//加载资源,在此只是演示
		System.out.println("ResourceBean:======加载资源,执行一些预操作");
		try {
			this.fos = new FileOutputStream(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//销毁资源方法
	public void destroy() {
		System.out.println("ResourceBean:======销毁");
		//释放资源
		System.out.println("ResourceBean:======释放资源,执行一些清理操作");
		try {
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileOutputStream getFos() {
		return this.fos;
	}
	
	public void setFile(File file)
	{
		this.file = file;
	}
	public File getFile()
	{
		return file;
	}
}
