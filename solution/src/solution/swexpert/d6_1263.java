package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d6_1263 {
	//플로이드 로샬
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int dp[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					if(i==j) continue;
					if(dp[i][j]==0) dp[i][j] = 1000000;
				}
			}
			for(int k=0; k<N; k++) { // 들릴 정점
				for(int i=0; i<N; i++) {//출발지
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(i==j||j==k) continue;
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum+=dp[i][j];
					//System.out.print(dp[i][j]);
				}
				min = Math.min(min, sum);
				//System.out.println();
			}
			
			sb.append(min).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
