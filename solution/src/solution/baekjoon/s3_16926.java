package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			s = in.readLine();
			st = new StringTokenizer(s," ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
		
		int check = Math.min(N, M)/2;
		while(R-->0) {
			for(int c=0; c<check; c++) {
				int i = c;
				int j = c;
				int idir = 0;
				int temp = arr[i][j];
				while(idir<4) {
					int ni = i+dir[idir][0];
					int nj = j+dir[idir][1];
					
					//범위확인
					if(ni>=c && nj>=c && ni<N-c && nj<M-c) {
						int temp2 = arr[ni][nj];
						arr[ni][nj] = temp;
						temp = temp2;
						i=ni;
						j=nj;
					}else {
						idir++;
					}	
					
				}
				
			}
		}
		
		for(int l=0; l<N; l++) {

			for(int o=0; o<M; o++) {
				System.out.print(arr[l][o]+" ");
			}
			System.out.println();
		}
	}
}
