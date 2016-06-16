package lab3;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int D = ap.nextInt("How many dice will be used in this simulation?");
		int T = ap.nextInt("How many times will the dice be thrown?");
		System.out.println("The number of dice: "+D);
		System.out.println("The number of times that the dice will be thrown: "+T);
		
		System.out.println();
		System.out.println("Iterations:");

		// Q7:how often all of the dice show the same value(e.g. 6 6 6)
		int dice[]= new int[D];
		// Q9
		int numSameValue = 0; // number of the events that all dices have same value in one throw
		// Q10	
		int numSum[] = new int[5*D+1];

		for (int t=0;t<T;++t){
			int numEqualAvg = 0; 
			// number of values that equal the average value of all dice values in one throw
			int sumRow = 0; 
			// sum of dices in one row
			// numEqualAvg and sumRow should be set back to 0 before throwing another time
			for (int d=0;d<D;++d){
				dice[d]=(int)(6*Math.random())+1;
				sumRow = sumRow + dice[d];
				System.out.print(dice[d]+" ");
			}

			// Q9. print out the dice values' sum each time the dice are thrown
			System.out.println();
			System.out.println("The sum of dice values for iteration " + (t+1) + " is " + sumRow);
			for (int d=0;d<D;++d){
				if (dice[d] == sumRow/D){
					numEqualAvg = numEqualAvg+1;
				}
			}
			// When all dices have same values, their values should all equal the average value
			if (numEqualAvg==D){
				numSameValue = numSameValue + 1;
			}

			// Q10
			numSum[sumRow-D]=numSum[sumRow-D]+1;

		}

		int percentSameValue = (int)Math.round(100.0*numSameValue/T);
		System.out.println();
		System.out.println("The event that all dices have the same value occurs " + numSameValue + " out of " + T + " times (" 
				+ percentSameValue + "%).");

		// Q10-11. how often each possible sum occurs
		// for D numbers of dice, possible sums range from D to 6*D
		// number of possible sums: 6*D-D+1. so that's the length of array numSum[]
		// add one line in the iteration above 
		// and report:
		System.out.println();
		System.out.println("The percent of times each value of sum occurs:");
		for (int i=0;i < (5*D+1);++i){
			System.out.println("Sum is "+(i+D)+ ": " + Math.round(100.0*numSum[i]/T) + "%");	
		}


	}
}


