package exercises9;

public class SinglyLinkedList {

	private ListNode<Integer> head;

	public SinglyLinkedList(){
		this.head = null;
	}

	// special case: suppose the list is empty
	public void addFirst(int val){
		ListNode<Integer> i = new ListNode<Integer>(val);
		// if the list is empty
		if (this.head == null){
			// head --> (val)
			this.head = i;
		}
		else {
			// head --> (x) --> (y)....
			//    put (i) in the beginning of the list
			i.next = this.head;
			this.head = i;
		}
	}
	
	public void addLast(int val){
		ListNode<Integer> i = new ListNode<Integer>(val);
		if (this.head == null){
			this.addFirst(val);
		}
		else {
			// head --> (x) --> (y) --> (z)
			ListNode<Integer> p = head;
			while (p.next != null){
				p = p.next;
			}
			// end of while loop: p.next == null
			// head --> (x) --> (y) --> (z)
			//                        p
			p.next = i;
		}
	}
	
	// head --> (100) --> (33) --> (22) --> (11)
	public void remove(int val){
		// this list may be empty?
		if (this.head == null){
			return; // nothing to do here, work done
		}
		else {
			// pointing to the left of the value you want to remove
			// so the first value is special case
			if (this.head.value == val){
				head = head.next;
			}
			else {
				ListNode<Integer> p = head;
				// keep going while I can see the node to the right
				while (p.next != null){
					if (p.next.value == val){
						p.next = p.next.next;
					}
					p = p.next;
				}
			}
		}
	}
	



	@Override
	public String toString() {
		String ans = "[";
		for (ListNode<Integer> p = head; p!=null; p = p.next){
			ans += p.value + " ";
		}
		ans = ans + "]";
		return ans;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(11);
		list.addFirst(14);
		list.addLast(55);
		System.out.println(list);
		list.remove(11);
		System.out.println(list);
	}

}
