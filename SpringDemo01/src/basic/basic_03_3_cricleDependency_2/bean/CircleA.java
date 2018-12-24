package basic.basic_03_3_cricleDependency_2.bean;

public class CircleA
{
	private CircleB circleB;
	
	public CircleB getCircleB()
	{
		return circleB;
	}

	public void setCircleB(CircleB circleB)
	{
		this.circleB = circleB;
	}



	public void a() {
		System.out.println("a...");
	}
}
