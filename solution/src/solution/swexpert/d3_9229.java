package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_9229 {
	private static int N = 0;
	private static int M = 0;
	private static int max = -1;
	private static int[] value = new int[2];
	private static int[] snack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			max = -1;
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack= new int[N];
			s = in.readLine();
			st = new StringTokenizer(s," ");
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void combination(int cnt, int start) {
		if(cnt==2) {
			//System.out.println(value.toString());
			int sum = 0;
			for(int i=0; i<2; i++) {
				sum += value[i];
			}
			if(max < sum && sum <= M) max = sum;
			return;
		}
		for(int i=start; i<N; i++) {
			value[cnt] = snack[i];
			combination(cnt+1, i+1);
		}
	}
}
