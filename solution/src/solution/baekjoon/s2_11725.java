package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s2_11725 {
	private static int parent[];
	private static ArrayList<Integer> arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		parent = new int[N+1];
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1].add(n2);
			arr[n2].add(n1);
			
		}
		
		DFS(1);
		
		for(int i=2;i<=N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void DFS(int i) {
		if(arr[i].size()==0) {
			return;
		}
		for(int j=0; j<arr[i].size(); j++) {
			if(parent[arr[i].get(j)]==0) {
				parent[arr[i].get(j)]=i;
				DFS(arr[i].get(j));
			}
			
		}
		
	}
}
