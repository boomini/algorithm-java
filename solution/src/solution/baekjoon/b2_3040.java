package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2_3040 {
	private static int N = 9;
	private static int R = 7;
	private static int arr[] = new int[9];
	private static int comArr[] = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		combination(0,0);
		
	}
	private static void combination(int cnt, int start) {
		if(cnt==7) {
			int sum = 0;
			for(int i=0; i<comArr.length; i++) {
				sum += comArr[i];
			}
			if(sum==100) {
				for(int i=0; i<comArr.length; i++) {
					System.out.println(comArr[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			comArr[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
		
	}
}
