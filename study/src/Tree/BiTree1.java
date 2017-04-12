package Tree;

import java.io.FileInputStream;
import java.util.Scanner;

public class BiTree1 {
	
	static int[] ch1;
	static int[] ch2;
	static int[] par;
	static int V;
	static int E;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			V = sc.nextInt();
			E = sc.nextInt();
			ch1 = new int[V+1];
			ch2 = new int[V+1];
			par = new int[V+1];
			
			for(int i = 0; i < E; i++){
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(ch1[n1] == 0)
					ch1[n1] = n2;
				else
					ch2[n1] = n2;
				par[n2] = n1;
			}
			
			// 5의 조상 찾기
			int c = 5;
			while(par[c] != 0){
				c = par[c];
				System.out.print(c + " ");
			}
			
			System.out.println();
			
			// 순회
			vlr(1);
			System.out.println();
			lvr(1);
			System.out.println();
			lrv(1);
			
		}
	}
	
	static void vlr(int n){
		if(n != 0){
			System.out.print(n + " ");
			vlr(ch1[n]);
		}
	}
	
	static void lvr(int n){
		
	}
	
	static void lrv(int n){
		
	}
}
