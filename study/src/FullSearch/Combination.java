package FullSearch;

public class Combination {
	
	static int K = 3;
	static int[] A = {1,2,3,4,5};
	static int[] C;
	
	public static void main(String[] args) {
		C = new int[K];
		f(5, K);
	}
	
	static void f(int n, int k){
		
		if(k == 0){
			// output
			for(int i = 0; i < K; i++){
				System.out.print(C[i]);
			}
			System.out.println();
			return;
		}else if(n < k){
			return;		
		}else{
			C[k-1] = A[n-1];
			f(n-1, k-1);
			f(n-1, k);
		}
	}
}
