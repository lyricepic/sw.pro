package P0411;

import java.io.FileInputStream;
import java.util.Scanner;

public class A {
	
	static int E;
	static int N;
	static int[] P;
	static int[] C1;
	static int[] C2;
	static int pc;
	static int cc;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){

			E = sc.nextInt();
			N = sc.nextInt();
			P = new int[E+2];
			C1 = new int[E+2];
			C2 = new int[E+2];
			pc = 0;
			cc = 0;
			
			for(int i = 1; i <= E; i++){
				int parent = sc.nextInt();
				int child = sc.nextInt();
				if(C1[parent] == 0)
					C1[parent] = child;
				else
					C2[parent] = child;
				
				P[child] = parent;
			}
			
			vlr(N);
			vlr2(N);
			
			System.out.println("#" + test_case + " " + pc + " " + cc);
		}
	}
	
	static void vlr(int n){
		if(P[n] != 0){
			pc ++;
			vlr(P[n]);
		}
	}
	
	static void vlr2(int n){
		if(C1[n] != 0){
			cc++;
			vlr2(C1[n]);
		}
		
		if(C2[n] != 0){
			cc++;
			vlr2(C2[n]);
		}
	}
}
