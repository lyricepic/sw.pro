package P0413;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
	
	static int N;
	static int[][] M;
	static int[][] vis;
	static int[][] dt;
	
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
			dt = new int[N][N];
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					M[i][j] = sc.nextInt();
					dt[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// 솔루션
			int rst = djk();
			
			// 출력부
			System.out.println("#" + test_case + " " + rst);
		}
	}
	
	static int djk(){
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		PriorityQueue<Pt> que = new PriorityQueue<Pt>();
		que.offer(new Pt(0, 0, M[0][0]));
		
		while(!que.isEmpty()){
			
			Pt p = que.poll();
			vis[p.r][p.c] = 1;
			
			for(int i = 0; i < 4; i++){
				int r = p.r + dr[i];
				int c = p.c + dc[i];
				
				if(r >= 0 && c >= 0 && r < N && c < N){
					if(vis[r][c] == 0){
						if(dt[r][c] > (p.w + M[r][c] + 1)){
							dt[r][c] = p.w + M[r][c] + 1;
							que.offer(new Pt(r, c, dt[r][c]));
						}
					}				
				}
			}
		}
		
		return dt[N-1][N-1];
	}
}

class Pt implements Comparable<Pt>{

	int r;
	int c;
	int w;
	
	Pt(int r, int c, int w){
		this.r = r;
		this.c = c;
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
