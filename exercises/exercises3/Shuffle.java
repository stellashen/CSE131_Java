package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};
		System.out.println(original[original.length - 1]);

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		
		//declare shuffled array, same size as original
//		String[] shuffled = new String[original.length];
		
		// iterate backwards over shuffled array to fill it in
		for (int i=original.length-1; i>=0; --i){
			// pick a card from 0...i in the original array
			// c is an integer 0...i
			int c = (int)(Math.random()*(i+1));
			// the ith card in shuffled array would be the cth card in original array
//			shuffled[i] = original[c];
			
			// move all the cards up from c+1 to length-1, e.g. 5th card to 4th
			//for (int j=c; j < shuffled.length-1; ++j){
				//original[j] = original[j+1];
			//}
			
			//alternative: move card c to the "end" of the original deck
			// the "end" is actually index i
			// we can swap original[i] and original[c], so the card picked from the original won't be duplicated
			String t = original[i];
			original[i] = original[c];
			original[c] = t;
			
		}
		System.out.println();
		
		// print out the results
//		for (int i=0; i < shuffled.length; ++i){
//			System.out.println("Shuffled at " + i + " is " + shuffled[i]);
//		}
//		
		for (int i=0; i<original.length; ++i){
			System.out.println("Now original at " + i + " is " + original[i]);
		}
	}
}