package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], 50000);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			dp[n1][n2] = 1;
			dp[n2][n1] = 1;
		}
		
		//°æÃâµµ
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				if(i==k) continue;
				for(int j=0; j<N; j++) {
					if(i==j || k==j)continue;
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
					dp[j][i] = dp[i][j];
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		int ansval = 0;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				sum+=dp[i][j];
			}
			if(ans>sum) {
				ansval =i;
				ans=sum;
			}
		}
		
		System.out.println(ansval+1);
	}
}
