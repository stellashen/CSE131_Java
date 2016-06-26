package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		// Notice: scales have been reset! 
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		// ball(filled circle) radius
		double radius = 0.1;
		// ask for user input
		ArgsProcessor ap = new ArgsProcessor(args);
		int b = ap.nextInt("How many balls? "
				+ "(Please enter a number between 2 and 20 for the best effect.)");

		while (b > 20 || b < 2){
			b = ap.nextInt("Sorry, please enter a number between 2 and 20 for the best effect.");
		}

		int N = ap.nextInt("How many iterations? Please enter a number between 200 and 12000 for the best effect.");
		while (N <= 0){
			N = ap.nextInt("Sorry, the number of iterations cannot be negative or 0. "
					+ "Please enter a positive number.");
		}
		while (N < 200 || N > 12000){
			N = ap.nextInt("Sorry, please enter a number between 200 and 12000.");
		}


		// Create arrays to store position and velocity values for different balls.
		// Balls have different velocities.
		// But each ball has a certain velocity which doesn't change during iterations.
		double[][] rx = new double[N][b];
		double[][] ry = new double[N][b];
		double[] vx = new double[b];
		double[] vy = new double[b];

		// assign a random velocity to each ball
		for (int i = 0; i < b; ++i){
			// velocity
			vx[i] = Math.random()*0.015+0.01;
			vy[i] = Math.random()*0.015+0.01;
			// 50% chance to be negative
			if (Math.random() < 0.5){
				vx[i]=-vx[i];
			}
			if (Math.random() < 0.5){
				vy[i]=-vy[i];
			}
		}

		// initial locations & make sure there's no overlap
		// while overlap, generate a new array of ball positions
		int overlap = 2;
		while (overlap > 0){
			for (int i = 0; i < b; ++i){
				// positions: initial random value: (-1+radius,1-radius). Two steps:
				// generate values: [-1+radius,1-radius) = x*(1-radius), x=[-1,1)
				rx[0][i] = (2*Math.random()-1)*(1-radius);
				ry[0][i] = (2*Math.random()-1)*(1-radius);
			}

			// check initial position - don't overlap (collide)
			// check the distance between each pair (check twice for each pair with the code below)
			// Any overlaps?

			double[][] distanceBegin = new double[b][b];
			overlap = 0;
			for (int i=0; i < b; ++i){
				for (int k=0; k < b; ++k){
					distanceBegin[i][k] = Math.sqrt(Math.pow(rx[0][i]-rx[0][k], 2)+Math.pow(ry[0][i]-ry[0][k], 2));
					if (k!=i && distanceBegin[i][k]<2*radius){
						overlap = overlap+1;
					}
				}
			}
		}


		// number of iterations N decides the duration of the animation
		// if N=100, the duration = 100*20ms = 2 seconds

		for (int t=0; t < N; ++t)  {
			// clear the background
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledSquare(0, 0, 1.0);

			// store positions in a 2D array
			// avoid collision with wall or other balls
			for (int j = 0; j<N; ++j){	
				for (int i = 0; i<b; ++i){
					// bounce off wall according to law of elastic collision
					if (Math.abs(rx[j][i] + vx[i]) > 1.0 - radius) vx[i] = -vx[i];
					if (Math.abs(ry[j][i] + vy[i]) > 1.0 - radius) vy[i] = -vy[i];

					// update position for this ball
					rx[j][i] = rx[j][i] + vx[i]; 
					ry[j][i] = ry[j][i] + vy[i]; 

					// check collision between pairs of balls
//					if (i > 0){
//						for (int k=0; k < i; ++k){
//							double distance = Math.sqrt(Math.pow(rx[j][i]-rx[j][k], 2)+Math.pow(ry[j][i]-ry[j][k], 2));
//							if (distance<2*radius){
//								//change velocity for those who collide
//							}
//						}
//					}
//					// end of "if (i>0)" 
				}
			}
			// end of 2D array loop

			// animation
			for (int i=0; i<b; ++i){
				StdDraw.setPenColor(new Color(255,150,0));
				StdDraw.filledCircle(rx[t][i], ry[t][i], radius); 

				//add black border
				StdDraw.setPenRadius(0.01);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(rx[t][i], ry[t][i], radius-0.01);
			}

			// Notice that each time, you want to display all the balls
			// display and pause for 20 ms
			StdDraw.show(20);

		}
	}
}
