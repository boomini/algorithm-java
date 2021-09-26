package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node7 implements Comparable<Node7>{
	int i;
	int wei;
	public Node7(int i, int wei) {
		super();
		this.i = i;
		this.wei = wei;
	}
	@Override
	public int compareTo(Node7 o) {
		// TODO Auto-generated method stub
		return this.wei - o.wei;
	}
}

class Node8 implements Comparable<Node8>{
	int i;
	int wei;
	public Node8(int i, int wei) {
		super();
		this.i = i;
		this.wei = wei;
	}
	@Override
	public int compareTo(Node8 o) {
		// TODO Auto-generated method stub
		return o.wei-this.wei;
	}
}
public class g3_13418 {
	private static boolean visited[];
	private static ArrayList<Node7>[] nodes;
	private static ArrayList<Node8>[] nodes2;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[N+1];
		nodes2 = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			nodes[i] = new ArrayList<Node7>();
			nodes2[i] = new ArrayList<Node8>();
		}
		for(int i=0; i<M+1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from=Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			if(wei==1)wei=0;
			else wei=1;
			nodes[from].add(new Node7(to,wei));
			nodes[to].add(new Node7(from,wei));
			nodes2[from].add(new Node8(to,wei));
			nodes2[to].add(new Node8(from,wei));
		}
		
		int answer = prim();
		int answer2 = prim2();
		System.out.println(answer2*answer2-answer*answer);
		
	}

	private static int prim() {
		visited = new boolean[N+1];
		PriorityQueue<Node7> pq = new PriorityQueue<Node7>();
		pq.add(new Node7(0,0));
		int check = 0;
		while(!pq.isEmpty()) {
			int num = pq.peek().i;
			int wei = pq.peek().wei;
			pq.poll();
			if(visited[num]) continue;
			visited[num] = true;
			if(wei==1) check ++;
			
			for(int i=0; i<nodes[num].size();i++) {
				if(visited[nodes[num].get(i).i])continue;
				pq.add(nodes[num].get(i));
				
			}
		}
		return check;
		
	}
	
	private static int prim2() {
		visited = new boolean[N+1];
		PriorityQueue<Node8> pq = new PriorityQueue<Node8>();
		pq.add(new Node8(0,0));
		int check = 0;
		while(!pq.isEmpty()) {
			int num = pq.peek().i;
			int wei = pq.peek().wei;
			pq.poll();
			if(visited[num]) continue;
			visited[num] = true;
			if(wei==1) check ++;
			
			for(int i=0; i<nodes2[num].size();i++) {
				if(visited[nodes2[num].get(i).i])continue;
				pq.add(nodes2[num].get(i));
				
			}
		}
		return check;
		
	}
}
