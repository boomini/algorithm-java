package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2_2309 {
	private static int arr[] = new int[7]; 
	private static int len[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		len= new int[9];
		for(int i=0; i<len.length; i++) {
			len[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(len);
		
		combination(0,0,0);
	}

	private static void combination(int cnt, int start, int sum) {
		if(cnt==7) {
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(arr[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		if(sum >=100) return;
		for(int i=start; i<9; i++) {
			int num = len[i];
			arr[cnt] = num;
			//if(sum>100) continue;
			if(sum+num>100) continue;
			combination(cnt+1, i+1, sum+num);
		}
		
	}
}
