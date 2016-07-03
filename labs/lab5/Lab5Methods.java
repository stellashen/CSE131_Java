package lab5;

public class Lab5Methods {
	/**
	 * 
	 * @param n an interger
	 * @return the sum of the positive integers n + (n-2) + (n-4) + ...
	 */
	public static int sumDownBy2(int n) {
		int sum = 0;
		while (n > 0){
			sum = sum + n;
			n = n-2;
		}
		return sum;
	}
	/**
	 * 
	 * @param n a positive integer
	 * @return the sum 1+1/2+1/3+...+1/n
	 */
	public static double harmonicSum(int n){
		double sum = 0;
		while (n>0){
			sum = sum + 1.0/n;
			n = n - 1;
		}
		return sum;
	}
	/**
	 * 
	 * @param k non-negative integer
	 * @return the sum 1+1/2+1/4+...+1/Math.pow(2,k)
	 */
	public static double geometricSum(int k){
		double sum = 0;
		while (k>=0){
			sum=sum+1.0/Math.pow(2, k);
			k = k-1;
		}
		return sum;
	}
	/**
	 * 
	 * @param j positive integer
	 * @param k positive integer
	 * @return the product j*k (without using the multiplication operator)
	 */
	public static int multPos(int j, int k){
		int sum = 0;
		for (int i=0; i<j; ++i){
			sum = sum+k;
		}
		return sum;
	}
	/**
	 * 
	 * @param j integer
	 * @param k integer
	 * @return the product j*k
	 */
	public static int mult(int j, int k){
		int sum=0;
		if (j>0){
			sum = multPos(j,k);
		}
		if (j<0&&k<0){
			sum = multPos(-j,-k);
		}
		if (j<0&&k>0){
			sum = -multPos(-j,k);
		}
		return sum;
	}
	/**
	 * 
	 * @param n integer
	 * @param k non-negative integer
	 * @return the value of n to the power k
	 */
	public static int expt(int n, int k){
		int result = 1;
		if (n==0){
			result = 0;
		}
		else if (k==0){
			result = 1;
		}
		else {
		for (int i = 0; i < k; ++i){
			result = result * n;
		}
		}
		return result;
	}
}
