package exercises4;

import sedgewick.StdIn;

public class quiz4 {

	public static void main(String[] args) {
		
		System.out.println("Enter your name:");
		String name = StdIn.readString();
		System.out.println("Enter your age:");
		int age = StdIn.readInt();
		while (age < 0){
			System.out.println("Age cannot be negative. Please enter your age. ");
			age = StdIn.readInt();
		}
		System.out.println("Hi, your name is " + name + ". Your age is " + age + ".");

	}

}