package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_1182 {
	private static boolean isSelected[];
	private static int N ;
	private static int S;
	private static int count=0;
	private static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		s = in.readLine();
		st = new StringTokenizer(s, " ");
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(count);
	}

	private static void subset(int cnt) {
		if(cnt==N) {
			int sum = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				if(isSelected[i]==true) {
					if(sum==Integer.MAX_VALUE) {
						sum = arr[i];
					}else {
						sum+=arr[i];
					}				
				}
				
			}
			if(sum==S) {
				count++;
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}

}
