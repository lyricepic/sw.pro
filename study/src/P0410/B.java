package P0410;
import java.io.FileInputStream;
import java.util.Scanner;

public class B {
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int test_case;
		
		for(test_case = 1; test_case <= T; test_case++){
			// �Էº�
			int N = sc.nextInt();
			int num;
			int[] count = new int[10];
			
			String strCard = sc.next();
			
			for(int i = 0; i < N; i++){
				num = strCard.charAt(i) - '0';
				count[num]++;
			}
			
			// �ַ��
			int max = 0;
			int maxNum = 0;
			
			for(int i = 0; i < 10; i++){
				if(max < count[i]){
					max = count[i];
					maxNum = i;
				}else if(max == count[i]){
					max = count[i];
					maxNum = maxNum < i ? i : maxNum;
				}
			}
			
			// ��º�
			System.out.println("#" + test_case + " " + maxNum + " " + max);
		}
	}
}