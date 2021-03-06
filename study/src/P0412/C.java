package P0412;

import java.io.FileInputStream;
import java.util.Scanner;

public class C {
	
	static int N;
	static char[] TEXT;
	static int TEXT_LENGTH;
	static char[][] M;
	static int[][] vis;
	static int rst = 0;
	static int[][][] dt;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			TEXT = new char[N];
			M = new char[N][N];
			vis = new int[N][N];
			rst = 0;
			dt = new int[N][N][N+1];
			
			String strText = sc.next();
			TEXT_LENGTH = strText.length();
			for(int i = 0; i < TEXT_LENGTH; i++){
				TEXT[i] = strText.charAt(i);
			}
			
			for(int i = 0; i < N; i++){
				String strCard = sc.next();
				for(int j = 0; j < N; j++){
					M[i][j] = strCard.charAt(j);		
				}
			}			
			// 솔루션
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(M[i][j] == TEXT[0] && dt[i][j][0] == 0){
						
						f(i ,j, 0);
						
						if(rst == 1)  // 결과만 알면 되기 때문에 찾으면 바로 나가는 코드 필요!!
							break;
					}
				}
				
				if(rst == 1)  // 결과만 알면 되기 때문에 찾으면 바로 나가는 코드 필요!!
					break;
			}

			// 출력부
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static void f(int r, int c, int n){
		
		dt[r][c][n] = 1;
		
		if(n == TEXT_LENGTH){
			rst = 1;
			return;
		}
		
		if(c+1 < N && M[r][c+1] == TEXT[n] && vis[r][c+1] == 0 && dt[r][c+1][n] == 0){
			vis[r][c+1] = 1;
			f(r, c+1, n+1);
			vis[r][c+1] = 0;
		}
		if(r+1 < N && M[r+1][c] == TEXT[n] && vis[r+1][c] == 0 && dt[r+1][c][n] == 0){
			vis[r+1][c] = 1;
			f(r+1, c, n+1);
			vis[r+1][c] = 0;
		}
		if(c-1 >= 0 && M[r][c-1] == TEXT[n] && vis[r][c-1] == 0 && dt[r][c-1][n] == 0){
			vis[r][c-1] = 1;
			f(r, c-1, n+1);
			vis[r][c-1] = 0;
		}
		if(r-1 >= 0 && M[r-1][c] == TEXT[n] && vis[r-1][c] == 0 && dt[r-1][c][n] == 0){
			vis[r-1][c] = 1;
			f(r-1, c, n+1);
			vis[r-1][c] = 0;
		}
	}
}
