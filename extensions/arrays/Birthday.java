package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many people will enter the room?");
		int[][] birth = new int[13][32];
		// ignore birth[0][0]; birth[1][31] means Jan 31th.
		int month = 0;
		int day = 0;
		
		for (int i=0; i<N; ++i){
			month = (int)(1+12*Math.random());
			day = (int)(1+31*Math.random());
			birth[month][day] = birth[month][day]+1;
		}
		
		int numMonth = 0;
		double sum = 0;
		double x = 0.0;
		int same = 0;
		for (int m=1;m<13;++m){
			numMonth = 0;
			for (int d=1;d<32;++d){
				numMonth = numMonth + birth[m][d];
				if (birth[m][d]!=1){
					same = same + birth[m][d];
				}
			}
			x = Math.round(10000.0*numMonth/N)/100.0;
			sum = sum+x;
			
			System.out.println("Month " + m + ": " + x +"% people were born.");
		}
		
		double avg = Math.round(100.0*sum / 12.0)/100.0;
		System.out.println("The average percentage of people born in each month is " + avg + "%.");
		System.out.println();
		
		int numDay = 0;
		double y = 0;
		double sum2 = 0;
		for (int d=1;d<32;++d){
			numDay = 0;
			for (int m=1;m<13;++m){
				numDay = numDay + birth[m][d];
			}
			y = Math.round(10000.0*numDay/N)/100.0;
			System.out.println("Day " + d + ": " + y +"% people were born.");
			sum2 = y + sum2;
		}
		
		double avg2 = Math.round(100.0*sum2 / 31.0)/100.0;
		System.out.println("The average percentage of people born in each day is " + avg2 + "%.");
		
		System.out.println();
		
		double percent = Math.round(100.0*same / N)/100.0;
		System.out.println("The percentage of people born on exactly the same day is " + percent + "%.");
		
	}

}
