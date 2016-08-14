package mousefollower;

import java.awt.Color;

import sedgewick.StdDraw;
import sedgewick.StdIn;

public class FollowTheMouse {

	public static double[] getMousePosition(){
		double[] mouse = {StdDraw.mouseX(), StdDraw.mouseY()};
		return mouse;
	}

	public static void drawBall(double[] position, double radius){
		StdDraw.filledCircle(position[0], position[1], radius);
	}

	public static double[] changePosition(double[] position, double[] mousePosition, double speed){
		double x = position[0];
		double y = position[1];
		double dx = mousePosition[0]-x;
		double dy = mousePosition[1]-y;
		double dz = Math.sqrt(dx*dx+dy*dy);
		double t = dz/speed;
		double speedX = x+dx/t;
		double speedY = y+dy/t;
		double[] newPosition = {x+speedX,y+speedY};
		return newPosition;
	}

	public static void main(String[] args) {
		StdDraw.setPenColor(Color.BLACK);
		double[] tester = new double[]{.5, .5}; drawBall(tester, .05); StdDraw.show(2000); 
		while (!StdDraw.mousePressed()) {
			for (int i=0; i<2000; ++i){
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				double[] newPosition = changePosition(tester, getMousePosition(), 0.05);
				drawBall(newPosition, .05);
				tester = newPosition;
			}

			StdDraw.show(5);
		}
	}
}
