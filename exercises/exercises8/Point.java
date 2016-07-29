package exercises8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Point {
	
	//
	// has-a x and y coordinate, both integers
	//  these are immutable so you should declare them "final"
	//
	// declare instance variables here:
	//
	private final int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static void main(String[] args) {
//		Set<Point> set = new HashSet<Point>();
//		set.add(new Point(131,132));
//		set.add(new Point(131,132));
//		set.add(new Point(0,0));
//		System.out.println("Set has " + set);
		
		List<Point> list = new LinkedList<Point>();
		list.add(new Point(131,132));
		list.add(new Point(131,132));
		list.add(new Point(0,0));
		System.out.println("List has " + list);
		boolean has = list.contains(new Point(0,0));
		System.out.println("Does it have this point? " + has);
	}

}
