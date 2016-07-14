package studio6;

public class Methods {

	//factorial
	public static int fact(int n){
		if (n<=0){
			return 1;
		}
		else {
			return n*fact(n-1);
		}
	}
	//fibonacci
	public static int fib(int n){
		if (n<=1){
			return n;
		}
		else {
			return fib(n-1)+fib(n-2);
		}
	}
	//isOdd
	public static boolean isOdd(int n){
		if (n<=0){
			return false;
		}
		else {
			return !isOdd(n-1);
		}
	}
	//sum
	public static int sum(int a,int b){
		if (b<=0){
			return a;
		}
		else {
			return sum(a+1,b-1);
		}
	}
	//show the evaluation of
	// isOdd(3)=!isOdd(2)=!(!isOdd(1))=!(!(!isOdd(0)))=!(!(!false))=!(!true)=!(false)=true
	// sum(100,3)=sum(101,2)=sum(102,1)=sum(103,0)=103

	//sumDownBy2
	public static int sumDownBy2(int n){
		if (n<=1){
			if (n<=0){
				return 0;
			}
			else{
				return 1;
			}
		}
		else {
			return n+sumDownBy2(n-2);
		}
	}
	//harmonicSum
	public static double harmonicSum(int n){
		if (n<=1){
			return 1;
		}
		else {
			return 1.0/n+harmonicSum(n-1); //careful about integer division - returns double
		}
	}
	//mult
	public static int mult(int a, int b){
		if (b<=0){
			return 0;
		}
		else{
			return a+mult(a,b-1);
		}
	}

}
