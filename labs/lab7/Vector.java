package lab7;

public class Vector {
	private double deltaX, deltaY;



	// open the Source menu and select "Generate constructor using fields."
	/**
	 * constructor
	 * @param deltaX
	 * @param deltaY
	 */
	public Vector(double deltaX, double deltaY) {
		super();
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	// It is customary to provide a method called toString that 
	// takes no parameters and returns a String value that is a textual description of the object. 
	// You can call this method yourself, 
	// but Java will also call it whenever it needs to concatenate the object onto a String.
	public String toString(){
		return "["+this.deltaX+" "+this.deltaY+"]";
	}

	/**
	 * accessors
	 * no mutators
	 */
	public double getDeltaX() {
		return deltaX;
	}

	public double getDeltaY() {
		return deltaY;
	}

	public double magnitude(){
		return Math.sqrt(this.deltaX*this.deltaX+this.deltaY*this.deltaY);
	}

	public Vector deflectX(){
		Vector V1 = new Vector(-this.deltaX,this.deltaY);
		return V1;
	}

	public Vector deflectY(){
		Vector V2 = new Vector(this.deltaX,-this.deltaY);
		return V2;
	}

	public Vector plus(Vector p){
		Vector V3 = new Vector(this.deltaX+p.deltaX,this.deltaY+p.deltaY);
		return V3;
	}

	public Vector minus(Vector m){
		Vector m2=new Vector(-m.deltaX,-m.deltaY);
		return this.plus(m2);
	}

	public Vector scale(double factor){
		return new Vector(this.deltaX*factor,this.deltaY*factor);
	}

	public Vector rescale(double magnitude){
		double t = this.magnitude();

		if (t == 0){
			Vector V4 = new Vector(magnitude,0);
			return V4;
		}

		else{
			double f = magnitude/t;
			if (f<0){
				f=-f;
			}
			return this.scale(f);
		}
	}
}
