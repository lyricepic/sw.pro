package P0414;

import java.io.FileInputStream;
import java.util.Scanner;

public class A {
	
	static int n;
	static int a;
	static int b;
	static long[][] ps;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// INPUT
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			ps = new long[n+2][n+2];
			
			for(int i = 0; i <= n+1; i++){
				for(int j = 0; j <= n+1; j++){
					if(i == 0 || j == 0){
						ps[i][j] = 0;
					}else{
						if(j == 1 || i == j){
							ps[i][j] = 1;
						}else{
							ps[i][j] = ps[i-1][j-1] + ps[i-1][j];
						}
					}
				}
			}
			
			// SOLUTION
			long sum = ps[n+1][b+1];
			
			// OUT
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
