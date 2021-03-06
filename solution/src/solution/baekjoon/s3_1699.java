package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		int[] dp = new int[N+1];
		dp[1] = 1;
		for(int i=2; i<N+1; i++) {
			dp[i] = i;
			for(int j=1; j*j <=i; j++)
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
					
		}
		System.out.println(dp[N]);
	}
}
