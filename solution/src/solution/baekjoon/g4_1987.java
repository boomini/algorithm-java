package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_1987 {
	private static int R;
	private static int C;
	private static char arr[][];
	private static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
								//»óÇÏÁÂ¿ì
	private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			s = in.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		String str=String.valueOf(arr[0][0]);
		dfs(0,0,str);
		System.out.println(max);
	}

	private static void dfs(int i, int j, String s) {
		for(int d=0; d<4; d++) {
			int nx = i+dir[d][0];
			int ny = j+dir[d][1];
			if(nx>=0 && ny>=0 && nx<R && ny<C) {
				if(s.contains(String.valueOf(arr[nx][ny]))) {
					//System.out.println(s);
					max = Math.max(max, s.length());
					continue;
				}
				dfs(nx, ny, s+arr[nx][ny]);
			}
		}
		
		
	}
}
