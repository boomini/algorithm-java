package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_6603 {
	private static int k;
	private static int num[];
	private static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = in.readLine();
			if(s.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(s, " ");
			k = Integer.parseInt(st.nextToken());
			num = new int[k];
			arr = new int[6];
			for(int i=0; i<k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			System.out.println();
		}
	}

	private static void combination(int cnt, int start) {
		if(cnt==6) {
			for(int i=0; i<6; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<k; i++) {
			arr[cnt] = num[i];
			combination(cnt+1, i+1);
		}
		
	}
}
