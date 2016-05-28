package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		// Below, prompt the user to enter a number of pennies
		ArgsProcessor ap = new ArgsProcessor(args);
		int initialPennies = ap.nextInt("How many pennies?");
		
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		
		// use d to represent dollars
		int d = initialPennies / 100;
		int penniesLeftAfterDollars = initialPennies % 100;//one way
		//alternative way:
		//int otherPenniesLeftAfterDollars = initialPennies - 100 * d;
		//print
		System.out.println("You have " + d + " dollars");
		System.out.println("Pennies left " + penniesLeftAfterDollars);
		
		//quarters in the change
		int q = penniesLeftAfterDollars / 25;
		System.out.println(" and " + q + " quarters");
		int afterQuartersChange = penniesLeftAfterDollars % 25;
		
		//dimes in the change
		int dimes = afterQuartersChange / 10;
		int afterDimesChange = afterQuartersChange % 10;
		System.out.println(" and " + dimes + " dimes");
		System.out.println(" change is now " + afterDimesChange);
		
		//nickels in the change, pennies left
		int n = afterDimesChange / 5;
		int p = afterDimesChange % 5;
		System.out.println(" and " + n + " nickels");
		System.out.println(" and " + p + " pennies");
		
		//verify if it equals the intial value
		int check = 100 * d + 25 * q + 10 * dimes + 5 * n + p;
		System.out.println("Check is " + check);
		}

}
