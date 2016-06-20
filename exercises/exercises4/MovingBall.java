package exercises4;

public class MovingBall {

	public static void main(String[] args) {
		// ball to move across the screen
		// when it reaches the right side
		//	start over at the left side
		
		// need to represent the current x location of the ball
		double ballX = 0.0;
		
		while (true) {
			ballX = ballX + .05;
			if (ballX > 1.0) { // moved too far right
				ballX = 0; 	   // start again at left
			}
		}

	}

}
