package P0412;

import java.io.FileInputStream;
import java.util.Scanner;

public class A {
	
	static int R;
	static int C;
	static int[][] M;
	static int min;
	static int[][] vis;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			R = sc.nextInt();
			C = sc.nextInt();
			M = new int[R][C];
			min = Integer.MAX_VALUE;
			vis = new int[R][C];
			
			for(int i = 0; i < R; i++){
				for(int j = 0; j < C; j++){
					M[i][j] = sc.nextInt();
				}
			}
			
			// 솔루션
			f(0, 0, M[0][0]);
			
			if(min == Integer.MAX_VALUE)
				min = 0;
			
			// 출력부
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void f(int r, int c, int sum){
		
		if(r == R-1 && c == C-1){
			min = min > sum ? sum : min;
			return;
		}
		
		if(r+1 < R && M[r+1][c] != 0 && vis[r+1][c] == 0){
			vis[r+1][c] = 1;
			f(r+1, c, sum + M[r+1][c]);
			vis[r+1][c] = 0;
		}
		
		if(c+1 < C && M[r][c+1] != 0 && vis[r][c+1] == 0){
			vis[r][c+1] = 1;
			f(r, c+1, sum + M[r][c+1]);
			vis[r][c+1] = 0;
		}
	}
}
