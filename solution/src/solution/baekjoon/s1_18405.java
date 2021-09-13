package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_18405 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] virus = new int[N][N];
		int[][] check = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
				if(virus[i][j]!=0) {
					check[i][j] = 1;
				}
			}
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int index  = 2;
		int [][] dir = {{-1,0},{1,0},{0,1},{0,-1}}; //╩С, го, аб, ©Л
		while(S!=0) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(check[i][j]==0) {
						int min = Integer.MAX_VALUE;
						for(int d=0; d<4; d++) {
							int nx = i-dir[d][0];
							int ny = j-dir[d][1];
							if(nx>=0 && ny>=0 && nx<N && ny <N) {
								if(check[nx][ny]==0) continue;
								else if(check[nx][ny]==index) continue;
								else {
									min=Math.min(min, virus[nx][ny]);
									check[i][j] = index;
									virus[i][j] = min;
								}
							}
						}
						
					}
				}
			}
			S--;
			index++;
		}
		System.out.println(virus[X-1][Y-1]);
	}
	
	
}
