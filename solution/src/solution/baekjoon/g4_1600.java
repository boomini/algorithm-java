package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class g4_1600 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		boolean visited[][][] = new boolean[H][W][K+1];
		int arr[][] = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		PriorityQueue<Nodes> pq = new PriorityQueue<>();
		pq.add(new Nodes(0,0,0,0)); //0번째: x값,  1번째:y값, 2번째:말처럼 뛴 개수, 3번째 : cnt
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};
		while(!pq.isEmpty()) {
			Nodes cur = pq.poll();
			
			if(cur.x==H-1&&cur.y==W-1) {
				System.out.println(cur.cnt);
				System.exit(0);
				break;
			}
			int max = 0;
			if(cur.kcnt>=K) {
				max = 4;
			}else {
				max = 12;
			}
			for(int i=0; i<max; i++) {
				int nx = cur.x+dir[i][0];
				int ny = cur.y+dir[i][1];
				int cnt = cur.kcnt;
				if(i>=4) {cnt = cur.kcnt+1;}
				//System.out.println(cnt);
				if(nx>=0 && nx < H && ny >=0 && ny <W && arr[nx][ny]!=1&&!visited[nx][ny][cnt]) {
					if(i>=4) {						
						pq.add(new Nodes(nx,ny,cur.kcnt+1,cur.cnt+1));
					}else {
						pq.add(new Nodes(nx,ny,cur.kcnt,cur.cnt+1));
					}
					visited[nx][ny][cnt] = true;				
				}
			}
			
			
		}
		System.out.println(-1);
	}

	
}
class Nodes implements Comparable<Nodes>{
	int x;
	int y ;
	int kcnt;
	int cnt;
	
	public Nodes(int x, int y, int kcnt, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.kcnt = kcnt;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Nodes o) {
		return this.cnt-o.cnt;
	}
}
