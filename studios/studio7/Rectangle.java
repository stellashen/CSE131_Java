package studio7;

public class Rectangle {

	private double length, width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}



	public void setLength(double length) {
		this.length = length;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}

	public double area(){
		return this.width*this.length;
	}

	public double perimeter(){
		return (this.width+this.length)*2;
	}
	
	public String square(){
		if (this.length==this.width){
			return "It is square.";
		}
		else {
			return "It is not square.";
		}
	}
	
	public boolean compareArea(double x){
		if (this.area()< x){
			return true;
		}
		else return false;
	}

	public String toString() {
		return "length: " + this.length + " width: " + this.width + "\n" 
				+ "area: "+this.area()+" perimeter: "+this.perimeter() + "\n"
				+ this.square();
	}

	public static void main(String[] args) {
		Rectangle R1 = new Rectangle(2,1);
		Rectangle R2 = new Rectangle(3,3);
		System.out.println(R1);
		System.out.println();
		System.out.println(R2);
		System.out.println();
		double a1 = R1.area();
		System.out.println("Is R2 smaller than R1 in terms of area? " + R2.compareArea(a1));

	}

}
