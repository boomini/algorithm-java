package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt[]= new int[21];
		cnt.length;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
		}
		
		Arrays.sort(cnt);
		int sum = 0;
		for(int i=(20-K)+1; i<=20; i++) {
			sum+=cnt[i];
		}
		System.out.println(sum);
	}
}
