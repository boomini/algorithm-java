package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class g5_2470 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		int left =0;
		int right =N-1;
		int n = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0;
		while(left<right) {
			int sum = arr.get(left)+arr.get(right);
			
			if(Math.abs(sum)<n) {
				n = Math.abs(sum);
				ans1 = arr.get(left);
				ans2 = arr.get(right);
			}
			
			if(sum<0) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(ans1+" "+ans2);
		
	}
}
