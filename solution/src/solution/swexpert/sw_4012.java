package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class sw_4012 {

	private static int N;
	private static int R;
	private static int S[][];
	private static int arr[];
	private static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());		
			S = new int[N][N];
			R = N/2;
			arr = new int[R];
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				String s= in.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());;
					if(i>j) {
						S[j][i] += num;
					}else {
						S[i][j] += num;
					}
				}
			}
			combination(0,0);
			
			
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int cnt, int start) {
		if(cnt==R) {
			//System.out.println(Arrays.toString(arr));
			calcMin();
			return;
		}
		for(int i=start; i<N; i++) {
			arr[cnt] = i;
			if(arr[0]!=0) break;
			combination(cnt+1,i+1);
		}
	}
	

	private static void calcMin() {
		int arr2[] = new int[R];
		int index1 = 0;
		int index2 = 0;
		for(int i=0; i<N; i++) {
			if(index1<R&&arr[index1] == i) {
				index1++;
			}else {
				arr2[index2++] = i;
			}
		}
		int sum = 0;
		for (int i = 0; i < R-1; i++) {
			int num1 = arr[i];
			for (int j = i+1; j < R; j++) {
				int num2 = arr[j];
				sum+=S[num1][num2];
			}
		}
		int sum2 = 0;
		for (int i = 0; i < R-1; i++) {
			int num1 = arr2[i];
			for (int j = i+1; j < R; j++) {
				int num2 = arr2[j];
				sum2+=S[num1][num2];
			}
		}
		
		min = min>Math.abs(sum2-sum)?Math.abs(sum2-sum):min;
	}
}
