package studio4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	public static void main(String[] args) {
		// Design (or pick) a flag that has at least 3 shapes on it
		// choose the flag of Tunisia: http://flagpedia.net/tunisia
		// length .688, height .458
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(.344, .229, .344, .229);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(.005);
		StdDraw.rectangle(.344, .229, .344, .229);
		// large white circle r = .115
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(.344, .229, .125);
		// medium red circle
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(.344, .229, .085);
		// small white circle
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(.370, .229, .065);
		// the red star has the same center with the small white circle
		// A star = 2 big RED triangles - 2 small WHITE triangles
		// http://calculus.nctu.edu.tw/upload/calculus_web/maple/Site/carnival/fibonacci/05.htm
		// The next steps aim to draw a star in the end.
		// 1. draw the first big triangle
		double[] px = new double[3];
		double[] py = new double[3];
		double centerX = .370;
		double centerY = .229;
		double dLeft = 0.0245;
		double h = 0.0118;
		double dRight = 0.0238;
		//enlarge
		double k=1.8;
		dLeft = k*dLeft;
		h = k*h;
		dRight = k*dRight;
		px[0] = centerX-dLeft;
		py[0] = centerY;
		px[1] = centerX+dRight;
		py[1] = centerY+h;
		px[2] = centerX+dRight;
		py[2] = centerY-h;
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledPolygon(px,py);
		// 2. draw the second big triangle
		double side = Math.sqrt(Math.pow(dLeft+dRight,2)+Math.pow(h, 2));
		//		System.out.println(side);
		double qh = side/2.0;
		double qd = Math.sqrt(Math.pow(qh,2)-Math.pow(dLeft, 2));
		//		System.out.println(qd);
		double[] qx = new double[3];
		double[] qy = new double[3];
		qy[0] = centerY+qh;
		qx[0] = centerX-qd;
		qy[1] = centerY-qh;
		qx[1] = qx[0];
		qx[2] = px[2];
		qy[2] = py[2];
		StdDraw.filledPolygon(qx,qy);
		// 3. draw the first small triangle
		StdDraw.setPenColor(Color.WHITE);
		double[] spx = new double[3];
		double[] spy = new double[3];
		spx[0]=centerX+0.65*dRight;
		spy[0]=centerY;
		spx[1]=px[1]+0.002;
		spy[1]=py[1]+0.002;
		spx[2]=px[2]+0.002;
		spy[2]=py[2]+0.002;
		StdDraw.filledPolygon(spx,spy);
		// 4. draw the second small triangle
		double[] sqx = new double[3];
		double[] sqy = new double[3];
		sqx[0]=centerX+0.01;
		sqy[0]=centerY-0.35*dRight;
		sqx[1]=qx[1]-0.003;
		sqy[1]=qy[1]-0.003;
		sqx[2]=qx[2]+0.002;
		sqy[2]=qy[2]-0.002;
		StdDraw.filledPolygon(sqx,sqy);
		// End of drawing flag.	

		// Print country name in the center
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(.344, .229, "Tunisia");
		while (!StdDraw.mousePressed()){
			// wait, do nothing
			// but don't spin tightly, pause
			StdDraw.pause(100);
		}
		// Print country name repeatedly after typing a key
		double riseY = .229/5;
		double runX = .344/5;
		double showX = .344- 4*runX;
		double showY = .229 + 4*riseY;
		for (int i = 0; i < 7; i++){
			showX = showX + runX;
			showY = showY - riseY;
			StdDraw.text(showX, showY, "Tunisia");
			StdDraw.show(800);
		}
		// End of printing country names.

		// play music
		ArgsProcessor.useStdInput("music");

		int number = 0; // number of pitches

		// repeat as long as there are more integers to read in
		while (!StdIn.isEmpty()) {

			// read in the pitch, where 0 = Concert A (A4)
			int pitch = StdIn.readInt();

			// read in duration in seconds
			double duration = StdIn.readDouble();

			// build sine wave with desired frequency
			double hz = 440 * Math.pow(2, pitch / 12.0);
			int N = (int) (StdAudio.SAMPLE_RATE * duration);
			double[] a = new double[N+1];

			for (int i = 0; i <= N; i++) {
				a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
			}

			// play it using standard audio
			StdAudio.play(a);
			number = number + 1;
		}
		
		//repeat?

		System.out.println("total number of pitches to read in:" + number); // get 25

	}
}
