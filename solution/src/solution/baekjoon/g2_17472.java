package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g2_17472 {
	private static int N;
	private static int M;
	private static int arr[][];
	private static ArrayList<ArrayList> island;
	private static int dir[][] = {{-1,0,},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		island = new ArrayList<ArrayList>();
	    arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
	    	for (int j=0; j<M; j++) {
	    		int num = Integer.parseInt(st.nextToken());
	    		if(num==1) {
	    			arr[i][j]= -1;
	    		}else arr[i][j] = num;
	    	}
	    }
		int k = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==-1) {
					island.add(new ArrayList<int[]>());
					BFS(i,j,k);
					k++;
				}
			}
		}
		
		for(int i=0; i<island.size(); i++) {
			ArrayList<int[]> check = island.get(i) ;
			for(int j=0; j<island.get(i).size(); j++) {
				int num = check.get(j)[0];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		int dp[][] = new int[N][M];
		
		
		
	}

	private static void BFS(int i, int j, int k) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			
			q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M||arr[nx][ny]!=-1) continue;
				else {
					q.add(new int[] {nx,ny});
					arr[nx][ny] = k; 
					island.get(k-1).add(new int[] {nx,ny});
					
				}
			}
		}
		
		
		
	}
}
