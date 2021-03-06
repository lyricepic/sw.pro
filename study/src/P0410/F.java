package P0410;

import java.io.FileInputStream;
import java.util.Scanner;

public class F {
	
	static int N;  // 정류장수
	static int[] S;
	static int min;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			S = new int[N+1];
			min = Integer.MAX_VALUE;
			
			for(int i = 1; i < N; i++){
				S[i] = sc.nextInt();
			}
			
			// 솔루션
			f(2, S[1]-1, 0);
			
			// 출력부
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void f(int n, int remain, int chg){
		
		if(n == N){
			min = min > chg ? chg : min;
			return;
		}
		
		if(remain == 0){
			f(n+1, S[n] - 1, chg + 1);
		}else{
			f(n+1, S[n] - 1, chg + 1);
			f(n+1, remain - 1, chg);	
		}
	}
}
