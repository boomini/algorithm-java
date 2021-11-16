package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

class Node{
	int i;
	int wei;
	public Node(int i, int wei) {
		super();
		this.i = i;
		this.wei = wei;
	}
}
public class g4_1967 {
	private static int N;
	private static Vector<Node> [] arr ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new Vector[N+1];
		int max = 0;
		for(int i=1; i<=N; i++) {
			arr[i] = new Vector<Node>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			arr[n1].add(new Node(n2,wei));
			arr[n2].add(new Node(n1,wei));
		}
		
		for(int i=1; i<=N; i++) {
			max = Math.max(BFS(i), max);
		}
		System.out.println(max);
	}

	private static int BFS(int i) {
		boolean visited[] = new boolean[N+1];
		Queue<Node> q = new LinkedList<Node>();
		visited[i] = true;
		q.add(new Node(i,0));
		int answer = 0;
		while(!q.isEmpty()) {
			int ni = q.peek().i;
			int wei = q.peek().wei;
			q.poll();
			answer = Math.max(answer, wei);
			
			for(int k=0; k<arr[ni].size(); k++) {
				if(!visited[arr[ni].get(k).i]) {
					q.add(new Node(arr[ni].get(k).i,arr[ni].get(k).wei+wei));
					visited[arr[ni].get(k).i]=true;
				}
			}
		}
		return answer;		
	}
}
