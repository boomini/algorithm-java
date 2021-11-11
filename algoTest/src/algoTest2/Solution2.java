package algoTest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sizeOfMatrix = Integer.parseInt(in.readLine());
		int [][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
		N=sizeOfMatrix;
		for(int i=0; i<sizeOfMatrix; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<sizeOfMatrix; j++) {
				int n = Integer.parseInt(st.nextToken());
				matrix[i][j] = n;
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<sizeOfMatrix; i++) {
			for(int j=0; j<sizeOfMatrix; j++) {
				if(matrix[i][j]==1) {
					arr.add(BFS(i,j,matrix));
				}
				
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(int i=0; i<arr.size(); i++) {
			if(i==arr.size()-1) {
				System.out.println(arr.get(i));
			}else {
				System.out.print(arr.get(i)+" ");
			}
			
		}

	}

	private static int BFS(int i, int j, int[][] matrix) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		int cnt = 1;
		matrix[i][j] = 0;
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for(int d=0; d<4; d++) {
				int nx = x+dir[d][0];
				int ny = y+dir[d][1];
				if(nx>=0 && ny>=0 && nx<N && ny<N && matrix[nx][ny]==1) {
					q.add(new int[] {nx,ny});
					matrix[nx][ny]=0;
					cnt++;
				}
			}
			
		}
		return cnt;
	}
}
