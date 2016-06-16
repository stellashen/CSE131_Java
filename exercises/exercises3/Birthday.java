package exercises3;

import cse131.ArgsProcessor;

public class Birthday {

	public static void main(String[] args) {
		// N people enter the room
		//	Do any of them have the same birthday?
		int[][]cal = new int[12][31]; // 12 months, suppose each month has 31 days
		//
		//  
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many people walk into the room?");

		for (int i=0; i < N; ++i) {
			// each ith iteration is a new person walking into the room
			int m = (int)(Math.random() * 12);
			int d = (int)(Math.random() * 31);
			// want to "bump" (add one) to the count
			//	 of people born on m d
			cal[m][d] = cal[m][d] + 1;
		}

		// let's check the calendar to see if there are multiple birthdays
		boolean foundMult = false;
		for (int m=0; m < 12; ++m){
			for (int d=0; d < 31; ++d){
				if (cal[m][d] > 1){
					foundMult = true;
				}
			}
		}
		System.out.println("Multiple birthdays? " + foundMult);

	}

}
