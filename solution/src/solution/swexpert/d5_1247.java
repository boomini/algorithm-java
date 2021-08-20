package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d5_1247 {
	private static int N;
	private static int arr[];
	private static boolean isSelected[];
	private static int Home[][];
	private static int startx;
	private static int starty;
	private static int endx;
	private static int endy;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			StringTokenizer st= new StringTokenizer(s," ");
			int num = N+2;
			min = Integer.MAX_VALUE;
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());
			endx = Integer.parseInt(st.nextToken());
			endy = Integer.parseInt(st.nextToken());
			Home = new int[N][2];
			isSelected = new boolean[N];
			arr = new int[N];
			for(int i=0; i<N; i++) {
				Home[i][0] = Integer.parseInt(st.nextToken());
				Home[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void permutation(int cnt) {
		if(cnt==N) {
			calcMax();
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]== true)continue;
			isSelected[i] = true;
			arr[cnt] = i;
			permutation(cnt+1);
			
			isSelected[i] = false;
			
		}
	}
	private static void calcMax() {
		int dis = 0;
		dis += Math.abs(Home[arr[0]][0] - startx) + Math.abs(Home[arr[0]][1] - starty);
		
		for(int i=1; i<N; i++) {
			dis+=Math.abs(Home[arr[i-1]][0] - Home[arr[i]][0]) + Math.abs(Home[arr[i-1]][1] - Home[arr[i]][1]);
		}
		dis += Math.abs(Home[arr[N-1]][0] - endx) + Math.abs(Home[arr[N-1]][1] - endy);
		min = Math.min(dis, min);
	}

	
}
