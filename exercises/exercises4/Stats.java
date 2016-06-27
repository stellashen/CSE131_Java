package exercises4;

import cse131.ArgsProcessor;
import sedgewick.StdIn;

public class Stats {

	public static void main(String[] args) {
		// method called in: useStdInput
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");
		//
		// compute sum, average, count
		//  max and min
		//
		double sum = 0;
		int count = 0;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		while (!StdIn.isEmpty()){
			double d = StdIn.readDouble();
			if (d > max){
				max = d;
			}
			if (d < min){
				min = d;
			}
			sum = sum + d;
			count = count + 1;
		}
		System.out.println("Sum " + sum);
		System.out.println("Count " + count);
		System.out.println("Average " + (sum/count));
		System.out.println("Max " + max);
		System.out.println("Min" + min);
	}
}
