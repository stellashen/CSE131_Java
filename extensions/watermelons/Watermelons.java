package watermelons;

import java.util.Arrays;

public class Watermelons {

	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once.  So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the result.
	 * For example, if all of the incoming values are 0, then so are all of the returned values.
	 * @param nums an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	public static int[] allPairSums(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n*(n-1)/2];
		int i = 0;
		for (int k = 0; k < n-1; k++){
			for (int m = k+1; m < n; m++){
				ans[i] = nums[k]+nums[m];
				i=i+1;
			}
		}
		return ans;
	}

	/**
	 * The method below must COMPUTE and return a solution as described
	 * on the web page for this extension.  
	 * 
	 * You must compute the solution by trying
	 * lots of possibilities, and finding the one that yields the right answer.
	 * 
	 * You can run the provided unit test to see if you are right.
	 * @param pairSums is array of watermelon pairwise sums.  In other words,
	 *    each element of pairSums represents the sum of one pair of watermelons in our puzzle.
	 * @return
	 */
	public static int[] getSolution(int[] pairSums) {
		//find the largest number of the pair sums
		int bigSum = pairSums[0];
		for (int i = 1; i < pairSums.length; i++){
			if (pairSums[i]>bigSum){
				bigSum = pairSums[i];
			}
		}
		// weight of watermelons > 0
		// the biggest weight cannot be larger than bigSum
		// there are five watermelons
		int[] ans = new int[5];
//		for (int a = 1; a < bigSum; a++){
//			for (int b = 1; b < bigSum; b++){
//				for (int c = 1; c < bigSum; c++){
//					for (int d = 1; d < bigSum; d++){
//						for (int e = 1; e < bigSum; e++){
		for (int a = bigSum-1; a > 0; a--){
			for (int b = bigSum-1; b > 0; b--){
				for (int c = bigSum-1; c > 0; c--){
					for (int d = bigSum-1; d > 0; d--){
						for (int e = bigSum-1; e >0; e--){
							int[] nums = {a,b,c,d,e};
							int[] sums = allPairSums(nums);
							if (sameIntArrays(sums, pairSums)==true){
								ans = nums;
							}
						}
					}
						
				}
			}
		}
		return ans;
	}

	/**
	 * Compare two arrays for equality.  They must first be
	 * sorted, so that Arrays.equals can do its thing element
	 * by element, as is it wants.
	 * 
	 * However, what if the caller doesn't want the arrays to
	 * be disturbed?  We therefore clone the arrays (copies are
	 * made of them) before we do the compare, and we compare the
	 * clones.
	 * @param one: an array, not mutated
	 * @param two: another array, not mutated
	 * @return true iff the arrays' contents are the same
	 */
	public static boolean sameIntArrays(int[] one, int[] two) {
		int[] cone = (int[]) one.clone();
		int[] ctwo = (int[]) two.clone();
		Arrays.sort(cone);
		Arrays.sort(ctwo);
		return Arrays.equals(cone, ctwo);
	}


}
