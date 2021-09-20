package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_9205 {
	// 플로이드
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N + 2][2];

			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						dp[i][j] = 0;
					else {
						int dis = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
						if(dis/50<20||(dis/50==20&&dis%50==0)) {
							dp[i][j] = 1;
						}
						if(dp[i][j]==0) dp[i][j] = 100000;
					}
				}
			}
			
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					if(i==k) continue;
					for(int j=0; j<N+2; j++) {
						if(j==k || i==j) continue;
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[j][k]);
					}
				}
			}
			
			if(dp[0][N+1]==100000) {
				sb.append("sad").append("\n");
			}else{
				sb.append("happy").append("\n");
			};
		}
		System.out.println(sb.toString());
	}

}
