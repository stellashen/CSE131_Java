package exercises9;

public class SinglyLinkedListWithSentinels {

	private ListNode<Integer> head;

	public SinglyLinkedListWithSentinels(){
		head = new ListNode<Integer>(7);
	}

	// special case: suppose the list is empty
	public void addFirst(int val){
		ListNode<Integer> p = new ListNode<Integer>(val);
		p.next = head.next;
		head.next = p;
	}

	public void addLast(int val){
		ListNode<Integer> p = new ListNode<Integer>(val);

		// find the end of the list

		// q walk through the list
		// until q.next == null
		ListNode<Integer> q = head;
		while (q.next != null){
			q = q.next;	
		}
		q.next = p; // insert p there so p = null
	}

	public int size(){
		int ans = 0;
		for (ListNode<Integer> p = head.next; p!=null; p = p.next){
			ans = ans + 1;
		}
		return ans;
	}

	// head -->(7) --> (100) --> (33) --> (22) --> (11)
	public void remove(int val){
		ListNode<Integer> p = head.next;
		// keep going while I can see the node to the right
		while (p.next != null){
			if (p.next.value == val){
				p.next = p.next.next;
			}
			p = p.next;
		}
	}




	@Override
	// modify toString to skip over the first dummy node in this list:
	// change p = head to p = head.next
	public String toString() {
		String ans = "[";
		for (ListNode<Integer> p = head.next; p!=null; p = p.next){
			ans += p.value + " ";
		}
		ans = ans + "]";
		return ans;
	}

	public static void main(String[] args) {
		SinglyLinkedListWithSentinels list = new SinglyLinkedListWithSentinels();
		list.addFirst(131);
		list.addFirst(132);
		list.addLast(131);
		System.out.println(list);
		list.remove(131);
		System.out.println(list);
		System.out.println(list.size());
	}
}
