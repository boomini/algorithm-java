package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class g5_2493_02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<int[]> top = new Stack<>();
		String s= in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		StringBuilder sb = new StringBuilder();	
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[1]<num) {
						top.pop();
				}
				else {
					sb.append(top.peek()[0]).append(" ");
					break;
				}				
			}
			
			if(top.isEmpty()) sb.append(0).append(" ");
			
			top.add(new int[] {i,num});
			
		}
		System.out.println(sb.toString());
	}
}
