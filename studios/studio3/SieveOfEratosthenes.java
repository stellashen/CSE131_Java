package studio3;

import cse131.ArgsProcessor;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("What's the length of the array? (Length >= 3)");

		int[] prime = new int[n];// there are n numbers in the array, starting from 0...n-1

//		//check what's in the array
//				for (int i: prime){
//					System.out.println("before assigning values " + i); 
//				// all 0
//				}
		
		// prime[2]=2, prime[n-1]=n-1
		for (int i=2; i < n; ++i){
			prime[i]=i;
		}
		
//		// check
//		for (int i=0; i< n; ++i){
//		System.out.println("prime[" + i + "]= " + prime[i]);
//		}
		
		for (int i=2; i < n; ++i){
			if (prime[i] != 0){
				int p = prime[i];
				for (int j = p; j < n; ++j){
					if (prime[j]%p == 0 && prime[j] != p){
						prime[j] = 0;
					}
				}
			}
		}
		System.out.print("Primes under " + n + " = 2");
		for (int i=3; i < n; ++i){
			if (prime[i] != 0){
				System.out.print(", " + prime[i]);
			}
		}

	}

}
