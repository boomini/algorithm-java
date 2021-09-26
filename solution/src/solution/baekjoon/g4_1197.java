package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>  {
	int from;
	int to;
	int wei;
	
	public Edge(int from, int to, int wei) {
		super();
		this.from = from;
		this.to = to;
		this.wei = wei;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.wei-o.wei;
	}

}
public class g4_1197 {
	//ũ�罺Į
	private static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] arr = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			arr[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		make(V);
		int answer = 0;
		int cnt = 0;
		for(int i=0; i<E; i++) {
			if(union(arr[i].from,arr[i].to)) {
				answer+=arr[i].wei;
				if(cnt==V-1) break;;
			};
		}
		System.out.println(answer);
		
	}
	private static boolean union(int from, int to) {
		int n1 = find(from);
		int n2 = find(to);
		
		if(n1==n2) return false;
		
		parent[n1] = n2;
		return true;
	}
	private static int find(int num) {
		if(parent[num]==num) return num;
		else return parent[num] = find(parent[num]);
	}
	private static void make(int N) {
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
}
