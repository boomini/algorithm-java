package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_14502 {
	private static int CN;
	private static int R=3;
	private static int com[];
	private static ArrayList<int[]> virus;
	private static int N;
	private static int M;
	private static int arr[][];
	private static int max;
	private static ArrayList<int[]> air;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		air = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					air.add(new int[] {i,j});
				}else if(arr[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		com=new int[R];
		CN=air.size();
		combination(0,0);	
		System.out.println(max);
	}
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			//System.out.println(Arrays.toString(com));
			BFS(com[0],com[1],com[2]);
			return;
		}
		
		for(int i=start; i<CN; i++) {
			com[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}
	private static void BFS(int n1, int n2, int n3) {
		Queue<int[]> q = new LinkedList<>();
		boolean isVisited[][] = new boolean[N][M];
		int cp[][]  = new int[N][M];
		for(int i=0; i<N; i++) {
			System.arraycopy(arr[i], 0, cp[i], 0, arr[0].length);
		}
		
		for(int i=0; i<virus.size(); i++) {
			q.add(new int[] {virus.get(i)[0],virus.get(i)[1]});	
		}
		cp[air.get(n1)[0]][air.get(n1)[1]]=1;
		cp[air.get(n2)[0]][air.get(n2)[1]]=1;
		cp[air.get(n3)[0]][air.get(n3)[1]]=1;
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				
				if(nx<0 || nx >=N || ny<0 || ny>=M || isVisited[nx][ny]||cp[nx][ny]!=0) continue;
				else {
					isVisited[nx][ny] = true;
					cp[nx][ny] = 2;
					q.add(new int[] {nx,ny});				
				}
			}
			
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cp[i][j]==0) cnt++;
			}
		}
		//System.out.println(cnt);
		max = Math.max(max, cnt);
	}
}
