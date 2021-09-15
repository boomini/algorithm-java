package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int dp[][] = new int[num+1][3];
		for(int i=1; i<=num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.min(dp[i-1][1]+R, dp[i-1][2]+R);
			dp[i][1] = Math.min(dp[i-1][0]+G, dp[i-1][2]+G);
			dp[i][2] = Math.min(dp[i-1][0]+B, dp[i-1][1]+B);

		}
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			answer = Math.min(dp[num][i], answer);
		}
		
		System.out.println(answer);
	}
	
}
