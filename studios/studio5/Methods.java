package studio5;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}
	
	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return x*y; 
	}
	
	/**
	 * 
	 * @param x one double
	 * @param y another double
	 * @param z another double
	 * @return the average of the three numbers
	 */
	public static double avg3(double x, double y, double z) {
		double avg = (x + y + z)/3.0;
		return avg; 
	}

	public static double sumArray(double[] a) {
		double sumA = 0;
		for (int i = 0; i < a.length; ++i){
			sumA = sumA + a[i];
		}
		return sumA; 
	}
	
	public static double average(double[] a) {
		double avgA = sumArray(a)/ a.length;
		return avgA; 
	}
	
	public static String pig(String s){
		String pigLatin = s.substring(1)+s.substring(0,1)+"ay";
		return pigLatin;
	}
	

	
	

}
