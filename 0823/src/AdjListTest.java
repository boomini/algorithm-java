import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static int N; // 정점 개수
	static Node[] adjList; // 인접 리스트(가중치 없음)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjList = new Node[N];
		int C = Integer.parseInt(in.readLine()); // 간선개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);

		}
		System.out.println("===============bfs============================");
		bfs();
		System.out.println();
		System.out.println("===============dfs============================");
		boolean[] visited = new boolean[N];
		dfs(0, visited);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char) (current + 65) + " ");
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {// 미방문
					queue.offer(temp.vertex);
				visited[temp.vertex] = true;
			}
		}
	}

	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print((char) (current + 65) + " ");

		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {// 미방문
				dfs(temp.vertex, visited);
		}
	}
}}
