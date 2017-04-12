package P0411;

import java.io.FileInputStream;
import java.util.Scanner;

public class E {
	
	static int N;
	static int E;
	static int[][] M;
	static int[] visited;
	static int min;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){

			N = sc.nextInt();
			E = sc.nextInt();
			M = new int[N+1][N+1];
			visited = new int[N+1];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < E; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				M[a][b] = 1;
			}
			
			dfs(0, 0);
			
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void dfs(int n, int cnt){
		
		if(n == N){
			min  = min > cnt ? cnt : min;
			return;
		}
		
		for(int i = 0; i <= N; i++){
			if(visited[i] == 0 && M[n][i] == 1){
				visited[i] = 1;
				dfs(i, cnt + 1);
				visited[i] = 0;
			}
		}
	}
}
