package P0411;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class F {

	static int N;
	static int R;
	static int[][] M;
	static int[] tp;
	static int[] coin;
	static int max;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// �Էº�
			N = sc.nextInt();
			R = sc.nextInt();
			M = new int[N+1][N+1];
			tp = new int[N+1];
			coin = new int[N+1];
			max = 0;
			
			for(int i = 0; i < R; i++){
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				M[s][e] = 1;
				tp[e]++;
			}
			
			// �ַ��
			sort();
			
			// ��º�
			System.out.println("#" + test_case + " " + (max+1));
		}
	}
	
	static void sort(){
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++){
			if(tp[i] == 0){
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			int n = q.poll();
			for(int i = 1; i <= N; i++){
				if(M[n][i] == 1){
					// ������ �������� ����
					tp[i]--;
					// ���������� 0�ΰ͸� ť�� �߰�
					if(tp[i] == 0){
						q.add(i);
						coin[i] = coin[n] + 1;
						max = max < coin[i] ? coin[i] : max;
					}
				}
			}
		}
	}
}
