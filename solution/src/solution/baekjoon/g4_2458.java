package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_2458 {
	private static boolean check[][];
	private static boolean visited[];
	private static ArrayList<Integer>[] b;
	private static ArrayList<Integer>[] s;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		check = new boolean[N+1][N+1];
		
		b= new ArrayList[N+1];//큰거
		s= new ArrayList[N+1];//작은거
		for(int i=1; i<=N; i++) {
			b[i] = new ArrayList<Integer>();
			s[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			b[n1].add(n2);
			s[n2].add(n1);
		}
		
		for(int i=1; i<=N; i++) {
			BFS(i,b);
			BFS(i,s);
		}
		int ans=0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(check[i][j])cnt++;
			}
			if(cnt==N-1)ans++;
		}
		System.out.println(ans);
		
	}
	private static void BFS(int i, ArrayList<Integer>[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N+1];
		q.add(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int k=0; k<arr[n].size(); k++) {
				check[i][arr[n].get(k)] = true;
				if(!visited[arr[n].get(k)]) {
					visited[arr[n].get(k)]=true;	
					q.add(arr[n].get(k));
				}
			}
		}
		
	}
}
