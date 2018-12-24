package basic.basic_03_2_injectionTest.bean;

public class HelloImpl implements Hello
{

	private int index;
	
	private String message;
	
	@Override
	public void sayHello()
	{
		System.out.println("HelloImpl...");
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
}
