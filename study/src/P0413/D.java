package P0413;

import java.io.FileInputStream;
import java.util.Scanner;

public class D {
	
	static int R;
	static int C;
	static int[][] M;
	static int[][] dt;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			R = sc.nextInt();
			C = sc.nextInt();
			M = new int[R+1][C+1];
			dt = new int[R+1][C+1];
			
			for(int i = 0; i <= R; i++){
				for(int j = 0; j <= C; j++){
					if(i == 0){
						M[i][j] = 0;
					}else if(j == 0){
						M[i][j] = 0;
					}else{
						M[i][j] = sc.nextInt();
					}
				}
			}
			
			// 솔루션
			for(int i = 1; i <= R; i++){
				for(int j = 1; j <= C; j++){
					int n1 = dt[i-1][j];
					int n2 = dt[i][j-1];
					
					if(n1 == 0)
						n1 = Integer.MAX_VALUE;
					if(n2 == 0)
						n2 = Integer.MAX_VALUE;
					
					if(n1 == Integer.MAX_VALUE && n2 == Integer.MAX_VALUE){
						dt[i][j] = M[i][j];
					}else{
						int min = n1 < n2 ? n1 : n2;
						dt[i][j] = min + M[i][j];	
					}
				}
			}
			
			// 출력부
			System.out.println("#" + test_case + " " + dt[R][C]);
		}
	}
}
