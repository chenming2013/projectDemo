package basic.basic_03_4_dependsOn.bean;

import java.io.IOException;

public class DependentBean
{
	private ResourceBean resourceBean;
	
	public void write(String str) throws IOException {
		System.out.println("DependentBean:======写资源");
		resourceBean.getFos().write(str.getBytes());
	}
	
	//初始化方法
	public void init() throws IOException {
		System.out.println("DependentBean:======初始化");
		resourceBean.getFos().write("DependentBean:======初始化".getBytes());
		
	}
	
	//销毁方法
	public void destroy() throws IOException {
		System.out.println("DependentBean:======销毁");
		//在销毁之前,需要往文件中写销毁内容
		resourceBean.getFos().write("DependentBean:======销毁".getBytes());
	}
	
	
	public void setResourceBean(ResourceBean resourceBean)
	{
		this.resourceBean = resourceBean;
	}
	public ResourceBean getResourceBean()
	{
		return resourceBean;
	}
}
