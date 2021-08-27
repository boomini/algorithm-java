package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b2_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int index = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==0) {
				arr.add(i);
				index++;
			}
			else {
				arr.add(index-num, i);
				index++;
			}
		}
		
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}
}
