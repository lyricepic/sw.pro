package FullSearch;

import java.io.FileInputStream;
import java.util.Scanner;

public class Permutaion {

	static int N;
	static int A[];
	static int p[];
	static int visited[];
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			A = new int[N+1];
			p = new int[N+1];
			visited = new int[N+1];
			
			for(int i = 1; i <= N; i++){
				A[i] = sc.nextInt();
			}
			
			// 솔루션
			System.out.println("#" + test_case);
			
			nPk(1, N);
			
			// 출력부

		}
	}
	
	static void nPk(int n, int k){
		
		if(k == 0){
			for(int i = 1; i <= N; i++){
				System.out.print(p[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				p[n] = A[i];
				nPk(n+1, k-1);
				visited[i] = 0;
			}
		}
	}

}
