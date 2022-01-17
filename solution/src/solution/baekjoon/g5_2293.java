package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[K+1];
		int coin[] = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		dp[0] = 1;
		for(int i=0; i<N; i++) {
			int cur = coin[i];
			for(int j=cur; j<=K; j++) {
				dp[j] += dp[j-cur];
			}
		}
		System.out.println(dp[K]);
	}
}
