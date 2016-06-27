package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class ColorDemo {

	public static void main(String[] args) {
		// change colors
		StdDraw.setPenColor(Color.GREEN);
		
		// get a black square
		StdDraw.filledSquare(0.5, 0.5, 0.5);
		
		// create a new color
		Color c = new Color(128,0,0);
		StdDraw.setPenColor(c);
		StdDraw.filledSquare(0.5, 0.5, 0.5);
	}

}
