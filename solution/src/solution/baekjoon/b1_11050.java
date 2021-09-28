package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 1;
		for(int i=1; i<=N; i++) {
			answer*=i;
		}
		
		for(int i=1; i<=K; i++) {
			answer/=i;
		}
		
		for(int i=1; i<=N-K; i++) {
			answer/=i;
		}
		
		System.out.println(answer);
	}
}
