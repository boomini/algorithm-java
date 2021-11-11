package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_4963 {
	private static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
	private static int arr[][];
	private static int w;
	private static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			arr = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(arr[i][j]==1) {				
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}	
		System.out.println(sb.toString());		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q= new LinkedList<int[]>();
		q.add(new int[]{i,j});
		arr[i][j]=0;
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int d=0; d<8; d++) {
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];
				if(nx<0 || ny<0 || nx>=h || ny>=w || arr[nx][ny]==0) continue;
				q.add(new int[] {nx,ny});
				arr[nx][ny]=0;
			}
		}
		
	}
}
