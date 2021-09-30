package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node11 implements Comparable<Node11>{
	int i;
	int j;
	int dis;
	public Node11(int i, int j, int dis) {
		super();
		this.i = i;
		this.j = j;
		this.dis = dis;
	}
	@Override
	public int compareTo(Node11 o) {
		return this.dis-o.dis;
	}
	
}
public class d4_1249 {
	private static int N;
	private static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			arr= new int[N][N];
			for(int i=0; i<N; i++) {
				String s= in.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = s.charAt(j)-48;
				}
			}
			
			int answer = BFS();
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static int BFS() {
		PriorityQueue<Node11> q = new PriorityQueue<Node11>();
		boolean visited[][] = new boolean[N][N];
		q.add(new Node11(0,0,0));
		visited[0][0] = true;
		
		int dir[][] ={{-1,0},{1,0},{0,1},{0,-1}};
		while(!q.isEmpty()) {
			int i = q.peek().i;
			int j = q.peek().j;
			int dis = q.peek().dis;
			q.poll();
			if(i==N-1 && j==N-1) {
				return dis;
			}
			for(int d=0; d<4; d++) {
				int nx = i+ dir[d][0];
				int ny = j+ dir[d][1];
				if(nx<0 || ny< 0 || nx >=N || ny >=N || visited[nx][ny]) continue;
				q.add(new Node11(nx,ny,dis+arr[nx][ny]));
				visited[nx][ny] = true;
			}
		}
		
		return -1;
	}
}
