package studio9;

import java.util.Iterator;

public class DoublyLinkedListOfInts implements IntList {

	private final ListItem head,tail;
	private int size;

	public DoublyLinkedListOfInts() {
		this.head = new ListItem(000,null,null);
		this.tail = new ListItem(999,null,this.head);
		this.head.next = this.tail;
		this.setSize(0);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		String ans = "[";
		for (ListItem p = this.head.next; p != this.tail; p = p.next){
			ans += p.getValue() + " ";
		}
		ans = ans + "]";
		return ans;
	}

	@Override
	public void addFirst(int item) {
		ListItem newbie = new ListItem(item, this.head.next,this.head);
		this.head.setNext(newbie);
	}

	@Override
	public void addLast(int item) {
		ListItem p = this.head;
		while (p.next != this.tail) {
			p = p.next;
		}
		p.setNext(new ListItem(item,this.tail,this.tail.prev));

	}

	@Override
	public int size() {
		ListItem p = this.head.next;
		int count = 0;
		while (p != this.tail) {
			p = p.next;
			count = count + 1;
		}
		this.setSize(count);
		return count;
	}

	@Override
	public int indexOf(int item) {
		int i = -1;
		ListItem p = this.head.next; 
		if (p.getValue()==item){
			i = 0;
		}
		else {
			i=1;
			p=p.next;
			while (p.getValue() != item && p != this.tail){
				p = p.next;
				i=i+1;
			}
			if (p == this.tail){
				i=-1;
			}
		}
		return i;
	}

	@Override
	public boolean remove(int item) {
		ListItem p = this.head;
		if (p.next.getValue()== item){
			p.setNext(p.next.next);
		}
		else {
			while (p.next.getValue()!=item && p != this.tail){
				p = p.next;
			}
		}
			if (p==this.tail){
				return false;
			}
			else {
				p.setNext(p.next.next);
				return true;
			}
		}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	public DoublyLinkedListOfInts reverse(){
		DoublyLinkedListOfInts reverseList = new DoublyLinkedListOfInts();

		for (ListItem p = this.head.next; p != this.tail; p=p.next){
			reverseList.addFirst(p.getValue());
		}

		return reverseList;
	}

	@Override
	public Iterator<Integer> iterator() {
		Iterator<Integer> it = new ListIterator();
		return it;
	}

	private class ListIterator implements Iterator<Integer>{
		private ListItem head,tail;

		public ListIterator() {
			this.head = new ListItem(000,null,null);
			this.tail = new ListItem(999,null,this.head);
			this.head.next = this.tail;
		}

		@Override
		public boolean hasNext() {
			ListItem p = this.head;
			return p.next!=tail;
		}

		@Override
		public Integer next() {
			ListItem p = this.head;
			if (p.next!=tail){
				return p.next.getValue();
			}
			return null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedListOfInts list = new DoublyLinkedListOfInts();
		list.addFirst(131);
		list.addFirst(130);
		list.addFirst(129);
		list.addLast(132);
		System.out.println(list);
		System.out.println("size:"+list.size());
		System.out.println("Index of 000: " + list.indexOf(000));
		System.out.println("Index of 129: " + list.indexOf(129));
		System.out.println("Index of 130: " + list.indexOf(130));
		System.out.println("Index of 131: " + list.indexOf(131));
		System.out.println("Index of 132: " + list.indexOf(132));
		System.out.println("Index of 999: " + list.indexOf(999));
		System.out.println("Index of 222: " + list.indexOf(222));
		System.out.println("Can we remove 132 from the list? " + list.remove(132));
		System.out.println("After removing 132, list is: "+list);
		System.out.println("Is this list empty? " + list.isEmpty());
		System.out.println("List in reverse order: " + list.reverse());

	}

}
