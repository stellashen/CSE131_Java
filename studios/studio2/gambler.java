package studio2;

import cse131.ArgsProcessor;

public class gambler {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		double startAmount = ap.nextDouble("What is the amount of money that you start with?");
		double winChance = ap.nextDouble("What is the probability that you win a gamble? Enter a number between 0 and 1.");
		double winAmount = ap.nextDouble("If you reach this amount of money, then you won:");
		int totalPlays = ap.nextInt("What is the number of times you simulate the problem?");

		double lossChance = 1-winChance;
		double ruin = 1.0;
		int numLoss = 0;
		
		//calculate expected ruin rate		
		if (lossChance != winChance) {
			double ratio = lossChance/winChance;
			ruin = (Math.pow(ratio,startAmount)-Math.pow(ratio, winAmount))/(1-Math.pow(ratio, winAmount));
		}
		else {
			ruin = 1 - startAmount / winAmount;
		}

		//simulation totalPlays times
		for (int i = 1; i <= totalPlays; i++){
			int numRounds = 0;
			double money = startAmount;
			while (money > 0 && money < winAmount){
				if (Math.random() < winChance){
					money = money + 1;
				}
				else {
					money = money - 1;
				}
				numRounds = numRounds + 1;
			}

			if (numRounds == 1) {
				System.out.println("Simulation " + i + ": " + numRounds + " round  	");
			}
			else {
				System.out.print("Simulation " + i + ": " + numRounds + " rounds  	");	
			}

			if (money <= 0){
				System.out.println("LOSE");
				numLoss = numLoss + 1; 
			}
			else {
				System.out.println("WIN");
			}
		}

		System.out.println();
		System.out.print("Losses: " + numLoss);
		System.out.println("  Simulations: " + totalPlays);
		System.out.print("Actual Ruin Rate: " + 1.0*numLoss/totalPlays);
		System.out.println("  Expected Ruin Rate: " + ruin);
	}

}
