package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.util.StringTokenizer;

public class g5_15683 {
	private static int N;
	private static int M;
	private static int [][]board;
	private static boolean[][] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N][M];
		board = new int[N][M];
		for(int i=0; i<N; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0,0);
	}

	private static void check(int starti, int startj) {
		for(int i=starti; i<N; i++) {
			for(int j=startj; j<M; j++) {
				if(board[i][j]==1) {
//					dfs()
				}else if(board[i][j]==2) {
					
				}else if(board[i][j] == 3) {
					
				}else if(board[i][j] == 4) {
					
				}else if(board[i][j] == 5) {
					
				}
			}
			startj = 0;
		}
		
	}
}
