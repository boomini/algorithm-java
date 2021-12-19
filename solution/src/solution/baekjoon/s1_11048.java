package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dp[][] = new int[N][M];
		int dir[][] = {{1,0},{0,1},{1,1}};
		dp[0][0] = arr[0][0];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int d=0; d<3; d++) {
					int ni = i+dir[d][0];
					int nj = j+dir[d][1];
					
					if(ni>=0 && ni<N && nj>=0 && nj<M) {
						dp[ni][nj]=Math.max(dp[i][j]+arr[ni][nj], dp[ni][nj]);
					}
				}
			}
		}
		
		
		System.out.println(dp[N-1][M-1]);

	}

}
