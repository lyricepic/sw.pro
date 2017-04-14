package P0414;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_Dij {
	
	static int N;
	static int E;
	static int[][] M;
	static int[] vis;
	static int[] dt;
	
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
			vis = new int[N+1];
			dt = new int[N+1];
			
			for(int i = 0; i < E; i++){
				int s = sc.nextInt();
				int d = sc.nextInt();
				int w = sc.nextInt();
				
				M[s][d] = w;
			}
			
			// SOLUTION
			int rst = f();
			
			// OUT
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static int f(){
		
		// 우선순위 큐 생성
		PriorityQueue<Pt> q = new PriorityQueue<Pt>();
		q.add(new Pt(0, 0));
		
		while(!q.isEmpty()){
			
			// dequeue
			Pt pt = q.poll();
			int n = pt.n;
			
			// 정점의 모든 인접 비용 갱신
			for(int i = 0; i <= N; i++){
				// 방문하지 않은 노드, 간선이 존재하는 노드에 대해서만 갱신
				if(M[n][i] != 0 && vis[i] == 0){
					// 기존 값 보다 큰값만 갱신하고 인큐
					if(dt[i] < M[n][i] + dt[n]){
						dt[i] = M[n][i] + dt[n];
						q.add(new Pt(i, dt[i]));
					}
				}
			}
		}
		
		return dt[N];
	}
}

class Pt implements Comparable<Pt>{

	int n;
	int w;
	
	Pt(int n, int w){
		this.n = n;
		this.w = w;
	}
	
	@Override
	public int compareTo(Pt o) {
		if(this.w > o.w)
			return -1;
		else if(this.w < o.w)
			return 1;
		else{
			return 0;		
		}
	}
}
