package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_10819 {
	private static int N;
	private static int arr[];
	private static int check[];
	private static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		check = new int[N];
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0,0);
		System.out.println(max);
	}
	
	private static void permutation(int cnt,int flag) {
		if(cnt==N) {
			//System.out.println(Arrays.toString(check));
			int sum = 0;
			for(int i=1; i<N; i++) {
				sum+=Math.abs(check[i]-check[i-1]);
			}
			max = Math.max(sum, max);
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i)!=0) continue;
			check[cnt] = arr[i];
			permutation(cnt+1, flag|1<<i);
			
		}
		
	}
	
}
