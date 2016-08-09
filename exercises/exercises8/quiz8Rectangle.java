package exercises8;

public class quiz8Rectangle implements quiz8Measurable {

	private double centerX, centerY, length, width;

	public quiz8Rectangle(double centerX, double centerY, double length, double width) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.length = length;
		this.width = width;
	}

	@Override
	public double area() {
		return length*width;
	}

	@Override
	public double perimeter() {
		double p = 2.0*(length+width);
		return p;
	}

	@Override
	public String toString() {
		return "quiz8Rectangle [centerX=" + centerX + ", centerY=" + centerY + ", length=" + length + ", width=" + width
				+ "]";
	}
	
	
	
}
