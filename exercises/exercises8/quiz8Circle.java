package exercises8;

public class quiz8Circle implements quiz8Measurable {

	private double centerX, centerY, radius;

	public quiz8Circle(double centerX, double centerY, double radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}

	public double area() {
		double a = Math.PI*radius*radius;
		return a;
	}

	public double perimeter() {
		double p = 2*Math.PI*radius;
		return p;
	}

	@Override
	public String toString() {
		return "quiz8Circle [centerX=" + centerX + ", centerY=" + centerY + ", radius=" + radius + "]";
	}
	
	

}
