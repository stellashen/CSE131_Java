package lab6;

public class Methods {
	
	//
	// In this class, implement the f and g functions described on the lab page
	//
	
	/**
	 * 
	 * @param x
	 * @return x-10 if x > 100; f(f(x+11)) if x <=100
	 */
	public static int f(int x){
		if (x>100){
			return x-10;
		}
		else {
			return f(f(x+11));
		}
	}
	// f(99) = f(f(99+11))=f(f(110))=f(100)=f(f(111))=f(101)=101-10=91
	// f(87) = f(f(87+11))=f(f(98))=f(f(f(98+11)))=f(f(f(109)))=f(f(99))=f(91)
	// =f(f(102))=f(92)=f(f(103))=f(93)=f(f(104))=f(94)=...=f(101)=91
	
	/**
	 * 
	 * @param x non-negative int
	 * @param y non-negative int
	 * @return y+1 (if x=0); 
	 * g(x-1,1) (if x >0 and y=0); 
	 * g(x-1,g(x,y-1)) (if x>0 and y>0)
	 */
	public static int g(int x, int y){
		if (x<=0){
			return y+1;
		}
		else {
			if (y<=0){
				return g(x-1,1);
			}
			else{
				return g(x-1,g(x,y-1));
			}
		}
	}
	// sketch: notes
	
	public static void main(String[] args) {
		
		//
		// from here, call f or g with the appropriate parameters
		//
		System.out.println("f(99) = "+f(99)+" ; f(87) = " + f(87));
		System.out.println("g(1,0) = "+g(1,0)+" ; g(1,2) = "+g(1,2)+" ; g(2,2) = "+g(2,2));
		System.out.println(g(3,11));
		System.out.println(g(4,0));
		System.out.println(g(4,1));
//		System.out.println(g(4,2));
//		System.out.println(g(4,3));
//		System.out.println(g(4,4));
//		System.out.println(g(4,5));
//		System.out.println(g(4,6));

	}

}
