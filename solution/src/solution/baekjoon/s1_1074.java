package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1074 {
	private static int count = 0;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		
	}
	
	private static void search(int i,int j, int cnt) {
		if(cnt==N) return;
	}
}
