package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int round = ap.nextInt("How many rounds do you want to play?");
		int computerWin = 0;
		int humanWin = 0;
		for (int i=0; i < round; i++){
			int human = ap.nextInt("What's your next move? Enter 1 for rock, enter 2 for paper, enter 3 for scissors.");
			while (human != 1 && human !=2 && human !=3) {
				human = ap.nextInt("Sorry, you can only enter 1 or 2 or 3. Enter 1 for rock, enter 2 for paper, enter 3 for scissors.");
			}
			System.out.print("Round " + (i+1) + ": ");
			int computer = (int)(1+3*Math.random());
			
			if (human == 1){
				System.out.print("Your move is rock. ");
				if (computer == 2){
					computerWin = computerWin + 1;
					System.out.println("The other player's move is paper. You lose.");
				}
				if (computer == 3){
					humanWin = humanWin + 1;
					System.out.println("The other player's move is scissors. You win.");
				}
				if (computer == 1){
					System.out.println("The other player's move is also rock. You two are even.");
				}
			}
			
			else if (human == 2){
				System.out.print("Your move is paper. ");
				if (computer == 2){
					System.out.println("The other player's move is also paper. You two are even.");
				}
				if (computer == 3){
					computerWin = computerWin + 1;
					System.out.println("The other player's move is scissors. You lose.");
				}
				if (computer == 1){
					humanWin = humanWin + 1;
					System.out.println("The other player's move is rock. You win.");
				}
			}
			
			else {
				System.out.print("Your move is scissors. ");
				if (computer == 2){
					humanWin = humanWin + 1;
					System.out.println("The other player's move is paper. You win.");
				}
				if (computer == 3){
					System.out.println("The other player's move is also scissors. You two are even.");
				}
				if (computer == 1){
					computerWin = computerWin + 1;
					System.out.println("The other player's move is rock. You lose.");
				}
			}
		}
		// report the fraction of wins awarded to each of the two players
		System.out.println("You win: " + humanWin + "/" + round + " round(s)");
		System.out.println("You lose: " + computerWin + "/" + round + " round(s)");
		System.out.println("Even: " + (round - humanWin - computerWin)+ "/" + round + " round(s)");
		System.out.print("Final Result: ");
		if (humanWin > computerWin){
			System.out.println("You win!");
		}
		else if (humanWin < computerWin){
			System.out.println("You lose!");
		}
		else {
			System.out.println("Even.");
		}
	}
}
