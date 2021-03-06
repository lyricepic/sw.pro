package P0410;
import java.io.FileInputStream;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i = 0; i < n; i++){
				a[i] = sc.nextInt();
			}
			
			// 솔루션
			int min = Integer.MAX_VALUE;
			int max = 0;
			
			for(int i = 0; i < n; i++){
				min = min > a[i] ? a[i] : min;
				max = max < a[i] ? a[i] : max;
			}
			
			int s = max - min;
			
			// 출력부
			System.out.println("#" + test_case + " " + s);
		}
	}
}
