package quiz7;

public class Car {
	
	private double fuel, odometer;

	public Car(double fuel, double odometer) {
		this.fuel = fuel;
		this.odometer = odometer;
	}

	// accessor = getter
	public double getFuel() {
		return fuel;
	}

	public double getOdometer() {
		return odometer;
	}
	
	public void drive(double miles, double amountFuelUsed){
		this.odometer = this.odometer + miles;
		this.fuel = this.fuel - amountFuelUsed;
	}
	
	public void fillUp(double fuelAdd){
		this.fuel = this.fuel + fuelAdd;
	}

	@Override
	public String toString() {
		return "Car [fuel=" + fuel + ", odometer=" + odometer + "]";
	}

	public static void main(String[] args) {
		Car car1 = new Car(0,0);
		System.out.println("A new car that has zero miles and zero gallons of fuel: "+car1);
		car1.fillUp(10);
		System.out.println("Add 10 gallons of fuel to the tank: "+car1);
		car1.drive(45, 1.5);
		System.out.println("After a 45 mile drive that consumes 1.5 gallons of fuel: "+car1);

	}

}
