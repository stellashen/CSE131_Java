package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How much history?");
		// the longer the history, the more seconds it take for the ball to follow the mouse
		StdDraw.setPenColor(Color.CYAN);
		
		// let's keep a history of where the mouse has been
		double[] histX = new double[N];
		double[] histY = new double[N];
		
		int cur = 0;
		
		while (true) {
			StdDraw.clear();
			// do
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			// cur is where the current values go
			histX[cur] = x;
			histY[cur] = y;
			cur = cur + 1;
			// reset to 0 if we have used up the whole array
			if (cur >= histX.length) {
				cur = 0;
			}
			int oldest = cur;
			
			StdDraw.filledCircle(histX[oldest],histY[oldest], .05);
			
			// double buffering and avoid tight spinning
			StdDraw.show(10);
		}

	}

}
