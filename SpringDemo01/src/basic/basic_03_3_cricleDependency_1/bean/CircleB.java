package basic.basic_03_3_cricleDependency_1.bean;

public class CircleB
{
	private CircleC circleC;
	
	public CircleB() {}
	public CircleB(CircleC cricleC) {
		this.circleC = cricleC;
	}
	
	
	public CircleC getCircleC()
	{
		return circleC;
	}
	public void setCircleC(CircleC circleC)
	{
		this.circleC = circleC;
	}
	public void b() {
		circleC.c();
	}
}
