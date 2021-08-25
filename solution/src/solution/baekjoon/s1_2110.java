package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_2110 {
	private static int N;
	private static int C;
	private static int X[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = new int[N];
		for(int i=0; i<N; i++) {
			X[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(X);
		int start = 1;
		int last = distance(X[0], X[N-1]);		
			
		int mid = 0;
		int max = 0;
		while(start<=last) {
			mid = (start + last) / 2;
			int cnt = 1;
			int num = X[0];	
			for(int i=1; i<N; i++) {
				if(distance(num,X[i])<mid)continue;
				cnt++;
				num = X[i];
			}
			if(cnt>=C) {
				
				start = mid+1;
				//놓을 수 있는 값이 원하는 값보다 크거나 같으면 더 큰거리 탐색
				max = Math.max(max, mid);
				//놓을 수 있는 가능한 거리 중 가장 큰값.
			}
			else last = mid-1;
			//놓을 수 있는 값이 원하는 값보다 작으면 더 작은거리 탐색.
		}
		
		System.out.println(max);	
	}
	
	private static int distance(int x, int y) {
		return Math.abs(x-y);
	}
}
