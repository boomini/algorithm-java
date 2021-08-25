package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_1753 {
	static class Node{
		int vertex;
		Node node;
		int weight;
		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
		public Node(int vertex, Node node, int weight) {
			super();
			this.vertex = vertex;
			this.node = node;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", node=" + node + ", weight=" + weight + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(in.readLine());
		Node[] nodes = new Node[V+1];
		int[] distance = new int[V+1];
		boolean visited[] = new boolean[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[from] = new Node( to,nodes[from],weight);
		}
		System.out.println(Arrays.toString(nodes));
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		int current = 0;
		int index = 1;
		while(true) {
			int min = Integer.MAX_VALUE;
			//거리 최소값 구하기
			for(int i=1; i<=V; i++) {
				if(!visited[i] && min>distance[i]) {
					min=distance[i];
					current = i;
				}
			}
			visited[current] = true;
			if(current == index) {
				System.out.println(current + " " + min);
				if(min==Integer.MAX_VALUE) System.out.println("INF");
				System.out.println(min);
			}
			if(index==V+1) break;
			index++;
			//최소값 노드의 최소값거리 살피기
			for(Node temp = nodes[current]; temp!=null; temp = temp.node ) {
				if(!visited[temp.vertex] && min+temp.weight<distance[temp.vertex])
					distance[temp.vertex] = min + temp.weight;
			}
			
			
		}
		
		
		
	}
}
