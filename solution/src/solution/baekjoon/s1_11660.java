package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x1=0,x2=0,y1=0,y2=0;
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int i=x1-1; i<=x2-1; i++) {
				for(int j=y1-1; j<=y2-1; j++) {
					sum+=arr[i][j];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
