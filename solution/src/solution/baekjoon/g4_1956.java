package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int arr[][] = new int[V+1][V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[v1][v2] = w;
		}
		
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(arr[i][j]==0)arr[i][j] = 10001;
			}
		}
		
		for(int k=1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i=1; i<=V; i++) {
			answer = Math.min(arr[i][i], answer);
		}
		if(answer==10001) answer=-1;
		System.out.println(answer);
	}
}
