package P0410;

import java.io.FileInputStream;
import java.util.Scanner;

public class D {
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			int n = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int mat[][] = new int[n][n];
			
			// 솔루션
			int num = 0;
			for(int i = 0; i < n-1; i++){
				for(int j = 0; j < n-i-1; j++){
					mat[j][i+j+1] = ++num;
				}
			}
			
			// 출력부
			System.out.println("#" + test_case + " " + mat[r][c]);
		}
	}
}
