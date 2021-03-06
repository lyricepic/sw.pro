package P0413;

import java.io.FileInputStream;
import java.util.Scanner;

public class C {
	
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
					int max = n1 > n2 ? n1 : n2;
					dt[i][j] = max + M[i][j];
				}
			}
			
			// 출력부
			System.out.println("#" + test_case + " " + dt[R][C]);
		}
	}
}
