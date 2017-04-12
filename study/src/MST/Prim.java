package MST;

import java.io.FileInputStream;
import java.util.Scanner;

public class Prim {
	static int V;
 	static int E;
 	static int [][] adj; // �������
 	static int mst[]; // mst ���� ����
 
 
 	public static void main(String[] args) throws Exception{
 		System.setIn(new FileInputStream("test.txt"));
 		Scanner sc = new Scanner(System.in);
 		
 		int T = sc.nextInt();
 		for(int tc=1; tc<=T;tc++)
 		{
 			V = sc.nextInt();
 			E = sc.nextInt();
 			adj = new int[V+1][V+1];
 			mst = new int[V+1];
 
 			for(int i=0;i<E; i++)
 			{
 				int n1 = sc.nextInt();
 				int n2 = sc.nextInt();
 				int w=sc.nextInt();
 				adj[n1][n2] = w;
 				adj[n2][n1] = w;
 			}
 			int sum = prim();
 			System.out.println("#"+tc+" "+sum);
 		}
 	}
 	public static int prim()
 	{
 		mst[0] = 1;
 		int cnt= 1;
 		int sum = 0;
 		while(cnt<(V+1))
 		{	
 			int min = Integer.MAX_VALUE;
 			int minIdx = 0;
 			for(int i = 0; i<=V; i++)
 			{
 				if(mst[i]==1) // mst�� ���Ե� ����� 
 				{
 					for(int j =0; j<=V; j++) // ���
 					{
 						if(adj[i][j]!=0&&mst[j]==0) // mst �������� ���� ��忡 ����
 						{
 							if(min>adj[i][j]) // ����� �ּ��� ��带
 							{
 								min = adj[i][j];
 								minIdx = j; 
 							}
 						}
 					}
 				}
 			}
 			mst[minIdx] = 1; // mst�� �߰�
 			sum += min; // mst ������ ��� ����
 			cnt++;
 		}
 		return sum;
 	}
}
