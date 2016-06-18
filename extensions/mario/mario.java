package mario;

public class mario {

	public static void main(String[] args) {
		
//		String m1 = "    #" + "\n" + "   ##" + "\n" + "  ###" + "\n" + " ####" + "\n" + "#####" ;
//		System.out.println(m1);
//		
//		System.out.println();
//		String m2 = "#" + "\n" + "##" + "\n" + "###" + "\n" + "####" + "\n" + "#####";
//		System.out.println(m2);
		
		String a = "#";
		String b = " ";
		
		for (int i = 1; i <= 5; i++){
			for (int c=1; c <=(5-i); c++){
				System.out.print(b);
			}
			for (int d=1; d <= i; d++){
				System.out.print(a);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <=5; i++){
			for (int c=1; c <= i; c++){
				System.out.print(a);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 5; i >= 1; i--){
			for (int c=1; c <=(5-i); c++){
				System.out.print(b);
			}
			for (int d=1; d <= i; d++){
				System.out.print(a);
			}
			System.out.println();
		}
		
		System.out.println();

		for (int i = 5; i >= 1; i--){
			for (int c=1; c <= i; c++){
				System.out.print(a);
			}
			System.out.println();
		}
	}

}
