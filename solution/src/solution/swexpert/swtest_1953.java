package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2>{
	int i;
	int j;
	int dis;
	public Node2(int i, int j, int dis) {
		super();
		this.i = i;
		this.j = j;
		this.dis = dis;
	}
	@Override
	public int compareTo(Node2 o) {
		// TODO Auto-generated method stub
		return this.dis - o.dis;
	}
	
}
public class swtest_1953 {
	private static int N;
	private static int M;
	private static PriorityQueue<Node2> pq;
	private static int arr[][];
	private static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc =1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(BFS(R,C,L)).append("\n");	
		}
		System.out.println(sb.toString());
	}

	private static int BFS(int R, int C, int L) {
		pq = new PriorityQueue<Node2>();
		pq.add(new Node2(R,C,1));
		int cnt = 0;
		visited = new boolean[N][M];
		visited[R][C] = true;
		//1 => »óÇÏÁÂ¿ì
		//2 => »óÇÏ
		//3 => ÁÂ¿ì
		//4 => »ó¿ì
		//5 => ÇÏ¿ì
		//6 => ÇÏÁÂ
		//7 ==> »óÁÂ
		while(!pq.isEmpty()&&pq.peek().dis<=L) {
			int x = pq.peek().i;
			int y = pq.peek().j;
			int dis = pq.peek().dis;
			pq.poll();
			cnt++;
			if(dis==L) continue;
			int type = arr[x][y];
			switch(type) {
			case 1:
				move(0,4,1,x,y,dis,1);
				break;
			case 2:
				move(0,2,1,x,y,dis,2);
				break;
			case 3:
				move(2,4,1,x,y,dis,3);
				break;
			case 4://»ó,¿ì
				move(0,4,3,x,y,dis,4);
				break;
			case 5://ÇÏ¿ì
				move(1,4,2,x,y,dis,5);
				break;
			case 6://ÇÏÁÂ
				move(1,3,1,x,y,dis,6);
				break;
			case 7://»óÁÂ
				move(0,3,2,x,y,dis,7);
				break;
			default:
				break;
				
			}
		}		
		return cnt;
		
	}
	private static void move(int start, int end, int plus, int x, int y, int dis, int type) {
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //»ó,ÇÏ,ÁÂ.¿ì
		for(int d=start; d<end; ) {					
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(check(nx,ny,d)) {
				pq.add(new Node2(nx,ny,dis+1));
				visited[nx][ny] = true;
			}
			d+=plus;
		}
	}
	private static boolean check(int nx, int ny, int d) {
		if(nx>=0 && ny>=0 && nx<N && ny <M && !visited[nx][ny] && arr[nx][ny]!=0) {
			switch(d) {
			case 0://»ó
				if(arr[nx][ny]==2||arr[nx][ny]==5||arr[nx][ny]==6||arr[nx][ny]==1) return true;
				break;
			case 1: //ÇÏ
				if(arr[nx][ny]==2||arr[nx][ny]==4||arr[nx][ny]==7||arr[nx][ny]==1) return true;
				break;
			case 2: //ÁÂ
				if(arr[nx][ny]==3||arr[nx][ny]==4||arr[nx][ny]==5||arr[nx][ny]==1) return true;
				break;
			case 3: //¿ì
				if(arr[nx][ny]==3||arr[nx][ny]==6||arr[nx][ny]==7||arr[nx][ny]==1) return true;
				break;				
			}
		}
		return false;
	}
	
}
