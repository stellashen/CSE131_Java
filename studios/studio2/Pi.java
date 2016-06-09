package studio2;

import cse131.ArgsProcessor;

public class Pi {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many times do you want to throw the darts?");
		int numCircle = 0;
		double ans = 0.0;

		// fill in to compute ans = Pi
		// area of 1/4 circle is 1/4*Pi, area of square is 1 

		for (int i=0;i<N;i++){
			double x = Math.random();
			double y = Math.random();
			double r = Math.sqrt(x*x+y*y);
			if (r <= 1){
				numCircle=numCircle+1;
			}
		}
		ans = 4.0*numCircle/N;
		System.out.println("Our group shows Pi = " + ans);
	}
}
