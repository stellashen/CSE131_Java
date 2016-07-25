package lab7;

public class Point {
	private double x, y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public Point plus(Vector v){
		double vx = v.getDeltaX();
		double vy = v.getDeltaY();
		Point p = new Point(this.x+vx, this.y+vy);
		return p;
	}
	
	public Vector minus(Point p){
		double vx = this.getX()-p.getX();
		double vy = this.getY()-p.getY();
		return new Vector(vx,vy);
	}
	
	public double distance(Point p){
		Vector v = minus(p);
		double vx = v.getDeltaX();
		double vy = v.getDeltaY();
		return Math.sqrt(vx*vx+vy*vy);
	}
	
}
