package onerepmax;

import cse131.ArgsProcessor;

public class OneRepMax {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int w = ap.nextInt("What is your current one-rep max bench weight?");
		int r = ap.nextInt("How many reps are you able to perform before failure?");
		int rep = ap.nextInt("How many reps do you want to perform? We will calculate that weight for you.");
		
		int max = (int)(w * (1+1.0*r/30));
		int weight = (int)(1.0*max/(1+1.0*rep/30));
		System.out.println("One-rep max: " + max);
		System.out.println("Weight for "+rep+" reps: "+weight);
		
		for (int i = 95; i>= 50; i = i - 5){
			int n = (int)(1.0*max*i/100);
			System.out.println(i+"% 1 RM: " + n);
		}

	}

}
