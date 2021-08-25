package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_10026 {
	private static int N;
	private static int parent[];
	private static int parent2[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		parent = new int[N];
		parent2 = new int[N];
		char arr[][] = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j); 
			}
		}
		
		make();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				char check = arr[i][j];
				if(j+1<N) {
					char compare1 = arr[i][j+1];
					if(check==compare1) union(N*i+j, N*i+j+1);
					if((check!='B'&&compare1!='B')||(check=='B'&&compare1=='B'))
						union2(N*i+j, N*i+j+1);
				}
				if(i+1<N) {
					char compare2 = arr[i+1][j];
					if(check==compare2) union(N*i+j, N*(i+1)+j);
					if((check!='B'&&compare2!='B')||(check=='B'&&compare2=='B'))
						union2(N*i+j, N*(i+1)+j);	
				}			
			}
		}
		boolean check[] = new boolean[N*N];
		boolean check2[] = new boolean[N*N];
		for(int i=0; i<parent.length; i++) {	
			if(!check[find(i)]) check[find(i)]= true;
			if(!check2[find2(i)]) check2[find2(i)]= true;
			
		}
		int cnt = 0;
		int cnt2 = 0;
		for(int i=0; i<check.length; i++) {
			if(check[i]) cnt++;
			if(check2[i]) cnt2++;
		}

		System.out.println(cnt + " " + cnt2);
		
		
	}

	

	private static void make() {
		parent = new int[N*N];
		parent2 = new int[N*N];
		for(int i=0; i<N*N; i++) {
			parent[i] = i;
			parent2[i] = i;
		}
		
	}
	
	private static int find(int i) {
		if(parent[i]==i) return i;
		else return parent[i] = find(parent[i]);
	}
	
	private static int find2(int i) {
		if(parent2[i]==i) return i;
		else return parent2[i] = find2(parent2[i]);
	}
	
	private static void union(int i, int j) {
		int aroot = find(i);
		int broot = find(j);
		
		if(aroot!=broot) parent[broot] = aroot;
		
	}
	private static void union2(int i, int j) {
		int aroot = find2(i);
		int broot = find2(j);
		
		if(aroot!=broot) parent2[broot] = aroot;
		
	}
	
}
