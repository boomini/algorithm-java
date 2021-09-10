package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_1922 {
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	private static int parent[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//크루스칼
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		make_set(N);
		Edge edgelist[] = new Edge[M];
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgelist[i] = new Edge(from,to,weight);

		}
		
		Arrays.sort(edgelist);
		
		int cnt=0;
		int sum = 0;
		for(int i=0; i<M; i++) {
			if(union_set(edgelist[i].start,edgelist[i].end)) {
				cnt++;
				sum+=edgelist[i].weight;
				if(cnt==N-1) break;
			}
		}
		System.out.println(sum);
	}

	private static boolean union_set(int start, int end) {
		int num1=find_set(start);
		int num2=find_set(end);
		
		if(num1==num2) return false;
		else {
			parent[num1]=num2;
			return true;
		}
		
	}

	private static int find_set(int i) {
		if(parent[i]==i) return i; //자신이 대표자
		return parent[i] = find_set(parent[i]);
	}

	private static void make_set(int n) {
		parent= new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
	}
}
