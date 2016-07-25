package exercises6;

public class Quiz6_PascalsTriangle {

	public static int pascal(int x, int y){
		if (x==0){
			return 1;
		}
		else {
			if (y==0){
				return 1;
			}
			else {
				return pascal(x-1,y)+pascal(x,y-1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(pascal(5,5));

	}

}
