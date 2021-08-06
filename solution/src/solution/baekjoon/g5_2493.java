package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class g5_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String s= in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int top[] = new int[N];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		int check = 0, compare = 0;
		for(int i=N-1; i>0; i--) {
			check = top[i];
			for(int j=i-1; j>=0; j--) {
				compare = top[j];
				if(check<=compare) {
					sb.append(j+1).append(" ");
					break;
				}
				if(j==0) sb.append(0).append(" ");
			}
		}
		sb.append(0);
		
		System.out.println(sb.toString());
		
	}
}
