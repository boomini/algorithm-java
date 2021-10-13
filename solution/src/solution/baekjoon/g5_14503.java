package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_14503 {
	private static int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};//북,서,남,동
	private static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		//0북, 1동, 2남, 3서
		if(d==1) d=3;
		else if(d==3) d=1;
		//북서남동
		int arr[][] = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		outer : while(true) {
			if(arr[r][c]==0) ans++;
			arr[r][c] = 2;
			//현재 위치 청소
			

			//a.왼쪽 방향 청소할 공간있는지 확인하고 , 있으면 회전한 후 한칸 전진
			//b.없으면 회전하고 다시 반복.
			for(int i=1; i<5; i++) {
				d=(d+1)%4;
				int nx = r+dir[d][0];
				int ny = c+dir[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny <M && arr[nx][ny]==0) {
					r=nx;
					c=ny;
					continue outer;
				}
			}
			
			int nx = r-dir[d][0];
			int ny = c-dir[d][1];
			//c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는 바라보는 방향을 유지한 채로 한칸 후진을 하고 2번으로 돌아간다.
			if(nx>=0 && ny>=0 && nx<N && ny <M && arr[nx][ny]==2) {
				r=nx;
				c=ny;
				continue outer;
			}
			
			break;
			
		}
		System.out.println(ans);
	}
}
