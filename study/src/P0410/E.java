package P0410;

import java.io.FileInputStream;
import java.util.Scanner;

public class E {
	
	static int N;
	static int[][] M;
	static int[] visited;
	static int[] path;
	static int min;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			M = new int[N+1][N+1];
			visited = new int[N+1];
			path = new int[N+1];
			min = Integer.MAX_VALUE;
			
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					M[i][j] = sc.nextInt();
				}
			}
			
			// 솔루션
			f(2, 1, 0);
			
			// 출력부
			System.out.println("#" + test_case + " " + min);
		}
	}

	static void f(int n, int pi, int sum){
		
		if(n > N){
			sum += M[pi][1];
			min = min > sum ? sum : min;
			return;
		}
		
		for(int i = 2; i <= N; i++){
			if(visited[i] == 0 && M[pi][i] != 0){
				visited[i] = 1;
				path[n] = i;
				f(n+1, i, sum + M[pi][i]);
				visited[i] = 0;
			}
		}
	}
		


}
