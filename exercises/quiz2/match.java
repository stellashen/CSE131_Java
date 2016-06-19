package quiz2;

import cse131.ArgsProcessor;

public class match {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int x = ap.nextInt("Enter x:"); 
		int y = ap.nextInt("Enter y:"); 
		int z = ap.nextInt("Enter z:");
		if (x == y && y == z){
			System.out.println("No match");
		}
		else if (x == y || y == z || x == z){
			System.out.println("Two Match");
		}
		else {
			System.out.println("No match");
		}

	}

}
