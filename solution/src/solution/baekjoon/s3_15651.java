package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_15651 {
	private static int N;
	private static int M;
	private static int num[];
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		num = new int[M];
		permutation(0);
		System.out.println(sb.toString());
	}
	private static void permutation(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			num[cnt] =i;
			permutation(cnt+1);
		}
		
	}
}
