package P0411;

import java.io.FileInputStream;
import java.util.Scanner;


public class B {
	
	static int N;
	static int[] Q;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){

			N = sc.nextInt();
			Q = new int[N+1];
			
			int lst = 0;
			for(int i = 0; i < N; i++){
				int num = sc.nextInt();
				int c = ++lst;
				int p = c / 2;
				Q[c] = num;
				
				while(Q[p] > Q[c] && c > 1){
					int a = Q[p];
					int b = Q[c];
					Q[p] = b;
					Q[c] = a;
					
					c = p;
					p = p/2;
				}
			}
			
			int sum = 0;
			int p = lst / 2;
			
			while(p != 0){
				sum += Q[p];
				p = p / 2;
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
