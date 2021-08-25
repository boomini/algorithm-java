package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d4_1251_02 {
	static class Node implements Comparable<Node>{
		int to;
		long cost;
		Node(int to, long cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] X = new long[N];
			long[] Y = new long[N];
			boolean[] visit = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				X[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				Y[i] = Long.parseLong(st.nextToken());
			double E = Double.parseDouble(br.readLine());

			LinkedList<Node>[] list = new LinkedList[N];    // 가능한 모든 간선의 비용을 저장

			for (int i = 0; i < N; i++) {
				list[i] = new LinkedList<>();
				for (int j = 0; j < N; j++) {
					if(i == j)	continue;
					long L = (X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]);
					if(i==0&&j==1) {
						System.out.println(L);
					}
					list[i].add(new Node(j, L));
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			long ans = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				if(visit[n.to])	continue;
				visit[n.to] = true;
				System.out.println(n.to + " " + n.cost);
				ans += n.cost;
				if(++cnt == N)	break;
				
				for (Node node : list[n.to]) {
					if(!visit[node.to])	pq.add(node);
				}
			}
			System.out.println("#"+tc+" "+Math.round(ans*E));
		}
	}
}
