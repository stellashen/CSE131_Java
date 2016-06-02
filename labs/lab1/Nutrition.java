package lab1;

import java.text.DecimalFormat;

import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("What's the name of the food?");
		double carbs = ap.nextDouble("What's the number of grams of carbohydrates in this food?");
		double fat = ap.nextDouble("What's the number of grams of fat in this food?");
		double protein = ap.nextDouble("What's the number of grams of protein in this food?");
		double statedCals = ap.nextDouble("What's the number of calories stated on this food's label?");
		
		double carbsCal = Math.round(40*carbs)/10;
		double fatCal = Math.round(90*fat)/10;
		double proteinCal = Math.round(40*protein)/10;
		double fiberCal = statedCals - carbsCal - fatCal - proteinCal;
		double fiber = Math.round(100*fiberCal)/400;
		
		double carbsPercent = 100*carbsCal/statedCals;
		double fatPercent = 100*fatCal/statedCals;
		double proteinPercent = 100*proteinCal/statedCals;
		//round to one decimal place
		double carbsPercentRound = Math.round(10*carbsPercent)/10;
		double fatPercentRound = Math.round(10*fatPercent)/10;
		double proteinPercentRound = Math.round(10*proteinPercent)/10;
		
		boolean lowCarb = true;
		boolean lowFat = true;
		boolean heads = true;
		if (carbsPercentRound>25) {
			lowCarb = false;
		}
		if (fatPercentRound>15){
			lowFat = false;
		}
		if (Math.random()>0.5){
			heads = false;
		}
		
		
		System.out.println(name + " has");
		System.out.println("  " + carbs + " grams of carbohydrates = " + carbsCal + " Calories");
		System.out.println("  " + fat + " grams of fat = " + fatCal + " Calories");
		System.out.println("  " + carbs + " grams of protein = " + proteinCal + " Calories");
		System.out.println("  ");
		System.out.println("This food is said to have " + statedCals + " Calories.");
		System.out.println("With "+fiberCal+" unavailable Calories, " + "this food has "+fiber+" grams of fiber");
		System.out.println("  ");
		System.out.println("Approximately");
		System.out.println("  " +carbsPercentRound+ "% of your food is carbohydrates");
		System.out.println("  " +fatPercentRound+ "% of your food is fat");
		System.out.println("  " +proteinPercentRound+ "% of your food is protein");
		System.out.println("  ");
		System.out.println("This food is acceptable for a low-carb diet?  "+lowCarb);
		System.out.println("This food is acceptable for a low-fat diet?  "+lowFat);
		System.out.println("By coin flip, you should eat this food?  "+heads);
	}

}
