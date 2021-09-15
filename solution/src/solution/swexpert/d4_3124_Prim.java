package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d4_3124_Prim {
	private static int parent[];
	private static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T; tc++ ) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Edge1>[] edges = new ArrayList[N+1];
			visited = new boolean[N+1];
			for(int i=0; i<=N; i++) {
				edges[i] = new ArrayList<Edge1>();
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges[v1].add(new Edge1(v2, w));
				edges[v2].add(new Edge1(v1,w));
			}
			long answer = 0;
			int cnt = 0;
			PriorityQueue<Edge1> pq = new PriorityQueue<>();
			pq.add(new Edge1(1,0));
			while(!pq.isEmpty()) {
				Edge1 cur = pq.poll();
				if(visited[cur.v]) continue;
				visited[cur.v] = true;
				answer = answer+cur.weight;	
				
				if(cnt==N) break;
				cnt++;
				for(int i=0; i<edges[cur.v].size(); i++) {
					if(!visited[edges[cur.v].get(i).v]) {
						pq.add(new Edge1(edges[cur.v].get(i).v,edges[cur.v].get(i).weight));
					}
				}
				
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
class Edge1 implements Comparable<Edge1>{
	int v;
	int weight;
	public Edge1(int v,int weight) {
		super();
		this.v = v;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge1 o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
}