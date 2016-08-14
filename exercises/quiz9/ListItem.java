package quiz9;

public class ListItem {
	final int number;
	ListItem next;

	public ListItem(int number, ListItem next) {
		super();
		this.number = number;
		this.next = next;
	}

	public void dup(){
		ListItem p = this.next;
		this.next = new ListItem(this.number,p);
		if (p != null){
			p.dup();
		}
	}

	public int count(int n){
		if (this.next == null){
			if (this.number == n){
				return 1;
			}
			else {
				return 0;
			}
		}
		else{
			if (this.number == n){
				return 1+this.next.count(n);
			}
			else {
				return this.next.count(n);
			}
		}
	}

	@Override
	public String toString() {
		return "ListItem [number=" + number + ", next=" + next + "]";
	}

	public static void main(String[] args) {
		ListItem item = new ListItem(1,null);
		System.out.println(item.count(1));
		System.out.println(item.count(9));
		
		item.dup();
		System.out.println(item);
		System.out.println(item.count(1));
		System.out.println(item.count(9));
		
		ListItem item2 = new ListItem(1,new ListItem(2,new ListItem(3,null)));
		System.out.println(item2.count(3));
		System.out.println(item2.count(2));
		item2.dup();
		System.out.println(item2);
		System.out.println(item2.count(3));
		System.out.println(item2.count(2));

	}

}
