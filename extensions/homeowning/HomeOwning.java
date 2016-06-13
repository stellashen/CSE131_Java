package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("What's the name of the apartment complex?");
		String zip = ap.nextString("What's the zip code of the apartment?");
		int monthlyRent = ap.nextInt("If you choose to rent an apartment, what's the monthly rent of the apartment? Please enter an integer.");
		double dailyInterest = ap.nextDouble("If you choose mortgage loan for your house, what's the daily interest payment? Please round to cents.");	
		int annualRent = 12 * monthlyRent;
		int weeklyRentCents = (int)(annualRent/52.0 * 100);
		int annualInterestCents = (int)(365*100*dailyInterest);
		int weeklyInterestCents = (int)(7*100*dailyInterest);
				
		System.out.println(name + " is located in the Zip Code " + zip);
		System.out.println("Rent per year: " + annualRent);
		System.out.println("Rent per week: " + weeklyRentCents/100.0);
		System.out.println();
		System.out.println("Interest paid per year: " + annualInterestCents/100.0);
		System.out.println("Interest paid per week: " + weeklyInterestCents/100.0);
		System.out.println();
		System.out.print("I should ");
		if (annualRent == annualInterestCents/100.0) {
			System.out.println("rent or own (same cost)");
		}
		else if (annualRent < annualInterestCents/100.0){
			System.out.println("rent");
		}
		else {
			System.out.println("own");
		}

	}

}
