package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node22 implements Comparable<Node22>{
	int i;
	int j;
	int dis;
	int key;
	public Node22(int i, int j, int dis, int key) {
		super();
		this.i = i;
		this.j = j;
		this.dis = dis;
		this.key = key;
	}
	@Override
	public int compareTo(Node22 o) {
		// TODO Auto-generated method stub
		return this.dis-o.dis;
	}
}
public class g1_1194 {
	private static char arr[][];
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		//'A');//65
		//'a');//97
		//'0');//48
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		int mi=0;
		int mj =0;
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j]  = s.charAt(j);
				if(arr[i][j]=='0') {
					mi=i;
					mj=j;
					arr[i][j] = '.';
				}
			}
		}
	
		int answer = BFS(mi,mj);
		System.out.println(answer);
	}
	private static int BFS(int mi, int mj) {
		PriorityQueue<Node22> q = new PriorityQueue();
		boolean visited[][][] = new boolean[1<<6][N][M];
		q.add(new Node22(mi,mj,0,0));
		visited[0][mi][mj] = true;
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()) {
			int x = q.peek().i;
			int y = q.peek().j;
			int dis = q.peek().dis;
			int key = q.peek().key;
			q.poll();
			if(arr[x][y]=='1') {
				return dis;
				}
			
			for(int d=0; d<4; d++) {
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];

				if(nx>=0 && ny >= 0 && nx <N && ny <M && !visited[key][nx][ny]) {
					System.out.println(nx + " " + ny + " " + arr[nx][ny] + (dis+1));
					int next = arr[nx][ny];
					if(next>=65 && next<=70) {
						int temp = key & 1<<next;
						if((temp & (1<<next))==0 ){
							continue;
						}
						else {
							arr[nx][ny] = '.';
							q.add(new Node22(nx,ny,dis+1,key));
							visited[key][nx][ny] = true;
						}
					}else if(next>=97 && next<=102){
						arr[nx][ny] = '.';
						q.add(new Node22(nx,ny,dis+1,key|1<<(next-97)));
						visited[key][nx][ny] = true;
					}else if(arr[nx][ny] == '#') continue;
					else {
						q.add(new Node22(nx,ny,dis+1,key));
						visited[key][nx][ny] = true;
					}
					
				}
			}
			
			
		}
		
		return -1;
	}
 
}
