package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_5643 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			int MAX = 100001;
			int arr[][] = new int[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer( in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][j]==0) arr[i][j] = MAX;
				}
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					if(i==k) continue;
					for(int j=1; j<=N; j++) {
						if(i==j||j==k) continue;
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			
			int cnt = 0;
			outer : for(int i=1; i<=N; i++) {
				int check = 0;
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(arr[i][j]!=MAX) {
						check++;
					}else {
						if(arr[j][i]!=MAX) check++;
						else continue outer;
					}
				}
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
