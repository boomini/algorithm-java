package jobssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			Queue<int[]> q = new LinkedList();
			int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
			int cnt = 0;
			char arr[][] = new char[N][N];
			for(int i=0; i<N; i++) {
				String s = in.readLine();
				for(int j=0; j<N; j++) {
					char c = s.charAt(j);
					arr[i][j] = c;
					if(c=='o') {
						q.add(new int[] {i,j});
						cnt++;
					}
				}
			}
			int day = 0;
			ArrayList<int[]> bug = new ArrayList<int[]>();
			//벌레위치의 리스트
			while(cnt<N*N) {
				int size = q.size();
				for(int i=0; i<size; i++) {
					int ci = q.peek()[0];
					int cj = q.peek()[1];
					
					q.poll();
					
					for(int d=0; d<4; d++) {
						int ni = ci+dir[d][0];
						int nj = cj+dir[d][1];
						if(ni<0||nj<0||ni>=N||nj>=N||arr[ni][nj]=='o') continue;
						if(arr[ni][nj]=='x') {
							//벌레가있을때
							arr[ni][nj] = '0';
							bug.add(new int[] {ni,nj});
						}else if(arr[ni][nj]=='.') {
							//빈 위치는 따뜻하게
							arr[ni][nj] ='o';
							cnt++;
							q.add(new int[] {ni,nj});
						}
					}
					
					
				}
				for(int i=bug.size()-1; i>=0; i--) {
					int bi = bug.get(i)[0];
					int bj = bug.get(i)[1];
					
					if(arr[bi][bj]==':') {
						//마지막날인경우 방문표시
						arr[bi][bj] = 'o';
						cnt++;
						bug.remove(i);
						q.add(new int[] {bi,bj});
					}else {
						arr[bi][bj]++;
						//벌레있는곳에 날짜변경
					}							
				}
				
				day++;
				System.out.println(day);
				for(int i=0; i<N; i++) {	
					for(int j=0; j<N; j++) {
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println(day);
			sb.append(day).append("\n");
		}
		System.out.println(sb.toString());
	}
		
}

