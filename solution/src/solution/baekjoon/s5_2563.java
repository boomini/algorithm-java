package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int [][] paper = new int[101][101];
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			for(int l=L; l<L+10; l++) {
				for(int m=M; m<M+10; m++) {
					paper[m][l]=1;
				}
				
			}
			
		}
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]==1)count++;
			}
		}
		System.out.println(count);
	}
}
