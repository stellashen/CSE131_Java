package studio1;

import java.text.DecimalFormat;

import cse131.ArgsProcessor;

public class Grading {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Let's start calculating the grade. What's the name of the person?");
		double quiz = ap.nextDouble("What's the number of quiz points received?");
		double studio = ap.nextDouble("What's the number of studio points received?");
		double lab = ap.nextDouble("What's the number of lab points received?");
		double extension = ap.nextDouble("What's the number of extension points received?");
		double exam = ap.nextDouble("What's the number of exam points received?");

		double total = .05*quiz + .1*studio + .3*lab + .3*extension + .25*exam;
		
		if (total > 100 || total < 0){
			System.out.println("Sorry, the grade should be within 0-100. Your result is not within this range. Please calculate again.");
		}
		
		//Round course grade to two decimal places 
		DecimalFormat df = new DecimalFormat("#.##");
		total = Double.valueOf(df.format(total));
		
		//Remove all decimals
		int totalint = (int)total;
		
		boolean plus = false;
		boolean minus = false;
		int remainder = totalint % 10;
		if (remainder>=7 && totalint>=77) {
            plus = true;
        }
		if (remainder<3 && totalint>=70) {
			minus = true;
		}
		
		System.out.println(name + ":");
		System.out.println("	Total score: " + total);
		System.out.println("	Grade for this course: " + totalint);
		System.out.println("	Final grade has a...");
		System.out.println("		Plus:" + plus);
		System.out.println("		Minus:" + minus);
	}

}
