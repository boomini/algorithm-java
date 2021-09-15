package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int val;
	public Edge(int start, int end, int val) {
		super();
		this.start = start;
		this.end = end;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val-o.val;
	}
	
}
public class d4_3124_Kruskal {
	
	private static int parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T; tc++ ) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			make_set(N);
			Edge[] edges =new Edge[M];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				edges[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(edges);
			long answer = 0;
			int cnt = 0;
			for(int i=0; i<M; i++) {
				if(union_set(edges[i].start, edges[i].end)) {
					answer+= edges[i].val;
					if(cnt++==N-1) break; //신장트리 완성
				};
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean union_set(int start, int end) {
		int num1 = find_set(start);
		int num2 = find_set(end);
		
		if(num1==num2) return false;
		else parent[num1] = num2;
		return true;
	}
	private static int find_set(int n) {
		if(parent[n]==n) return n;
		return parent[n]=find_set(parent[n]);
	}
	private static void make_set(int N) {
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i]=i;
		}
		
	}
}
