package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc<T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int arr[][] = new int[2][N];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int dp[][] = new int[2][N];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			for(int i=1; i<N; i++) {
				for(int j=0; j<2; j++) {
					dp[j][i] = Math.max(dp[j][i-1], dp[(j+1)%2][i-1]+arr[j][i]);
				}
			}
			sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
		}
		System.out.println(sb.toString());
	}
}
