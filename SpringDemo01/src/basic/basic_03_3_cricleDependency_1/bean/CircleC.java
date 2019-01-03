package basic.basic_03_3_cricleDependency_1.bean;

public class CircleC
{
	private CircleA circleA;
	
	public CircleC() {}
	public CircleC(CircleA circleA) {
		this.circleA = circleA;
	}
	public CircleA getCricleA()
	{
		return circleA;
	}
	public void setCircleA(CircleA circleA)
	{
		this.circleA = circleA;
	}
	
	public void c() {
		circleA.a();
	}
}
