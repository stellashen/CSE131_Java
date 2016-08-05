package studio9;
/*
 * What is the iterator?
In Java, an iterator is an interface and is implemented by all collection classes. 
The Java collections framework is a group of classes and interfaces that implement 
reusable collection of data structures. The iterator method returns an object that
 implements the Iterator interface.
 */
// https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
public interface Iterator<E> {
	
	public boolean hasNext();
	 
	public int next();
	 
	public void remove();


}
