package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_7465 {
	private static int N;
	private static int parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		//union¹®Á¦
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			make();
			for(int i=0; i<M; i++) {
				String s = in.readLine();
				if(s.length()==1) continue;
				st = new StringTokenizer(s, " ");
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				union(num1, num2);
			}
			
			
			boolean [] check = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				int num = find(i);
				if(!check[num])check[num] = true;
			}
			int cnt=0;
			for(int i=1; i<=N; i++) {
				if(check[i])cnt++;
			}
			
			
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	private static void make() {
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}		
	}
	
	private static int find(int i) {
		if(parent[i]==i) return i;
		else return parent[i] = find(parent[i]);
	}
	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if(aroot!=broot) parent[aroot] = broot;
	}
	
	
}
