package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3289 {
	private static int parent[];
	//부모원소 관리
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			make();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine()," ");
				if(Integer.parseInt(st.nextToken())==0) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else {
					if(find(Integer.parseInt(st.nextToken()))==find(Integer.parseInt(st.nextToken()))) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void make() {
		//모든 원소를 자신을 대표자로 만듦
		parent = new int[N+1];
		for (int i = 1; i <=N ; i++) {
			parent[i] = i;
		}
			
	}
	
	private static int find(int a) {
		if(a==parent[a]) return a;//자신이 대표자
		return parent[a] = find(parent[a]); //자신이 속한 집합의 대표자를 부모로 : path compression
	}
	
	//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		
		if(roota != rootb) parent[roota] = rootb;

	}
}
