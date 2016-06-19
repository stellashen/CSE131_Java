package exercises4;

import sedgewick.StdIn;

public class ReadTwoDouble {

	public static void main(String[] args) {
		
		System.out.println("Enter your values:");
		double x = StdIn.readDouble();
		double y = StdIn.readDouble();
		
		double sum = x + y;
		System.out.println("Sum is " + sum);

	}

}
