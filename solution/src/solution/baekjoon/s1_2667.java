package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class s1_2667 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char arr[][] = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			char[] cur = s.toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = cur[j];
			}
		}
		int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='1') {
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] {i,j});
					arr[i][j] = '0';
					int cnt = 1;
					while(!q.isEmpty()) {
						int qi = q.peek()[0];
						int qj = q.peek()[1];
						
						q.poll();
						
						for(int d=0; d<4; d++) {
							int ni = qi+dir[d][0];
							int nj = qj+dir[d][1];
							
							if(ni<0 || nj<0 || ni>=N || nj>=N || arr[ni][nj]=='0') continue;
							
							q.add(new int[] {ni,nj});
							arr[ni][nj] = '0';
							cnt++;
						}
					}
					ans.add(cnt);
				}
			}
		}
		
		int size = ans.size();
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(size).append("\n");
		for(int i=0; i<size; i++) {
			sb.append(ans.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
