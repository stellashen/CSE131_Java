package lab8;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

	final private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//
		this.list = new LinkedList<Double>();
	}

	public LinkedList<Double> getList() {
		return list;
	}

	public String toString() {
		String s = "";
		if (list.size()==1){
			s = Double.toString(list.getFirst());
		}
		String newTerm = "";
		if (list.size()>1){
			s = Double.toString(list.getFirst());
			newTerm = Double.toString(list.get(1))+"x";
			if (list.get(1)!=0){
				if (list.get(0)>0) newTerm = newTerm +"+";
				s = newTerm + s;
			}
			for (int i=2; i<list.size(); ++i){
				newTerm = Double.toString(list.get(i))+"x^"+Integer.toString(i);
				if (list.get(i)!=0){
					if (list.get(i-1)>0) newTerm = newTerm +"+";
					s = newTerm + s;
				}
			}
		}
		return s;
	}

	/**
	 * 
	 * @param coeff the coefficient for the added term
	 * @return the new polynomial with the added term
	 */
	public Polynomial addTerm(double coeff) {
		list.add(coeff);
		return this;
	}

	// ListIterator:
	// https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
	public double evaluate(double x) {
		return recursiveHelper(x,list.iterator());
	}

	public double recursiveHelper(double x, Iterator<Double> i){
		if (i.hasNext()==true){
			return i.next() + x*recursiveHelper(x, i);
		}
		else {
			return 0;
		}
	}

	/**
	 * Take derivative of the polynomial and
	 * @return a new polynomial
	 */
	public Polynomial derivative() {
		Polynomial p = new Polynomial();
		double newCoeff = 0;
		for (int i = 1; i < list.size();++i){
			newCoeff = i*list.get(i); 
			p.addTerm(newCoeff);
		}
		return p;
	}

	public Polynomial sum(Polynomial another) {
		Polynomial newP = new Polynomial();
		double newCoeff = 0;
		LinkedList<Double> listOther = another.getList();
		int n = list.size();
		int m = listOther.size();
		int smallerSize = 0;
		int biggerSize = 0;
		LinkedList<Double> bigList = this.list;
		if (n<m){
			smallerSize=n;
			biggerSize=m;
			bigList = another.getList();
		}
		else 
			{
			smallerSize=m;
			biggerSize=n;
			}
		for (int i = 0; i < smallerSize;++i){
		newCoeff = list.get(i)+listOther.get(i);
		newP.addTerm(newCoeff);
		}
		if (n!=m){
			for (int i = smallerSize; i < biggerSize; ++i){
				newP.addTerm(bigList.get(i));
			}
		}
		
		return newP;
	}

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

	public static void main(String[] args) {
		Polynomial foo = new Polynomial();
		foo.addTerm(4).addTerm(-7).addTerm(0).addTerm(11);
		System.out.println("y = " + foo);
		double y = foo.evaluate(10);
		System.out.println("If x = 10, y = " + y);
		System.out.println("Take derivative: " + foo.derivative());
	}

}
