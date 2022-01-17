package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_2573 {
	private static int arr[][];
	private static int N;
	private static int M;
	private static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	private static int chk;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		chk = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine()); 
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) chk++;
			}
		}
		int year = 0;
		while(true) {
			year++;
			//녹이고
			arr=melt();
			if(chk==0) {
				year = 0;
				break;
			}
			//덩어리가 되어있는지 확인
			int copyarray[][] = new int[N][M];
			for(int i=0; i<N; i++) {
				copyarray[i] = arr[i].clone();
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copyarray[i][j]!=0) {
						bfs(i,j,copyarray);
						cnt++;
					}
				}
			}
			if(cnt>=2) break;
		}
		System.out.println(year);
	}

	private static void bfs(int i, int j,int cparr[][]) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		cparr[i][j] = 0;
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int d=0; d<4; d++) {
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || cparr[nx][ny]==0) continue;
				q.add(new int[] {nx,ny});
				cparr[nx][ny] = 0;
			}
		}
		
	}

	private static int[][] melt() {
		int meltarr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int cnt = 0;
				if(arr[i][j]==0)continue;
				for(int d=0; d<4; d++) {
					int nx = i+dir[d][0];
					int ny = j+dir[d][1];
					
					if(nx<0 || ny<0 || nx>=N|| ny>=M || arr[nx][ny]!=0) continue;
					cnt++;
				}
				
				meltarr[i][j]=arr[i][j]-cnt;
				if(meltarr[i][j]<0) meltarr[i][j] = 0;
				if(meltarr[i][j]==0)chk--;
			}
		}
		return meltarr;
	}
}
