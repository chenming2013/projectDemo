package basic.basic_02_3_instanceBean.bean;

public class HelloImpl implements Hello
{
	
	private int id;
	
	private String name;
	
	private int age;
	
	/*============== Constructor ===============*/
	public HelloImpl() {}
	public HelloImpl(int id) {
		this.id = id;
	}
	public HelloImpl(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public HelloImpl(int id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public void sayHello()
	{
		System.out.println("hello world");
	}

	@Override
	public String toString()
	{
		return "{id:"+this.id+",name:"+this.name+",age:"+this.age+"}";
	}
}
