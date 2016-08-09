package exercises8;

import java.util.LinkedList;
import java.util.List;

public class Quiz8List {

	public static void main(String[] args) {
		List<quiz8Measurable> list = new LinkedList<quiz8Measurable>();
		quiz8Rectangle r1 = new quiz8Rectangle(0,0,10,10);
		quiz8Circle c1 = new quiz8Circle(0,0,5);
		list.add(r1);
		list.add(c1);
		System.out.println(list);
	}

}
