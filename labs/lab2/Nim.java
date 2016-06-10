package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int order = ap.nextInt("You are going to play a game against a computer. "
				+ "You can choose to play the first or second move. "
				+ "Enter 1 if you want to play the first move, "
				+ "and enter 2 if you want to play the second move");

		while (order != 1 && order != 2){
			order = ap.nextInt("Sorry, you entered a wrong number. Please try again and enter 1 or 2.");
		}

		int removedSticks = 0;
		int humanChoice = 0;
		int computerChoice = 0;

		//scenario1: human first
		if (order == 1){
			while (removedSticks < 7){
				//human move
				humanChoice = ap.nextInt("Please enter 1 or 2 to remove 1 or 2 sticks.");

				while (humanChoice != 1 && humanChoice != 2){
					humanChoice = ap.nextInt("Sorry, you entered a wrong number. "
							+ "Please enter 1 or 2 to remove 1 or 2 sticks.");
				}

				removedSticks = removedSticks + humanChoice;

				while (removedSticks > 7) {
					humanChoice = ap.nextInt("Sorry, you cannot remove two sticks. There is only one stick left. "
							+ "Please try again: enter 1 to win!");
					removedSticks = removedSticks - 2 + humanChoice;
				}

				System.out.println("You removed " + humanChoice + " sticks. A total of " 
						+ removedSticks + " sticks have been removed from the pile. "
						+ "There are " + (7 - removedSticks) + " sticks left in the pile.");

				if (removedSticks == 7){
					System.out.println("You win! You took the last stick in the pile.");
				}

				//computer move

				else {
					if (removedSticks == 6){
						computerChoice = 1;
					}
					else {
						if (Math.random()<0.5){
							computerChoice = 1;
						}
						else {
							computerChoice = 2;
						}
					}
					removedSticks = removedSticks + computerChoice;

					System.out.println("The computer removed " + computerChoice + " sticks. A total of " 
							+ removedSticks + " sticks have been removed from the pile. "
							+ "There are " + (7 - removedSticks) + " sticks left in the pile.");

					if (removedSticks == 7){
						System.out.println("You lose! The computer took the last stick in the pile.");
					}
				}
			}
		}
		//end of scenario1: human first

		//scenario2: computer first
		if (order == 2) {
			removedSticks = 0;
			while (removedSticks < 7){
				//computer move
				if (removedSticks == 6){
					computerChoice = 1;
					System.out.println("You lose! The computer took the last stick in the pile.");
				}
				else {
					if (Math.random()<0.5){
						computerChoice = 1;
					}
					else {
						computerChoice = 2;
					}
				}
				removedSticks = removedSticks + computerChoice;
				System.out.println("The computer removed " + computerChoice + " sticks. A total of " 
						+ removedSticks + " sticks have been removed from the pile. "
						+ "There are " + (7 - removedSticks) + " sticks left in the pile.");

				if (removedSticks == 7){
					System.out.println("You lose! The computer took the last stick in the pile.");
				}
				else {
					//human move
					humanChoice = ap.nextInt("Please enter 1 or 2 to remove 1 or 2 sticks.");

					while (humanChoice != 1 && humanChoice != 2){
						humanChoice = ap.nextInt("Sorry, you entered a wrong number. "
								+ "Please enter 1 or 2 to remove 1 or 2 sticks.");
					}

					removedSticks = removedSticks + humanChoice;

					while (removedSticks > 7) {
						humanChoice = ap.nextInt("Sorry, you cannot remove two sticks. There is only one stick left. "
								+ "Please try again: enter 1 to win!");
						removedSticks = removedSticks - 2 + humanChoice;
					}

					System.out.println("You removed " + humanChoice + " sticks. A total of " 
							+ removedSticks + " sticks have been removed from the pile. "
							+ "There are " + (7 - removedSticks) + " sticks left in the pile.");

					if (removedSticks == 7){
						System.out.println("You win! You took the last stick in the pile.");
					}						
				}
			}
		}//end of scenario2: computer first

	}
}