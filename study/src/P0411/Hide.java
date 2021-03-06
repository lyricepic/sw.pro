package P0411;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Hide {
	
	static int N;
	static int K;
	static int MAX = 100000;
	static int minTime;
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			K = sc.nextInt();
			minTime = 0;
			visited = new int[MAX + 1];
			
			// 출력부
			System.out.println("#" + test_case + " " + bfs());
		}
	}
	
	static int bfs(){
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.add(N);
		
		while(!q.isEmpty()){
			
			int p = q.poll();
			
			if(p == K){
				return visited[p];
			}
			
			if((p+1) <= MAX && visited[p+1] == 0){
				q.add(p+1);
				visited[p+1] = visited[p] + 1;
			}
			if((p-1) >= 0 && visited[p-1] == 0){
				q.add(p-1);
				visited[p-1] = visited[p] + 1;
			}
			if((p*2) <= MAX && visited[p*2] == 0){
				q.add(p*2);
				visited[p*2] = visited[p] + 1;
			}
		}
		return 0;
	}
}
