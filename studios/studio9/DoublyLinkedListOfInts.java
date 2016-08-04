package studio9;

import java.util.Iterator;

import exercises9.ListNode;

public class DoublyLinkedListOfInts implements IntList {

	private ListItem head, tail;
	private int size;

	public DoublyLinkedListOfInts() {
		this.head = new ListItem(000,null,null);
		this.tail = new ListItem(999,null,this.head);
		this.head.next = this.tail;
		this.size = 0;
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
	public Iterator<Integer> iterator() {
		return new DoublyLinkedListIterator();
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
		return count;
	}

	@Override
	public int indexOf(int item) {
		int i = 1;
		for (ListItem p = this.head.next; p.getValue() != item && p != this.tail; p = p.next){
			i = i + 1;
			if (p.next == this.tail){
				i=-1;
			}
		}
		return i;
	}

	@Override
	public boolean remove(int item) {
		for (ListItem p = this.head.next; p != this.tail; p = p.next){
			if (p.next.getValue() == item){
				p.setNext(p.next.next);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		DoublyLinkedListOfInts list = new DoublyLinkedListOfInts();
		list.addFirst(131);
		list.addFirst(130);
		list.addFirst(129);
		list.addLast(132);
		System.out.println(list);
		System.out.println("size:"+list.size());
		System.out.println("Index of 999: " + list.indexOf(999));
		System.out.println("Index of 130: " + list.indexOf(130));
		System.out.println("Can we remove 132 from the list? " + list.remove(132));
		System.out.println("After removing 132, list is: "+list);

	}

}
