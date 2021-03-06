package P0410;

import java.io.FileInputStream;
import java.util.Scanner;

public class C {
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// 입력부
			int cnt = sc.nextInt();
			int[] bin = new int[cnt*4];
			
			String strNum = sc.next();
			
			for(int i = 0; i < cnt; i++){
				
				int num = 0;
				
				if(strNum.charAt(i) >= 'A')
					num = strNum.charAt(i) - 'A' + 10;
				else
					num = strNum.charAt(i) - '0';
				
				for(int j = 0; j < 4; j++){
					int idx = (i*4)+(3-j);
							
					if(num > 0)
						bin[idx] = num % 2;
					else
						bin[idx] = 0;
					
					num = num / 2;
				}
			}
			// 솔루션
			String binStr = "";
			for(int i = 0; i < cnt*4; i++){
				binStr += bin[i];
			}
			
			// 출력부
			System.out.println("#" + test_case + " " + binStr);
		}
	}
}
