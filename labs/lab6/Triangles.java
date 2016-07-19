package lab6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Triangles {
	
	/**
	 * 
	 * @param x lower-left-hand corner x coordinate
	 * @param y lower-left-hand corner y coordinate
	 * @param size length of sides of the current triangle
	 */
	public static void triangle(double x,double y,double size) {
		if (size < Math.pow(0.5,5)) {
			return;
		}
		StdDraw.setPenColor(Color.WHITE);
		double[] a = {x+0.5*size,x+0.25*size,x+0.75*size};
		double[] b = {y,y+0.25*Math.sqrt(3)*size,y+0.25*Math.sqrt(3)*size};
		StdDraw.filledPolygon(a, b);
		//smaller triangles
		triangle(x,y,0.5*size);
		triangle(x+0.5*size,y,0.5*size);
		triangle(x+0.25*size,y+0.25*Math.sqrt(3)*size,0.5*size);
		
	}

	public static void main(String[] args) {
		StdDraw.setPenColor(Color.BLACK);
		double[] x = {0, 1, 0.5};
		double[] y = {0, 0, Math.sqrt(3)*0.5};
		StdDraw.filledPolygon(x, y);
		
		StdDraw.show(10);  // don't show anything
		triangle(0, 0, 1);
		StdDraw.show(10);  // until now

	}

}
