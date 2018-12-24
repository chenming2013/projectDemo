package basic.basic_03_3_cricleDependency_3.bean;

public class CircleB
{
	private CircleC circleC;
	
	public CircleC getCircleC()
	{
		return circleC;
	}

	public void setCircleC(CircleC circleC)
	{
		this.circleC = circleC;
	}

	public void b() {
		System.out.println("b...");
	}
}
