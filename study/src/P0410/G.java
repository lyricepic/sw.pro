package P0410;

import java.io.FileInputStream;
import java.util.Scanner;

public class G {
	
	static int N;
	static int[][] M;
	static int[] visited;
	static int min;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			M = new int[N][N];
			visited = new int[N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					M[i][j] = sc.nextInt();
				}
			}
			
			// 솔루션
			
			f(0, 0);
			// 출력부
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void f(int n, int sum){
		
		if(n == N){
			min = min > sum ? sum : min;
			return;
		}
		
		for(int i = 0; i < N; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				f(n+1, sum + M[n][i]);
				visited[i] = 0;
			}
		}
	}
}
