package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_1260 {
	private static int N;
	private static int V;
	private static boolean arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선
		V = Integer.parseInt(st.nextToken()); //START
		arr = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken()); 
			arr[from][to] = arr[to][from] = true;
		}
		
		boolean visited[] = new boolean[N+1];
		dfs(V,visited);
		System.out.println();
		bfs();
		
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print(current + " ");
		for(int i=1; i<=N; i++) {
			if(!visited[i]&&arr[current][i]) {
				
				dfs(i, visited);
			}
		}
		
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isSelected = new boolean[N+1];
		queue.add(V);
		isSelected[V] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for(int i=1; i<=N; i++) {
				if(!isSelected[i]&&arr[current][i]) {
					queue.add(i);
					isSelected[i] = true;
				}
			}
		}
		
		
	}
}
