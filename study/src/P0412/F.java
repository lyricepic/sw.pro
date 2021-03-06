package P0412;

import java.io.FileInputStream;
import java.util.Scanner;

public class F {
	
	static int V;
	static int E;
	static int[][] M;
	static int[] vis;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			V = sc.nextInt();
			E = sc.nextInt();
			M = new int[V+1][V+1];
			vis = new int[V+1];
			
			for(int i = 0; i < E; i++){
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int value = sc.nextInt();
				
				M[n1][n2] = value;
				M[n2][n1] = value;
			}
			
			// 솔루션
			int rst = prim();
			
			// 출력부
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static int prim(){
		
		vis[0] = 1;
		int cnt = 1;
		int sum = 0;
		
		while(cnt <= V){
			int mv = Integer.MAX_VALUE;
			int mi = 0;
			
			for(int i = 0; i <= V; i++){
				if(vis[i] == 1){
					for(int j = 0; j <= V; j++){
						if(M[i][j] != 0 && mv > M[i][j] && vis[j] == 0){
							mv = M[i][j];
							mi = j;
						}
					}
				}
			}
			
			vis[mi] = 1;
			sum += mv;
			cnt++;
		}
		
		return sum;
	}
}
