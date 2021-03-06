package P0414;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B {
	
	static int N;
	static int E;
	static int[][] M;
	static int[] dt;
	static int[] st;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// INPUT
			N = sc.nextInt();
			E = sc.nextInt();
			M = new int[N+1][N+1];
			dt = new int[N+1];
			st = new int[N+1];
			
			for(int i = 0; i < E; i++){
				int s = sc.nextInt();
				int d = sc.nextInt();
				int w = sc.nextInt();
				
				M[s][d] = w;
				
				// 위상정렬테이블
				st[d]++;
			}
			
			// SOLUTION
			int rst = sort();
			
			
			// OUT
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static int sort(){
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i <= N; i++){
			if(st[i] == 0){
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			
			int n = q.poll();
			int max = 0;

			for(int i = 0; i <= N; i++){
				if(M[i][n] != 0){
					int v = M[i][n] + dt[i];
					max = max < v ? v : max;
				}
			}
			dt[n] = max;
			
			for(int i = 0; i <= N; i++){
				if(M[n][i] != 0){
					st[i]--;
					if(st[i] == 0){
						q.add(i);
					}
				}
			}
		}
		
		return dt[N];
	}
}

