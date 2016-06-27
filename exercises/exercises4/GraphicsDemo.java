package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(0.5, 0.25); // very small point
		// draw a larger green point
		StdDraw.setPenRadius(.05);
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.point(0.25,0.5);
		
		// unfilled red triangle
		//	easy: draw 3 lines
		// reset pen radius
		StdDraw.setPenRadius();
		StdDraw.setPenColor(Color.RED);
		StdDraw.line(0, 0, 0, 1);//vertical line (0,0) (0,1)
		StdDraw.line(0, 1, .5, 0);// angle (0,1)(.5,0)
		StdDraw.line(.5, 0, 0, 0);
		
		// yellow circle
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(.75, .75, .1);//center point ( .75,.75) r=.1
		
		// filled blue rectangle
		StdDraw.setPenColor(new Color(0,0,128));// a darker blue
		StdDraw.filledRectangle(.25, .25, .2, .1);
		
		

	}

}
