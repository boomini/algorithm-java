package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int arr[][][] = new int[H][N][M];
		boolean visited[][][] = new boolean[H][N][M];
		int dir[][] = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};
		Queue<int[]> q = new LinkedList<int[]>();
		int tomatos = 0;
		int answer = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int k=0; k<M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k]==0) tomatos++;
					else if(arr[i][j][k]==1) {
						q.add(new int[] {i,j,k,0});
						visited[i][j][k] = true;
					}
				}
			}
		}
		if(tomatos!=0) {
			int day = 0;
			while(!q.isEmpty()) {
				int i = q.peek()[0];
				int j = q.peek()[1];
				int h = q.peek()[2];
				int cnt = q.peek()[3];
				q.poll();
				day=cnt;
				
				for(int d=0; d<6; d++) {
					int ni= i+dir[d][0];
					int nj= j+dir[d][1];
					int nh= h+dir[d][2];
					
					if(ni<0||nj<0||nh<0||ni>=H||nj>=N||nh>=M||visited[ni][nj][nh]||arr[ni][nj][nh]==-1) continue;
					
					visited[ni][nj][nh] = true;
					q.add(new int[] {ni,nj,nh, cnt+1});
					tomatos--;
				}
			}
			if(tomatos==0) answer = day;
			else answer = -1;
		}
		System.out.println(answer);
		
		
	}
}
