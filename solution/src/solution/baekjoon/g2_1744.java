package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node10{
	int i;
	int j;
	int cnt;
	public Node10(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		this.cnt = 0;
	}
	
	public Node10(int i, int j, int cnt) {
		super();
		this.i = i;
		this.j = j;
		this.cnt = cnt;
	}
	
	
}
public class g2_1744 {
	private static int N;
	private static int M;
	private static boolean visited[];
	private static int num[];
	private static Node10 start=null;//출발지
	private static Node10 end = null;//도착지
	private static ArrayList<Node10> arr;//챙겨야 하는 물건
	private static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	private static char map[][];
	private static int R;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		
		arr = new ArrayList<Node10>();
		for(int i=0; i<M; i++) {
			String s = in.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') start=new Node10(i,j);				
				else if(map[i][j]=='X') arr.add(new Node10(i,j));
				else if(map[i][j]=='E') end=new Node10(i,j);
			}
		}
		R=arr.size();
		visited = new boolean[R];
		num = new int[R];
		permutation(0);
		System.out.println(min);
	}

	private static void permutation(int cnt) {
		if(cnt==R) {
			getdistance(num);
		}
		for(int i=0; i<R; i++) {
			if(visited[i]) continue;
			num[cnt] = i;
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
	}

	private static void getdistance(int[] num) {
		Node10 node = start;
		int sum = 0;
		for(int i=0; i<=num.length; i++) {
			Queue<Node10> q = new LinkedList<Node10>();
			q.add(node);
			Node10 next = null;
			if(i==num.length) {
				next = end;
			}
			else next = arr.get(num[i]);
			boolean visited[][] = new boolean[M][N];
			int cnt = 0;
			while(!q.isEmpty()) {
				Node10 cur = q.poll();
				if(cur.i==next.i && cur.j==next.j) {
					cnt = cur.cnt;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nx = cur.i+dir[d][0];
					int ny = cur.j+dir[d][1];
					if(nx<0 || ny<0 || nx>=M || ny>=N || map[nx][ny]=='#'||visited[nx][ny] ) continue;
					visited[nx][ny] = true;
					q.add(new Node10(nx,ny,cur.cnt+1));
				}
			}
			sum+=cnt;
			if(sum>min) return;
			node = next;
			
		}
		min = Math.min(sum,min);
		
	}
}
