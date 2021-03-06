package P0413;

import java.io.FileInputStream;
import java.util.Scanner;

public class A {
	
	static int N;
	static int K;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			
			// 솔루션
			// sum to N
			int ts = 0;
			for(int i = 1; i <= N; i++){
				ts += i;
			}
			
			f(1, 0, ts);
			
			// 출력부
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	static void f(int n, int sum, int remain){
		
		if(sum == K){
			cnt++;
			return;
		}
		
		if(n > N)
			return;
				
		if(sum > K)
			return;
		
		if(sum + remain < K)
			return;
		
		f(n+1, sum+n, remain-n);
		f(n+1, sum, remain-n);
	}
}
