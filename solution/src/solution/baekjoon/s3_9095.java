package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_9095 {
	private static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			cnt = 0;
			int N = Integer.parseInt(in.readLine());
			
			int dp[] = new int[N+1];
			
			
			dfs(dp, N,0);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int[] dp, int n, int i) {
		if(i>=n) {
			if(i==n) {
				cnt++;
			}	
			return;
		}
		dp[i]+=1;
		
		for(int j=1; j<=3; j++) {
			dfs(dp,n,i+j);
		}
	}
}
