package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class g4_1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int arr[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(i==j) {
					arr[i][j]=0;
					continue;
				}
				if(n==0) {
					n = 100001;
				}
				arr[i][j] = n;
			}
		}
		for(int i=1; i<=N; i++) {//°æ
			for(int j=1; j<=N; j++) {//Ãâ
				if(i==j)continue;
				for(int k=1; k<=N; k++)//µµ
				{
					if(j==k || i==k) continue;
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
					arr[k][j] = arr[j][k];
				}
					
			}
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int start = Integer.parseInt(st.nextToken());

		boolean flag = true;
		for(int i=1; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			//System.out.println(arr[start][n]);
			if(arr[start][n]==100001) {
				flag = false;
				break;
			}
			
			start = n;
		}
		if(flag)System.out.println("YES");
		else System.out.println("NO");
		
	}
}
