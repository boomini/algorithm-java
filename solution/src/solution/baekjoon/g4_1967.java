package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_1967 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N+1][N+1];
		for(int i=1; i<=N;i++) {
			Arrays.fill(arr[i], 1000001);
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1][n2] = Integer.parseInt(st.nextToken());
			arr[n2][n1] = arr[n1][n2];
		}
		

		for(int k=1; k<N; k++) {
			for(int i=1; i<=N; i++) {
				if(k==i) continue;
				for(int j=1; j<N; j++) {
					if(i==j||k==j)continue;
					arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j]!=1000001) {
					answer= Math.max(answer, arr[i][j]);
				}
				
			}
		}
		
		System.out.println(answer);
		
	}
}
