package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge2 implements Comparable<Edge2>{
	int from;
	int to;
	int wei;
	public Edge2(int from, int to, int wei) {
		super();
		this.from = from;
		this.to = to;
		this.wei = wei;
	}
	@Override
	public int compareTo(Edge2 o) {
		return this.wei-o.wei;
	}	
}

public class g4_1647 {
	private static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		make(N);
		ArrayList<Edge2> arr = new ArrayList<Edge2>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			arr.add(new Edge2(from,to,wei));
		}
		
		Collections.sort(arr);
		int cnt = 0;
		int answer = 0;
		for(int i=0; i<M; i++) {
			if(union(arr.get(i).from,arr.get(i).to)) {
				cnt++;
				answer += arr.get(i).wei;
				
			};
			if(cnt==N-2) break;
		}
		System.out.println(answer);
	}
	private static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1==p2) return false;
		parent[p1] = p2;
		return true;
	}
	private static int find(int n1) {
		if(n1==parent[n1]) return n1;
		return parent[n1] = find(parent[n1]);
	}
	private static void make(int n) {
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
	}
}
