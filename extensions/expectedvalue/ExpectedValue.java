package expectedvalue;

import cse131.ArgsProcessor;

public class ExpectedValue {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		double gamerSucceedChance = ap.nextDouble("What's the probability of the game start-up ventrue succeeding? Please enter a number between 0 and 1.");
		double gamerFailChance = 1 - gamerSucceedChance;
		int gamerExpectedValue = (int)(gamerSucceedChance*190000 + gamerFailChance*5000);
		int programmerSalary = (int)(110000 + 50000*Math.random());
		boolean beGamer = true;
		
		if (gamerExpectedValue < programmerSalary){
			beGamer = false;
		}
		
		int gamerExpectedValue2 = (int)(3*Math.sqrt(gamerSucceedChance*190000 + gamerFailChance*5000));
		int programmerSalary2 = (int)(2*Math.sqrt(110000 + 50000*Math.random()));
		boolean beGamer2 = true;
		
		if (gamerExpectedValue2 < programmerSalary2){
			beGamer = false;
		}
		
		System.out.println("If you have a linear value of wealth, your expectd values are as follows:");
		System.out.println("Gamer: $" + gamerExpectedValue);
		System.out.println("Programmer: $" + programmerSalary);
		System.out.println("You should be a gamer and not a programmer?  " + beGamer);
		System.out.println();
		System.out.println("If you DON'T have a linear value of wealth, your expectd values are as follows:");
		System.out.println("Gamer: $" + gamerExpectedValue2);
		System.out.println("Programmer: $" + programmerSalary2);
		System.out.println("You should be a gamer and not a programmer?  " + beGamer2);

	}

}
