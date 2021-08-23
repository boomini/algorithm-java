import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	static int N; //정점 개수
	static boolean[][] adjMatrix; //인접행렬(가중치 없음)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(in.readLine()); //간선개수
		for(int i=0; i<C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from]=adjMatrix[from][to] = true; //무향그래프이기 때문에
			
		}
		System.out.println("===============bfs============================");
		bfs();
		System.out.println();
		System.out.println("===============dfs============================");
		boolean[] visited = new boolean[N];
		dfs(0, visited );
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char)(current+65) + " ");
			for(int i=0; i<N; i++) {
				if(!visited[i] //미방문
						&& adjMatrix[current][i]) {//인접정점
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print((char)(current+65) + " ");
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
			}
		}
	}
}
