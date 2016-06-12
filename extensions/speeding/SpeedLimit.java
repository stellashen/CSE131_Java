package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int limit = ap.nextInt("What's the speed limit (MPH)? Please enter an integer.");
		int speed = ap.nextInt("What's the driving speed (MPH)? Please enter an integer.");
		int overLimit = speed - limit;

		int fine = (overLimit < 10)? 0 : (50 + (overLimit-10)*10);

		System.out.println("You reported a speed of " + speed + " MPH for a speed limit of " + limit + " MPH." );
		System.out.println("You went " + overLimit + " MPH over the speed limit.");
		System.out.println("Your fine is $" + fine + ".");

	}

}
