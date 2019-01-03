package basic.basic_03_3_cricleDependency_3.bean;

public class CircleC
{
	private CircleA circleA;
	
	public CircleA getCricleA()
	{
		return circleA;
	}
	public void setCircleA(CircleA circleA)
	{
		this.circleA = circleA;
	}
	
	public void c() {
		System.out.println("c...");
	}
}
