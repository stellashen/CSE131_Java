package lab9;

public class ListItem {
	//
	// Important:  Do NOT make these instance variables private
	// Our testing needs to be able to access them, so leave their
	//   declarations as you see them below.
	//
	final int number;
	ListItem next;

	/**
	 * Creates a single list item.
	 * @param number the value to be held in the item
	 * @param next a reference to the next item in the list
	 */
	ListItem(int number, ListItem next) {
		this.number = number;
		this.next   = next;
	}

	/**
	 * Return a copy of this list using recursion.  No
	 * credit if you use any iteration!  All existing lists should remain
	 * intact -- this method must not mutate anything.
	 * @return
	 */
	public ListItem duplicate() {
		if (this.next == null){
			return new ListItem(this.number,null);
		}
		else{
			return new ListItem(this.number,this.next.duplicate()); // FIXED
		}
	}

	/**
	 * Recursively compute the number of elements in the list. No
	 * credit if you use any iteration!  All existing lists should remain
	 * intact.
	 * @return
	 */
	public int length() {
		if (this.next == null){
			return 1;
		}
		else {
			return 1+this.next.length();
		}
	}

	/**
	 * Return a new list, like duplicate(), but every element
	 * appears n times instead of once.  See the web page for details.
	 * You must do this method iteratively.  No credit
	 * if you use any recursion!
	 * @param n a positive (never 0) number specifying how many times to copy each element
	 * @return
	 */

	public ListItem stretch(int n) {
		ListItem ans = null;
		// create an array storing the numbers of the original list in order
		int length = this.length();
		int[] numberArray = new int[length];
		int k = 0;		
		for (ListItem p = new ListItem(this.number,this.next); p != null; p=p.next){
			numberArray[k]= p.number;
			k=k+1;
		}
		// start from the last ListItem		
		ans = new ListItem(numberArray[length-1],null);
		for (int i=0;i<n-1;i++){
			ans = new ListItem(numberArray[length-1],ans);
		}
		for (int i = length-2;i>=0;i=i-1){
			for (int j = 0; j < n; j++){
				ans = new ListItem(numberArray[i],ans);
			}
		}
		return ans;
	}

	/**
	 * Return the first ListItem, looking from "this" forward,
	 * that contains the specified number.  No lists should be
	 * modified as a result of this call.  You may do this recursively
	 * or iteratively, as you like.
	 * @param n
	 * @return
	 */

	public ListItem find(int target) {
		for (ListItem p = new ListItem(this.number,this.next);p!=null;p=p.next){
			if (p.number == target){
				return p;
			}
		}
		return null;
	}

	/**
	 * Return the maximum number contained in the list
	 * from this point forward.  No lists should be modified
	 * as a result of this call.  You may do this method recursively
	 * or iteratively,as you like.
	 * @return
	 */

	public int max() {
		int max = this.number;
		for (ListItem p = new ListItem(this.number,this.next);p!=null;p=p.next){
			if (p.number > max){
				max = p.number;
			}
		}
		return max;
	}

	/**
	 * Returns a copy of the list beginning at ls, but containing
	 * only elements that are even.
	 * @param ls
	 * @return
	 */
	public static ListItem evenElements(ListItem ls) {
		if (ls==null){
			return null;
		}
		else if (ls.number%2 == 0){
			return new ListItem(ls.number,evenElements(ls.next));
		}
		else {
			return evenElements(ls.next);
		}
	}	

	/**
	 * Returns a string representation of the values reachable from
	 * this list item.  Values appear in the same order as the occur in
	 * the linked structure.  Leave this method alone so our testing will work
	 * properly.
	 */
	public String toString() {
		if (next == null)
			return ("" + number);
		else
			return (number + " " + next); // calls next.toString() implicitly
	}

	//	used the following code to print out results while writing the program
	//
	//	public String toString() {
	//		return "ListItem [number=" + number + ", next=" + next + "]";
	//	}
	//
	//	public static void main(String[] args) {
	//		ListItem item = new ListItem(1,null);
	//		System.out.println(item.duplicate());
	//		System.out.println(item.stretch(2));
	//		ListItem item2 = new ListItem(1,new ListItem(2,null));
	//		System.out.println(item2.duplicate());
	//		System.out.println(item2.stretch(3));
	//	}

}
