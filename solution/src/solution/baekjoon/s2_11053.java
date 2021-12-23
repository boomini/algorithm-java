package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		
		dp[0]= 1;
		
		for(int i=1; i<N; i++) {
			int idx = 1;
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]&&max<dp[j]) {
					max = dp[j];
					idx = dp[j]+1;
				}
			}
			dp[i] = idx;
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println();
		System.out.println(ans);
		
	}
}
