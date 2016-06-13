package baseball;

import cse131.ArgsProcessor;

public class BaseballStats {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("What's the name of the player?");
		int atBats = ap.nextInt("What's the number of at-bats the player has had?");
		int hits = ap.nextInt("What's the number of hits the player has had?");
		
		double battingAvg = Math.round(1000.0*hits/atBats)/1000.0;
		boolean allStar = false;
		
		if (atBats >= 200 && battingAvg >= 0.270) {
			allStar = true;
		}
		System.out.println(name + " " + battingAvg);
		System.out.println("All-Star Worthy? " + allStar);
	}

}
