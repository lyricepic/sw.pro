package P0414;

import java.io.FileInputStream;
import java.util.Scanner;

public class C {
	
	static int N;
	static int[] P;
	static int[][] dt;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// INPUT
			N = sc.nextInt();
			P = new int[N*2];
			dt = new int[N+1][N+1];
			boolean chk = true;
			
			int idx = 0;
			for(int i = 0; i < N*2; i++){
				int num = sc.nextInt();
				
				if(i == 0 || i % 2 != 0){					
					P[idx] = num;
					idx++;
				}else{
					if(P[idx-1] != num){
						chk = false;
					}
				}
			}
			
			// SOLUTION
			int rst = 0;
			if(chk){
				for(int l = 1; l <= N-1; l++){
					for(int i = 1; i <= N-l; i++){
						int j = i + l;
						int min = Integer.MAX_VALUE;
						for(int k = i; k <= j - 1; k++){
							int n1 = dt[i][k] + dt[k+1][j] + P[i-1] * P[k] * P[j];
							min = min > n1 ? n1 : min;
						}
						dt[i][j] = min; 
					}
				}
				rst = dt[1][N];
			}
			
			// OUT
			System.out.println("#" + test_case + " " + rst);
		}
	}
}
