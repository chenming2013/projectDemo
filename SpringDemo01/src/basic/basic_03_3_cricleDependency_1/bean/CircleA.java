package basic.basic_03_3_cricleDependency_1.bean;

public class CircleA
{
	private CircleB circleB;
	
	public CircleA() {}
	public CircleA(CircleB cricleB) {
		this.circleB = cricleB;
	}
	
	
	public CircleB getCircleB()
	{
		return circleB;
	}
	public void setCircleB(CircleB circleB)
	{
		this.circleB = circleB;
	}
	public void a() {
		circleB.b();
	}
}
