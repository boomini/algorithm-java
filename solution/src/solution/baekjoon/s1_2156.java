package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_2156 {
	private static int arr[];
	private static int N;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[N];
		if(N>=1) {
			dp[0] = arr[0];
		}
		
		if(N>=2) {
			dp[1] = arr[0] + arr[1];
		}
		
		if(N>=3) {
			dp[2] = Math.max(arr[1]+arr[2], Math.max(dp[1], dp[0]+arr[2]));
		}
		for(int i=3; i<N; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], Math.max(dp[i-1], dp[i-2]+arr[i]));
		}
		System.out.println(dp[N-1]);
	}
	
}
