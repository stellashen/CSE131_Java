package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("What's the number of rows?");
		int[][] triangle = new int[N][N];
		for (int r=0; r<N; ++r){
			for (int c=0; c<N; ++c){
				if (c==0||c==r){
					triangle[r][c]=1;
				}
				else if (c>r){
					triangle[r][c]=0;
				}
				else {
					triangle[r][c]=triangle[r-1][c]+triangle[r-1][c-1];
				}
				if (triangle[r][c]==0){
					System.out.print("   ");
				}
				else if (triangle[r][c]<10){
					System.out.print(triangle[r][c]+"  ");
				}
				else {
					System.out.print(triangle[r][c]+" ");
				}
			}
			System.out.println();
		}
	}
}
