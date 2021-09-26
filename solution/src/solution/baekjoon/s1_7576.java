package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_7576 {
	private static int n;
	private static int N;
	private static int M;
	private static boolean visited[][];
	private static Queue<int[]> tomato;
	private static int arr[][];
	private static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		tomato = new LinkedList<int[]>();
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					tomato.add(new int[] {i,j,0});
					visited[i][j] = true;
				}else if(arr[i][j]==-1) {
					cnt++;
				}
			}
		}
		n = N*M-tomato.size();
		
		int answer = 0;
		if(tomato.size()!=N*M) {
			answer = BFS(tomato, cnt);
		}
		System.out.println(answer);
	}
	private static int BFS(Queue<int[]> q, int cnt) {
		int dir[][]= {{-1,0},{1,0},{0,1},{0,-1}};
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int day = q.peek()[2];
			q.poll();
			cnt++;
			if(cnt==M*N) {
				return day;
			}
			
			for(int i=0; i<dir.length; i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				
				if(nx<0 || ny<0 || nx>=N || ny >=M ||visited[nx][ny]||arr[nx][ny]!=0) continue;
				q.add(new int[] {nx,ny,day+1});
				arr[nx][ny]=1;
				visited[nx][ny] = true;
			}
			
		}
		
		return -1;
	}
}
