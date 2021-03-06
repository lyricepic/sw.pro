package P0412;

import java.io.FileInputStream;
import java.util.Scanner;

public class B {
	
	static int N;
	static int[][] M;
	static int[][] vis;
	static int ER;
	static int EC;
	static int rst = 0;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			M = new int[N][N];
			vis = new int[N][N];
			ER = -1;
			EC = -1;
			int str = -1;
			int stc = -1;
			rst = 0;
			
			for(int i = 0; i < N; i++){
				String strCard = sc.next();
				
				for(int j = 0; j < N; j++){
					M[i][j] = strCard.charAt(j) - '0';
					if(M[i][j] == 2){
						str = i;
						stc = j;
					}
					else if(M[i][j] == 3){
						ER = i;
						EC = j;
					}
				}
			}
			
			// 솔루션
			if(str == -1 || ER == -1){
				rst = 0;
			}else{
				f(str, stc);			
			}

			
			// 출력부
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static void f(int r, int c){
		
		if(r == ER && c == EC){
			rst = 1;
			return;
		}
		
		if(r+1 < N && M[r+1][c] != 1 && vis[r+1][c] == 0){
			vis[r+1][c] = 1;
			f(r+1, c);
			vis[r+1][c] = 0;
		}
		if(c+1 < N && M[r][c+1] != 1 && vis[r][c+1] == 0){
			vis[r][c+1] = 1;
			f(r, c+1);
			vis[r][c+1] = 0;
		}
		if(r-1 >= 0 && M[r-1][c] != 1 && vis[r-1][c] == 0){
			vis[r-1][c] = 1;
			f(r-1, c);
			vis[r-1][c] = 0;
		}
		if(c-1 >= 0 && M[r][c-1] != 1 && vis[r][c-1] == 0){
			vis[r][c-1] = 1;
			f(r, c-1);
			vis[r][c-1] = 0;
		}
	}
}
